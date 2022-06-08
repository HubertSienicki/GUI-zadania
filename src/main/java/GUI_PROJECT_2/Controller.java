package GUI_PROJECT_2;

import javax.swing.*;
import java.util.ArrayList;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void initController() {
        initFileMenu();
        initEditMenu();
        initOptionsMenu();
    }


    private void initFileMenu() {
        view.getOpen().addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(view.getFrame());
        });

        view.getSave().addActionListener(e -> {
            //TODO: INVOKE SAVE METHOD TO A FILE
        });

        view.getSaveAs().addActionListener(e -> {
            //TODO: INVOKE SAVE AS METHOD AND A FILE CHOOSER
        });

        view.getExit().addActionListener(e -> {
            System.exit(0);
        });
    }

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
            });
        }
    }

    private String refactorText(String text){
        String finalText = "";
        int caretPosition = view.getTextArea().getCaretPosition();
        ArrayList copyText = new ArrayList();

        for (char a : view.getTextArea().getText().toCharArray()) {
            copyText.add(a);
        }

        for (char a : text.toCharArray()){
            copyText.add(caretPosition++, a);
        }

        for (Object a : copyText){
            finalText += a;
        }
        return finalText;
    }
}
