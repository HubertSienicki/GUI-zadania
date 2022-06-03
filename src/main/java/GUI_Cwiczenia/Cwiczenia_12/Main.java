package GUI_Cwiczenia.Cwiczenia_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main implements ActionListener{
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        SwingUtilities.invokeLater(
                () -> run()
        );
    }

    public void run(){
        JFrame MainWindow = new JFrame();

        JPanel MainPanel = new JPanel(new GridLayout());

        JButton button = new JButton();
        button.addActionListener(this);

        MainPanel.add(button);
        MainWindow.add(MainPanel);

        MainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainWindow.pack();
        MainWindow.setResizable(true);
        MainWindow.setVisible(true);

    }
    int index = 0;
    Color colorTable[] = {Color.red, Color.blue, Color.pink, Color.green, Color.MAGENTA};
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton src = (JButton) e.getSource();
        if(index == 4){
            this.index = 0;
        }
        src.setBackground(colorTable[index++]);
    }

    private class InnerHandler implements ActionListener{
        int index = 0;
        Color colorTable[] = {Color.red, Color.blue, Color.pink, Color.green, Color.MAGENTA};
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            if(index == 4){
                this.index = 0;
            }
            src.setBackground(colorTable[index++]);
        }
    }
}
