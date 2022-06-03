package GUI_Cwiczenia.Cwiczenia_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Zadanie2 {
    public static void main(String[] args) {
        new Zadanie2();
    }

    public Zadanie2() {
        SwingUtilities.invokeLater(() -> run());
    }

    protected void run() {
        JFrame mainFrame = new JFrame("App");
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new BorderLayout());

        JPanel buttonGroup1 = new JPanel(new FlowLayout());
        JPanel buttonGroup2 = new JPanel(new FlowLayout());
        JPanel calc = new JPanel(new GridLayout(3, 3));
        JPanel textFields = new JPanel(new GridLayout(3, 1));

        JButton R = new JButton("FR");
        R.setBackground(Color.red);

        JButton G = new JButton("FG");  // top left
        G.setBackground(Color.green);

        JButton B = new JButton("FB");
        B.setBackground(Color.blue);

        JButton A = new JButton("A");
        JButton b = new JButton("B"); //top right
        JButton C = new JButton("C");

        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5"); //bottom right
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");


        buttonGroup1.add(R);
        buttonGroup1.add(G);
        buttonGroup1.add(B);

        buttonGroup2.add(A);
        buttonGroup2.add(b);
        buttonGroup2.add(C);

        topPanel.add(buttonGroup1, BorderLayout.WEST);
        topPanel.add(buttonGroup2, BorderLayout.EAST);
        mainPanel.add(topPanel, BorderLayout.PAGE_START);

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(1000, 2000));
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        centerPanel.add(scrollPane);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        calc.add(one);
        calc.add(two);
        calc.add(three);
        calc.add(four);
        calc.add(five);
        calc.add(six);
        calc.add(seven);
        calc.add(eight);
        calc.add(nine);
        bottomPanel.add(calc, BorderLayout.WEST);

        JTextField textField1 = new JTextField("Pole tekstowe 1 typu JTextField");
        textField1.setPreferredSize(new Dimension(300, 20));
        JTextField textField2 = new JTextField("Pole tekstowe 2 typu JTextField");
        textField2.setPreferredSize(new Dimension(300, 20));
        JTextField textField3 = new JTextField("Pole tekstowe 3 typu JTextField");
        textField3.setPreferredSize(new Dimension(300, 20));

        textFields.add(textField1);
        textFields.add(textField2);
        textFields.add(textField3);

        bottomPanel.add(textFields, BorderLayout.EAST);

        mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);

        R.addActionListener((e) -> {
            JButton src = (JButton) (e.getSource());
            textArea.setForeground(src.getBackground());
        });
        G.addActionListener((e) -> {
            JButton src = (JButton) (e.getSource());
            textArea.setForeground(src.getBackground());
        });
        B.addActionListener((e) -> {
            JButton src = (JButton) (e.getSource());
            textArea.setForeground(src.getBackground());
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textArea.setText(textArea.getText() + textField1.getText() +
                            "\n");
                }
            }
        });

        textField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textArea.setText(textArea.getText() + textField2.getText() +
                            "\n");
                }
            }
        });

        textField3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    textArea.setText(textArea.getText() + textField3.getText() +
                            "\n");
                }
            }
        });

        abstract class KeyAdapter implements KeyListener {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        }
    }
}
