/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author kneiv
 */
public class Main {
    public static void main(String[] args) {
        
        zadanie2();
    }
    public static void zadanie1(){
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
    }
    
    public static void zadanie2(){
        char option = JOptionPane.showInputDialog("Prosze wpisac opcje: ").charAt(0);
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
            case 'a'->{
                window.setLayout(new BorderLayout());
                window.add(button1);
                window.add(button2);
                window.add(button3);
                window.add(button4);
                window.add(button5);
                window.setVisible(true);
                break;
            }
            case 'b' -> {
                window.setLayout(new FlowLayout());
                window.add(button1);
                window.add(button2);
                window.add(button3);
                window.add(button4);
                window.add(button5);
                window.setVisible(true);
                break; 
            }
            case 'c' -> {
                window.setLayout(new FlowLayout());
                window.add(button1, FlowLayout.LEFT);
                window.add(button2, FlowLayout.LEFT);
                window.add(button3, FlowLayout.LEFT);
                window.add(button4, FlowLayout.LEFT);
                window.add(button5, FlowLayout.LEFT);
                window.setVisible(true);
                break; 
            }
            case 'd' ->{
                window.setLayout(new FlowLayout());
                window.add(button1, FlowLayout.RIGHT);
                window.add(button2, FlowLayout.RIGHT);
                window.add(button3, FlowLayout.RIGHT);
                window.add(button4, FlowLayout.RIGHT);
                window.add(button5, FlowLayout.RIGHT);
                window.setVisible(true);
                break; 
            }
        }
    }
}

