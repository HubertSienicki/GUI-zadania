package GUI_PROJECT_2;

import javax.swing.*;
import java.io.FileNotFoundException;
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
    }


    /**
     * Initializes file menu
     */
    private void initFileMenu() {
        view.getOpen().addActionListener(e -> openFile());

        view.getSave().addActionListener(e -> {
            //TODO:INTEGRATE MNEMONIC TO FILE SAVING
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

    private void initBottomLabel(){
        changeFileStatus();
        changePreviousFontSizeLabel();
    }

    /**
     * Refactors text from jTextArea by adding desired text at a specified caret position
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
    private void openFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to open");
        int result = fileChooser.showOpenDialog(view.getFrame());

        if (result == JFileChooser.APPROVE_OPTION) {

            fileContent.setSelectedFile(fileChooser.getSelectedFile());
            fileContent.setFilename(fileContent.getSelectedFile().getAbsolutePath());
            fileContent.setExtension(extractExtension(fileContent.getFilename()));

            try {

                Scanner reader = new Scanner(fileContent.getSelectedFile());

                while (reader.hasNextLine()) {
                    fileContent.setFileStatus(FileStatus.OPENED);
                    String data = reader.nextLine() + "\n";
                    fileContent.setContent(data);
                }

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        view.getTextArea().setText(fileContent.getContent());
        changeFileStatus();
    }

    /**
     * Returns extension from a given path
     * @param path
     * @return String
     */
    private String extractExtension(String path) {
        int tempIndex = 0;
        boolean flag = false;
        char[] pathArray = path.toCharArray();
        String extension = "";

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
            extension += String.valueOf(pathArray[i]);
        }
        return extension;
    }

    /**
     * Changes the label to a previous font size
     */
    private void changePreviousFontSizeLabel(){
        switch (fileContent.getPreviousFontSize()){
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
    private void setFileContentFontSize(){
        switch(view.getTextArea().getFont().getSize()){
            case 8 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_8PT);
                break;
            case 10 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_10PT);
                break;
            case 12 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_12PT);
                break;
            case 14 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_14PT);
                break;
            case 16 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_16PT);
                break;
            case 18 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_18PT);
                break;
            case 20 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_20PT);
                break;
            case 22 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_22PT);
                break;
            case 24 :
                fileContent.setPreviousFontSize(fileContent.getCurrentFontSize());
                fileContent.setFontSize(UsedFontSize.SIZE_24PT);
                break;
        }
    }



}
