package GUI_PROJECT_2;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class View {

    View() {
        initUI();
    }

    private void initUI() {
        String title = "Notepad";
        frame = new JFrame(title);

        JPanel panel = new JPanel(new BorderLayout());
        bottomPanel = new JPanel(new BorderLayout());

        createMenuBar();
        createTextArea();
        createBottomPanel();

        panel.add(menuBar, BorderLayout.PAGE_START);
        panel.add(textAreaScrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        int height = 1080;
        int width = 1920;

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
        this.exit = new JMenuItem("Exit");

        fileMenu.setMnemonic(KeyEvent.VK_F);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        fileMenu.add(exit);
    }

    private void createOptionsMenu() {
        optionsMenu = new JMenu("Options");
        foregroundMenu = new JMenu("Foreground");
        backgroundMenu = new JMenu("Background");
        fontSizeMenu = new JMenu("Font size");

        generateButtons();
        generateFontButtons();

        fontIndex = 0;

        optionsMenu.setMnemonic(KeyEvent.VK_O);

        optionsMenu.add(foregroundMenu);
        optionsMenu.add(backgroundMenu);
        optionsMenu.add(fontSizeMenu);
    }

    private void createEditMenu() {
        editMenu = new JMenu("Edit");
        JMenu addressMenu = new JMenu("Adresy");
        praca = new JMenuItem("Praca");
        dom = new JMenuItem("Dom");
        szkola = new JMenuItem("Szkola");

        praca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
        dom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
        szkola.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));

        editMenu.setMnemonic(KeyEvent.VK_E);

        addressMenu.add(praca);
        addressMenu.add(dom);
        addressMenu.add(szkola);
        editMenu.add(addressMenu);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textAreaScrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    }

    private void createBottomPanel() {
        previousBackground = new JLabel();
        previousForeground = new JLabel();
        previousFontSize = new JLabel();
        fileStatus = new JLabel();


        previousFontSize.setPreferredSize(new Dimension(20, 20));

        JPanel previousInfoPanel = new JPanel(new FlowLayout());

        previousInfoPanel.add(previousForeground);
        previousInfoPanel.add(previousBackground);
        previousInfoPanel.add(previousFontSize);

        bottomPanel.add(previousInfoPanel, BorderLayout.WEST);
        bottomPanel.add(fileStatus, BorderLayout.EAST);

    }

    public Icon returnIcon(@NotNull Colors color, int x, int y) {
        switch (color) {
            case RED -> {
                return new IconCreator(Color.red, x, y);
            }
            case BLUE -> {
                return new IconCreator(Color.BLUE, x, y);
            }
            case BLACK -> {
                return new IconCreator(Color.BLACK, x, y);
            }
            case GREEN -> {
                return new IconCreator(Color.GREEN, x, y);
            }
            case WHITE -> {
                return new IconCreator(Color.WHITE, x, y);
            }
            case ORANGE -> {
                return new IconCreator(Color.ORANGE, x, y);
            }
            case YELLOW -> {
                return new IconCreator(Color.YELLOW, x, y);
            }
        }
        return null;
    }

    /**
     * Generates font buttons
     */
    private void generateFontButtons() {
        for (int i = 0; i < fontSizeButtons.length; i++) {
            fontSizeButtons[i] = new JMenuItem();

            fontSizeButtons[i].setFont(fontTable[i]);
            fontSizeButtons[i].setText(fontTable[i].getSize() + "pt");

            fontSizeMenu.add(fontSizeButtons[i]);
        }
    }

    /**
     * Generates background and foreground buttons
     */
    private void generateButtons() {
        for (int i = 0; i < backgroundButtons.length; i++) {

            backgroundButtons[i] = new JRadioButtonMenuItem();
            foregroundButtons[i] = new JRadioButtonMenuItem();

            JLabel backgroundButtonLabel = new JLabel(new IconCreator(colorTable[colorIndex], 16, 0));
            JLabel foregroundButtonLabel = new JLabel(new IconCreator(colorTable[colorIndex], 16, 0));

            foregroundButtons[i].setPreferredSize(new Dimension(80, 20));
            foregroundButtonLabel.setText("     " + colorNames[i]);
            foregroundButtonLabel.setForeground(colorTable[colorIndex]);

            backgroundButtons[i].setPreferredSize(new Dimension(80, 20));
            backgroundButtonLabel.setText("     " + colorNames[i]);
            backgroundButtonLabel.setForeground(colorTable[colorIndex]);

            backgroundButtons[i].add(backgroundButtonLabel);
            backgroundButtons[i].setForeground(colorTable[colorIndex]);

            foregroundButtons[i].add(foregroundButtonLabel);
            foregroundButtons[i].setForeground(colorTable[colorIndex]);

            foregroundMenu.add(foregroundButtons[i]);
            foregroundButtonGroup.add(foregroundButtons[i]);

            backgroundButtonGroup.add(backgroundButtons[i]);
            backgroundMenu.add(backgroundButtons[i]);

            colorIndex++;
        }
        colorIndex = 0;
    }

    //-------------------------Getters and setters-------------------------//
    public void setPreviousForegroundLabel(Icon previousForegroundIcon) {
        this.previousForeground.setIcon(previousForegroundIcon);
    }

    public void setPreviousBackgroundLabel(Icon previousBackgroundIcon) {
        this.previousBackground.setIcon(previousBackgroundIcon);
    }

    public JLabel getPreviousBackgroundLabel() {
        return previousBackground;
    }

    public JLabel getPreviousForegroundLabel() {
        return previousForeground;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
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
        return this.exit;
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

    public JLabel getPreviousFontSize() {
        return previousFontSize;
    }

    public JLabel getFileStatus() {
        return fileStatus;
    }

    //Variables DO NOT EDIT
    Color[] colorTable = {Color.green, Color.orange, Color.red, Color.black, Color.white, Color.yellow, Color.blue};
    String[] colorNames = {"Green", "Orange", "Red", "Black", "White", "Yellow", "Blue"};

    private JFrame frame;
    private JPanel bottomPanel;
    private JTextArea textArea;
    private JScrollPane textAreaScrollPane;
    
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu optionsMenu;
    private JMenu foregroundMenu;
    private JMenu backgroundMenu;
    private JMenu fontSizeMenu;

    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem saveAs;
    private JMenuItem exit;
    private JMenuItem praca;
    private JMenuItem dom;
    private JMenuItem szkola;

    private JLabel previousForeground;
    private JLabel previousBackground;
    private JLabel previousFontSize;
    private JLabel fileStatus;

    public JRadioButtonMenuItem[] getForegroundButtonArray() {
        return foregroundButtons;
    }

    public JRadioButtonMenuItem[] getBackgroundButtonArray() {
        return backgroundButtons;
    }

    public JMenuItem[] getFontSizeItemArray() {
        return fontSizeButtons;
    }

    private final ButtonGroup foregroundButtonGroup = new ButtonGroup();
    private final ButtonGroup backgroundButtonGroup = new ButtonGroup();

    private final JRadioButtonMenuItem[] foregroundButtons = new JRadioButtonMenuItem[7];
    private final JRadioButtonMenuItem[] backgroundButtons = new JRadioButtonMenuItem[7];
    private final JMenuItem[] fontSizeButtons = new JMenuItem[9];

    int colorIndex = 0;
    Font[] fontTable = {new Font("JetBrains Mono", Font.PLAIN, 8), new Font("JetBrains Mono", Font.PLAIN, 10), new Font("JetBrains Mono", Font.PLAIN, 12), new Font("JetBrains Mono", Font.PLAIN, 14), new Font("JetBrains Mono", Font.PLAIN, 16), new Font("JetBrains Mono", Font.PLAIN, 18), new Font("JetBrains Mono", Font.PLAIN, 20), new Font("JetBrains Mono", Font.PLAIN, 22), new Font("JetBrains Mono", Font.PLAIN, 24)};
    int fontIndex = 0;
}