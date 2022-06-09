package GUI_PROJECT_2;

import org.jetbrains.annotations.NotNull;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private View view;
    private FileContent fileContent;

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
        view.getOpen().addActionListener(e -> openFile());

        view.getSave().addActionListener(e -> {
            try {
                saveFile();
                changeFileStatus();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        view.getSaveAs().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(view.getFrame());
            int result = fileChooser.showOpenDialog(view.getFrame());
        });

        view.getExit().addActionListener(e -> {
            System.exit(0);
        });
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
                view.getTextArea().setForeground(item.getForeground());
            });
        }

        for (JRadioButtonMenuItem item : view.getBackgroundButtonArray()) {
            item.addActionListener(e -> {
                view.getTextArea().setBackground(item.getForeground());
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

    private void initBottomLabel() {
        changeFileStatus();
        changePreviousFontSizeLabel();
    }

    private void initTextArea() {
        view.getTextArea().getDocument().addDocumentListener(new DocumentListenerAdapter());
    }

    /**
     * Refactors text from jTextArea by adding desired text at a specified caret position
     *
     * @param text
     * @return String
     */
    private String refactorText(String text) {
        String finalText = "";
        int caretPosition = view.getTextArea().getCaretPosition();
        ArrayList copyText = new ArrayList();

        for (char a : view.getTextArea().getText().toCharArray()) {
            copyText.add(a);
        }

        for (char a : text.toCharArray()) {
            copyText.add(caretPosition++, a);
        }

        for (Object a : copyText) {
            finalText += a;
        }

        return finalText;
    }

    /**
     * Changes filestatus label according to the specified enum
     */
    private void changeFileStatus() {
        switch (fileContent.getFileStatus()) {
            case NEW -> {
                view.getFileStatus().setText("New");
            }
            case SAVED -> {
                view.getFileStatus().setText("Saved");
            }
            case OPENED -> {
                view.getFileStatus().setText("Opened");
            }
            case MODIFIED -> {
                view.getFileStatus().setText("Modified");
            }
        }
    }

    /**
     * Opens a specified file by a fileChooser
     */
    private void openFile() {
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

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            view.getTextArea().setText(fileContent.getContent());
            changeFileStatus();
        }
    }

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
     * Returns extension from a given path
     *
     * @param path
     * @return String
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
            extension.append(String.valueOf(pathArray[i]));
        }
        return extension.toString();
    }

    /**
     * Changes the label to a previous font size
     */
    private void changePreviousFontSizeLabel() {
        switch (fileContent.getPreviousFontSize()) {
            case SIZE_8PT -> {
                view.getPreviousFontSize().setText("8pt");
            }
            case SIZE_10PT -> {
                view.getPreviousFontSize().setText("10pt");
            }
            case SIZE_12PT -> {
                view.getPreviousFontSize().setText("12pt");
            }
            case SIZE_14PT -> {
                view.getPreviousFontSize().setText("14pt");
            }
            case SIZE_16PT -> {
                view.getPreviousFontSize().setText("16pt");
            }
            case SIZE_18PT -> {
                view.getPreviousFontSize().setText("18pt");
            }
            case SIZE_20PT -> {
                view.getPreviousFontSize().setText("20pt");
            }
            case SIZE_22PT -> {
                view.getPreviousFontSize().setText("22pt");
            }
            case SIZE_24PT -> {
                view.getPreviousFontSize().setText("24pt");
            }
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
                addModifiedText(e);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                System.out.println("REMOVE CALL");
                removeModifiedText(e);
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            System.out.println("MODIFIED remove");
        }

        /**
         * Gets called when contents of a jTextField is modified and adds it to a fileContent.modifiedContent variable
         *
         * @param e
         * @throws BadLocationException
         */
        private void addModifiedText(DocumentEvent e) throws BadLocationException {
            Document doc = (Document) e.getDocument();
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
         * @param e
         * @throws BadLocationException
         */
        private void removeModifiedText(DocumentEvent e) throws BadLocationException {
            Document doc = (Document) e.getDocument();
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
                    changedLength = 0;
                    changeFileStatus();
                }
            }
            fileContent.setModifiedContent(view.getTextArea().getText());
            System.out.println(fileContent.getModifiedContent());
        }
    }
}
