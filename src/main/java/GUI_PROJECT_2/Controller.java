package GUI_PROJECT_2;

import javax.swing.*;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void initController() {
        initFileMenu();
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

        for(JMenuItem item : view.getFontSizeItemArray()){
            item.addActionListener(e -> {
                view.getTextArea().setFont(item.getFont());
            });
        }
    }
}
