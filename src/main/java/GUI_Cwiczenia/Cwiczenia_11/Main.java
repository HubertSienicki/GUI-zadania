package GUI_Cwiczenia.Cwiczenia_11;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingAppZadanie2();
    }

    public static void SwingAppZadanie1(){
        SwingUtilities.invokeLater(
                ()->init()
        );
    }

    public static void SwingAppZadanie2(){
        SwingUtilities.invokeLater(
                ()->startApp()
        );
    }

    public static void init(){
        JFrame window = new JFrame("Hello, World!");

        window.setSize(640, 380);

        JTextArea textArea = new JTextArea();

        window.add(textArea);

        textArea.setBackground(Color.green);

        textArea.setForeground(Color.red);

        textArea.setSize(300, 150);

        Font font = new Font("Dialog", Font.BOLD + Font.ITALIC, 14);

        textArea.setFont(font);

        window.setBackground(Color.green);

        window.setVisible(true);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void startApp(){
        String option = JOptionPane.showInputDialog("Prosze wpisac opcje: ");
        JFrame window = new JFrame("Zadanie 2");
        window.setSize(640, 380);

        JButton button1 = new JButton();
        button1.setText("Przycisk 1");

        JButton button2 = new JButton();
        button2.setText("P 2");

        JButton button3 = new JButton();
        button3.setText("Wiekszy przycisk numer 3");

        JButton button4 = new JButton();
        button4.setText("Przycisk 4");

        JButton button5 = new JButton();
        button5.setText("P5");



        switch(option){
            case "a"->{
                window.setLayout(new BorderLayout());
                window.setVisible(true);
                break;
            }
            case "b" -> {
                window.setLayout(new FlowLayout());
                window.setVisible(true);
                break;
            }
            case "c" -> {
                window.setLayout(new FlowLayout(FlowLayout.LEFT));
                window.setVisible(true);
                break;
            }
            case "d" ->{
                window.setLayout(new FlowLayout(FlowLayout.RIGHT));
                window.setVisible(true);
                break;
            }
            case "e" ->{
                window.setLayout(new GridLayout(1,0));
                window.setVisible(true);
                break;
            }
            case "f" ->{
                window.setLayout(new GridLayout(0, 1));
                window.setVisible(true);
            }
            case "g" -> {
                window.setLayout(new GridLayout(3, 2));
                window.setVisible(true);
            }

            default -> {
                JOptionPane.showMessageDialog(null, "Wrong option!");
            }

        }
        window.add(button1, BorderLayout.NORTH);
        window.add(button2, BorderLayout.CENTER);
        window.add(button3, BorderLayout.EAST);
        window.add(button4, BorderLayout.SOUTH);
        window.add(button5, BorderLayout.WEST);
    }
}

