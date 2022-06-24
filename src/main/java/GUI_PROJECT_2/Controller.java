package GUI_PROJECT_2;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Controls and merges data between View class and fileContent class
 */
public class Controller {
    private final View view;
    private final FileContent fileContent;

    public Controller(View view, FileContent fileContent) {
        this.view = view;
        this.fileContent = fileContent;
    }

    /**
     * Initializes the controller
     */
    public void initController() {
        initFileMenu();
        initEditMenu();
        initOptionsMenu();
        initBottomLabel();
        initTextArea();
    }

    /**
     * Initializes file menu
     */
    private void initFileMenu() {
        view.getOpen().addActionListener(e -> {
            try {
                openFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        view.getSave().addActionListener(e -> {
            try {
                saveFile();
                changeFileStatus();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        view.getSaveAs().addActionListener(e -> saveAsFile());

        view.getExit().addActionListener(e -> System.exit(0));
    }

    /**
     * Initializes edit menu
     */
    private void initEditMenu() {
        view.getPraca().addActionListener(e -> {
            String text = "Przytorowa 8";
            view.getTextArea().setText(refactorText(text));
        });

        view.getDom().addActionListener(e -> {
            String text = "Jankowska 5";
            view.getTextArea().setText(refactorText(text));
        });

        view.getSzkola().addActionListener(e -> {
            String text = "Koszykowa 86";
            view.getTextArea().setText(refactorText(text));
        });
    }

    /**
     * Initializes options menu
     */
    private void initOptionsMenu() {
        for (JRadioButtonMenuItem item : view.getForegroundButtonArray()) {
            item.addActionListener(e -> {
                fileContent.setPreviousForeground(fileContent.getCurrentForeground());

                view.getTextArea().setForeground(item.getForeground());

                fileContent.setCurrentForeground(enumerateColors(item.getForeground()));

                setBottomLabels();

            });
        }

        for (JRadioButtonMenuItem item : view.getBackgroundButtonArray()) {
            item.addActionListener(e -> {
                fileContent.setPreviousBackground(fileContent.getCurrentBackground());

                view.getTextArea().setBackground(item.getForeground());

                fileContent.setCurrentBackground(enumerateColors(item.getForeground()));

                setBottomLabels();
            });
        }

        for (JMenuItem item : view.getFontSizeItemArray()) {
            item.addActionListener(e -> {
                view.getTextArea().setFont(item.getFont());
                setFileContentFontSize();
                changePreviousFontSizeLabel();
            });
        }
    }

    /**
     * Initializes bottom labels
     */
    private void initBottomLabel() {
        changeFileStatus();
        changePreviousFontSizeLabel();
        setBottomLabels();
    }

    /**
     * Sets previous background and foreground labels
     */
    private void setBottomLabels() {
        view.getPreviousBackgroundLabel().setText("bg");
        view.getPreviousForegroundLabel().setText("fg");
        view.setPreviousBackgroundLabel(view.returnIcon(fileContent.getPreviousBackground(), 0, 0));
        view.setPreviousForegroundLabel(view.returnIcon(fileContent.getPreviousForeground(), 0, 0));
    }

    /**
     * Initializes text area
     */
    private void initTextArea() {
        view.getTextArea().getDocument().addDocumentListener(new DocumentListenerAdapter());
    }

    /**
     * Refactors text from jTextArea by adding desired text at a specified caret position
     *
     * @param text Text to add a constant to
     * @return String
     */
    private String refactorText(String text) {
        StringBuilder finalText = new StringBuilder();
        int caretPosition = view.getTextArea().getCaretPosition();
        ArrayList<Character> copyText = new ArrayList<>();

        for (char a : view.getTextArea().getText().toCharArray()) {
            copyText.add(a);
        }

        for (char a : text.toCharArray()) {
            copyText.add(caretPosition++, a);
        }

        for (Object a : copyText) {
            finalText.append(a);
        }

        return finalText.toString();
    }

    /**
     * Changes fileStatus label according to the specified enum
     */
    private void changeFileStatus() {
        switch (fileContent.getFileStatus()) {
            case NEW -> view.getFileStatus().setText("New");

            case SAVED -> view.getFileStatus().setText("Saved");

            case OPENED -> view.getFileStatus().setText("Opened");

            case MODIFIED -> view.getFileStatus().setText("Modified");

            case CREATED -> view.getFileStatus().setText("Created and saved");
        }
    }

    /**
     * Translates a color to Colors enumerator
     *
     * @param color color to translate to enumerator
     * @return Colors enumerator
     */
    private Colors enumerateColors(Color color) {
        if (color.equals(Color.green)) {
            return Colors.GREEN;
        } else if (color.equals(Color.orange)) {
            return Colors.ORANGE;
        } else if (color.equals(Color.red)) {
            return Colors.RED;
        } else if (color.equals(Color.BLACK)) {
            return Colors.BLACK;
        } else if (color.equals(Color.yellow)) {
            return Colors.YELLOW;
        } else if (color.equals(Color.BLUE)) {
            return Colors.BLUE;
        } else if (color.equals(Color.white)) {
            return Colors.WHITE;
        }
        return null;
    }

    /**
     * Opens a specified file by a fileChooser
     */
    private void openFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to open");
        int result = fileChooser.showOpenDialog(view.getFrame());

        if (result == JFileChooser.APPROVE_OPTION) {

            if (fileContent.getFileStatus() != FileStatus.NEW) {
                fileContent.setContent("");
                fileContent.setExtension("");   //RESET if user opens another file
                fileContent.setFilename("");
                view.getTextArea().setText(fileContent.getContent());
            }

            fileContent.setSelectedFile(fileChooser.getSelectedFile());
            fileContent.setFilename(fileContent.getSelectedFile().getAbsolutePath());
            fileContent.setExtension(extractExtension(fileContent.getFilename()));
            try {
                readFile();
                view.getFrame().setTitle(fileContent.getFilename());

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(view.getFrame(), "The system could not find the file specified for :"
                        + fileContent.getFilename()
                        + "\n... Creating a file");
                Files.write(Paths.get(fileContent.getFilename()), "".getBytes(), StandardOpenOption.CREATE);
                readFile();
            }

            view.getTextArea().setText(fileContent.getContent());
            changeFileStatus();
        }
    }

    /**
     * Reads a file provided in fileContent
     *
     * @throws FileNotFoundException if file is not found
     */
    private void readFile() throws FileNotFoundException {
        Scanner reader = new Scanner(fileContent.getSelectedFile());

        if (reader.hasNextLine()) {
            fileContent.setFileStatus(FileStatus.OPENED);
            String data = reader.nextLine() + "\n";
            fileContent.setContent(fileContent.getContent() + data);
            while (reader.hasNextLine()) {
                fileContent.setFileStatus(FileStatus.OPENED);
                data = reader.nextLine() + "\n";
                fileContent.setContent(fileContent.getContent() + data);
            }
        } else {
            fileContent.setFileStatus(FileStatus.OPENED);
            fileContent.setContent(" ");
        }
        reader.close();
    }

    /**
     * Saves the text to a file, works like a quick save
     * @throws IOException Used to recreate the original file in order to save it;
     */
    public void saveFile() throws IOException {
        try {
            if (fileContent.getFileStatus() == FileStatus.NEW) {
                Files.write(Paths.get(fileContent.getFilename()), fileContent.getContent().getBytes(), StandardOpenOption.APPEND);

                fileContent.setContent(view.getTextArea().getText());
                fileContent.setFileStatus(FileStatus.SAVED);

            } else if (fileContent.getFileStatus() == FileStatus.OPENED || fileContent.getFileStatus() == FileStatus.MODIFIED) {
                fileContent.setContent(fileContent.getModifiedContent());
                fileContent.setModifiedContent("");
                fileContent.setFileStatus(FileStatus.SAVED);

                Files.delete(Paths.get(fileContent.getFilename()));
                Files.write(Paths.get(fileContent.getFilename()), fileContent.getContent().getBytes(), StandardOpenOption.APPEND);

            }
        } catch (IOException e) {
            Files.write(Paths.get(fileContent.getFilename()), fileContent.getContent().getBytes(), StandardOpenOption.CREATE); //To jest prawdopodobnie najbardziej leniwe rozwiazanie na jakie kiedykolwiek wpadlem
        }
    }

    /**
     * Saves a file to a specified place and format
     */
    private void saveAsFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file name and extension");

        int result = fileChooser.showSaveDialog(view.getFrame());

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                fileContent.setFilename(fileChooser.getSelectedFile().getAbsolutePath());
                fileContent.setContent(fileContent.getModifiedContent());
                fileContent.setModifiedContent("");

                Files.write(Paths.get(fileContent.getFilename()), fileContent.getContent().getBytes(), StandardOpenOption.CREATE);
                fileContent.setFileStatus(FileStatus.CREATED);

                changeFileStatus();

                view.getFrame().setTitle(fileContent.getFilename());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view.getFrame(), "Program could not save the file to a specified location.");
            }
        }
    }


    /**
     * Returns extension from a given path
     *
     * @param path path to a file
     * @return String extension of a file
     */
    private @NotNull String extractExtension(@NotNull String path) {
        int tempIndex = 0;
        boolean flag = false;
        char[] pathArray = path.toCharArray();
        StringBuilder extension = new StringBuilder();

        while (!flag) {
            if (pathArray[tempIndex] == '.') {
                flag = true;
            } else {
                if (tempIndex + 1 == pathArray.length) {
                    JOptionPane.showMessageDialog(view.getFrame(), "The file does not have a specified extension. Please chose a correct file.");
                } else {
                    tempIndex++;
                }
            }
        }

        for (int i = tempIndex; i < pathArray.length; i++) {
            extension.append(pathArray[i]);
        }
        return extension.toString();
    }

    /**
     * Changes the label to a previous font size
     */
    private void changePreviousFontSizeLabel() {
        switch (fileContent.getPreviousFontSize()) {
            case SIZE_8PT -> view.getPreviousFontSize().setText("8pt");
            case SIZE_10PT -> view.getPreviousFontSize().setText("10pt");
            case SIZE_12PT -> view.getPreviousFontSize().setText("12pt");
            case SIZE_14PT -> view.getPreviousFontSize().setText("14pt");
            case SIZE_16PT -> view.getPreviousFontSize().setText("16pt");
            case SIZE_18PT -> view.getPreviousFontSize().setText("18pt");
            case SIZE_20PT -> view.getPreviousFontSize().setText("20pt");
            case SIZE_22PT -> view.getPreviousFontSize().setText("22pt");
            case SIZE_24PT -> view.getPreviousFontSize().setText("24pt");
        }
    }

    /**
     * Changes the fontsize enum of a FileContent object
     */
    private void setFileContentFontSize() {
        switch (view.getTextArea().getFont().getSize()) {
            case 8 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_8PT);
            }
            case 10 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_10PT);
            }
            case 12 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_12PT);
            }
            case 14 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_14PT);
            }
            case 16 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_16PT);
            }
            case 18 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_18PT);
            }
            case 20 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_20PT);
            }
            case 22 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_22PT);
            }
            case 24 -> {
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_24PT);
            }
            default -> throw new IllegalStateException("Unexpected value: " + view.getTextArea().getFont().getSize());
        }
    }

    /**
     * Getting called each time jTextArea is changed in any way.
     */
    class DocumentListenerAdapter implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
                System.out.println("ADD CALL");
                addModifiedText();
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                System.out.println("REMOVE CALL");
                removeModifiedText();
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("UNUSED CHANGED UPDATE");
        }

        /**
         * Gets called when contents of a jTextField is modified and adds it to a fileContent.modifiedContent variable
         *
         * @throws BadLocationException Gets thrown if a file is not found
         */
        private void addModifiedText() throws BadLocationException {
            int changedLength = view.getTextArea().getText().length() - fileContent.getContent().length();
            System.out.println(changedLength);

            if (changedLength > 0) {
                if (!fileContent.getFileStatus().equals(FileStatus.NEW)) {
                    fileContent.setFileStatus(FileStatus.MODIFIED);
                    changeFileStatus();
                }
            }
            fileContent.setModifiedContent(view.getTextArea().getText());
            System.out.println(fileContent.getModifiedContent());
        }

        /**
         * Gets called if there is a removed content from a modified file
         *
         * @throws BadLocationException Gets thrown if a file is not found
         */
        private void removeModifiedText() throws BadLocationException {
            int changedLength = view.getTextArea().getText().length() - fileContent.getContent().length();
            System.out.println(changedLength);

            if (changedLength == 0) {
                if (!fileContent.getFileStatus().equals(FileStatus.NEW)) {
                    fileContent.setFileStatus(FileStatus.OPENED);   //IF LENGTH OF A MODIFIED FILE GOES BACK TO ZERO, CHANGE THE LABEL BACK TO OPENED BECAUSE THE FILE IS NOT MODIFIED

                    changeFileStatus();
                }
            } else if (changedLength < 0) {
                if (!fileContent.getFileStatus().equals(FileStatus.NEW)) {
                    fileContent.setFileStatus(FileStatus.MODIFIED);

                    changeFileStatus();
                }
            }
            fileContent.setModifiedContent(view.getTextArea().getText());
            System.out.println(fileContent.getModifiedContent());
        }
    }

}
