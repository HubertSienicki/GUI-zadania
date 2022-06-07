package GUI_PROJECT_2;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class View {

    View() {
        SwingUtilities.invokeLater(
                () -> initUI()
        );
    }

    private void initUI() {
        frame = new JFrame(title);
        panel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());

        createMenuBar();
        createTextArea();
        createBottomPanel();

        panel.add(menuBar, BorderLayout.PAGE_START);
        panel.add(textAreaScrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(width, height));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        createFileMenu();
        createEditMenu();
        createOptionsMenu();

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(optionsMenu);

    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");

        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.add(exit);
    }

    private void createOptionsMenu() {
        optionsMenu = new JMenu("Options");
        foregroundMenu = new JMenu("Foreground");
        backgroundMenu = new JMenu("Background");
        fontSizeMenu = new JMenu("Font size");

        for (JRadioButtonMenuItem jRadioButtonMenuItem : Arrays.asList(greenButtonForeground, orangeButtonForeground, redButtonForeground, blackButtonForeground, whiteButtonForeground, yellowButtonForeground, blueButtonForeground)) {
            foregroundMenu.add(jRadioButtonMenuItem);
        }

        for (JRadioButtonMenuItem jRadioButtonMenuItem : Arrays.asList(greenButtonBackground, orangeButtonBackground, redButtonBackground, blackButtonBackground, whiteButtonBackground, yellowButtonBackground, blueButtonBackground)) {
            backgroundMenu.add(jRadioButtonMenuItem);
        }

        for (JMenuItem item : Arrays.asList(fontSize8pt, fontSize10pt, fontSize12pt, fontSize14pt, fontSize16pt, fontSize18pt, fontSize20pt, fontSize22pt, fontSize24pt)) {
            fontSizeMenu.add(item);
        }

        optionsMenu.add(foregroundMenu);
        optionsMenu.add(backgroundMenu);
        optionsMenu.add(fontSizeMenu);
    }

    private void createEditMenu() {
        editMenu = new JMenu("Edit");
        addressMenu = new JMenu("Adresy");
        praca = new JMenuItem("Praca");
        dom = new JMenuItem("Dom");
        szkola = new JMenuItem("Szkola");

        addressMenu.add(praca);
        addressMenu.add(dom);
        addressMenu.add(szkola);
        editMenu.add(addressMenu);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textAreaScrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    private void createBottomPanel(){
        previousBackground = new JLabel("test");
        previousForground = new JLabel("test");
        previousFontSize = new JLabel("testpt");
        fileStatus = new JLabel("testStatus");
        previousInfoPanel = new JPanel(new FlowLayout());

        previousInfoPanel.add(previousForground);
        previousInfoPanel.add(previousBackground);
        previousInfoPanel.add(previousFontSize);

        bottomPanel.add(previousInfoPanel, BorderLayout.WEST);
        bottomPanel.add(fileStatus, BorderLayout.EAST);

    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public JPanel getPreviousInfoPanel() {
        return previousInfoPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getEditMenu() {
        return editMenu;
    }

    public JMenu getOptionsMenu() {
        return optionsMenu;
    }

    public JMenu getAddressMenu() {
        return addressMenu;
    }

    public JMenu getForegroundMenu() {
        return foregroundMenu;
    }

    public JMenu getBackgroundMenu() {
        return backgroundMenu;
    }

    public JMenu getFontSizeMenu() {
        return fontSizeMenu;
    }

    public JScrollPane getTextAreaScrollPane() {
        return textAreaScrollPane;
    }

    public JMenuItem getOpen() {
        return open;
    }

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getPraca() {
        return praca;
    }

    public JMenuItem getDom() {
        return dom;
    }

    public JMenuItem getSzkola() {
        return szkola;
    }

    public JRadioButtonMenuItem getGreenButtonForeground() {
        return greenButtonForeground;
    }

    public JRadioButtonMenuItem getOrangeButtonForeground() {
        return orangeButtonForeground;
    }

    public JRadioButtonMenuItem getRedButtonForeground() {
        return redButtonForeground;
    }

    public JRadioButtonMenuItem getBlackButtonForeground() {
        return blackButtonForeground;
    }

    public JRadioButtonMenuItem getWhiteButtonForeground() {
        return whiteButtonForeground;
    }

    public JRadioButtonMenuItem getYellowButtonForeground() {
        return yellowButtonForeground;
    }

    public JRadioButtonMenuItem getBlueButtonForeground() {
        return blueButtonForeground;
    }

    public JRadioButtonMenuItem getGreenButtonBackground() {
        return greenButtonBackground;
    }

    public JRadioButtonMenuItem getOrangeButtonBackground() {
        return orangeButtonBackground;
    }

    public JRadioButtonMenuItem getRedButtonBackground() {
        return redButtonBackground;
    }

    public JRadioButtonMenuItem getBlackButtonBackground() {
        return blackButtonBackground;
    }

    public JRadioButtonMenuItem getWhiteButtonBackground() {
        return whiteButtonBackground;
    }

    public JRadioButtonMenuItem getYellowButtonBackground() {
        return yellowButtonBackground;
    }

    public JRadioButtonMenuItem getBlueButtonBackground() {
        return blueButtonBackground;
    }

    public JMenuItem getFontSize8pt() {
        return fontSize8pt;
    }

    public JMenuItem getFontSize10pt() {
        return fontSize10pt;
    }

    public JMenuItem getFontSize12pt() {
        return fontSize12pt;
    }

    public JMenuItem getFontSize14pt() {
        return fontSize14pt;
    }

    public JMenuItem getFontSize16pt() {
        return fontSize16pt;
    }

    public JMenuItem getFontSize18pt() {
        return fontSize18pt;
    }

    public JMenuItem getFontSize20pt() {
        return fontSize20pt;
    }

    public JMenuItem getFontSize22pt() {
        return fontSize22pt;
    }

    public JMenuItem getFontSize24pt() {
        return fontSize24pt;
    }

    public JLabel getPreviousForground() {
        return previousForground;
    }

    public JLabel getPreviousBackground() {
        return previousBackground;
    }

    public JLabel getPreviousFontSize() {
        return previousFontSize;
    }

    public JLabel getFileStatus() {
        return fileStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    //Variables DO NOT EDIT
    private final int width = 600;
    private final int height = 400;
    private String title = "Notepad";
    private JFrame frame;
    private JPanel panel;
    private JPanel bottomPanel;
    private JPanel previousInfoPanel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu optionsMenu;
    private JMenu addressMenu;
    private JMenu foregroundMenu;
    private JMenu backgroundMenu;
    private JMenu fontSizeMenu;
    private JScrollPane textAreaScrollPane;

    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem exit;
    private JMenuItem praca;
    private JMenuItem dom;
    private JMenuItem szkola;

    private JRadioButtonMenuItem greenButtonForeground = new JRadioButtonMenuItem("Green");
    private JRadioButtonMenuItem orangeButtonForeground = new JRadioButtonMenuItem("Orange");
    private JRadioButtonMenuItem redButtonForeground = new JRadioButtonMenuItem("Red");
    private JRadioButtonMenuItem blackButtonForeground = new JRadioButtonMenuItem("Black");
    private JRadioButtonMenuItem whiteButtonForeground = new JRadioButtonMenuItem("White");
    private JRadioButtonMenuItem yellowButtonForeground = new JRadioButtonMenuItem("Yellow");
    private JRadioButtonMenuItem blueButtonForeground = new JRadioButtonMenuItem("Blue");
    private JRadioButtonMenuItem greenButtonBackground = new JRadioButtonMenuItem("Green");
    private JRadioButtonMenuItem orangeButtonBackground = new JRadioButtonMenuItem("Orange");
    private JRadioButtonMenuItem redButtonBackground = new JRadioButtonMenuItem("Red");
    private JRadioButtonMenuItem blackButtonBackground = new JRadioButtonMenuItem("Black");
    private JRadioButtonMenuItem whiteButtonBackground = new JRadioButtonMenuItem("White");
    private JRadioButtonMenuItem yellowButtonBackground = new JRadioButtonMenuItem("Yellow");
    private JRadioButtonMenuItem blueButtonBackground = new JRadioButtonMenuItem("Blue");

    private JMenuItem fontSize8pt = new JMenuItem("8 pt");
    private JMenuItem fontSize10pt = new JMenuItem("10 pt");
    private JMenuItem fontSize12pt = new JMenuItem("12 pt");
    private JMenuItem fontSize14pt = new JMenuItem("14 pt");
    private JMenuItem fontSize16pt = new JMenuItem("16 pt");
    private JMenuItem fontSize18pt = new JMenuItem("18 pt");
    private JMenuItem fontSize20pt = new JMenuItem("20 pt");
    private JMenuItem fontSize22pt = new JMenuItem("22 pt");
    private JMenuItem fontSize24pt = new JMenuItem("24 pt");

    private JLabel previousForground;
    private JLabel previousBackground;
    private JLabel previousFontSize;
    private JLabel fileStatus;
}
