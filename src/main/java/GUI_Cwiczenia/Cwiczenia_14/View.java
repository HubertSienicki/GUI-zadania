package GUI_Cwiczenia.Cwiczenia_14;

import javax.swing.*;
import java.awt.*;

public class View {


    public View() {
        init();
    }

    private void init(){
        mainFrame = new JFrame();
        mainPanel = new JPanel(new BorderLayout());

        list = new JList<>();
        scrollPanel = new JScrollPane(list);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textField = new JTextField();

        mainPanel.add(textField, BorderLayout.PAGE_START);
        mainPanel.add(scrollPanel, BorderLayout.CENTER);
        mainFrame.add(mainPanel);

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("Capitals");
        mainFrame.setSize(new Dimension(250, 300));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JList getList() {
        return list;
    }

    public void setList(JList list) {
        this.list = list;
    }

    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }

    public void setScrollPanel(JScrollPane scrollPanel) {
        this.scrollPanel = scrollPanel;
    }

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JTextField textField;
    private JList list;
    private JScrollPane scrollPanel;
}
