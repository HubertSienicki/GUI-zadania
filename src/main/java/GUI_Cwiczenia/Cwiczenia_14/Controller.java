package GUI_Cwiczenia.Cwiczenia_14;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.AbstractList;

public class Controller {
    
    public Controller(@NotNull View view, Model model) {
        this.view = view;
        this.model = model;
    }


    public void init(){
        view.getList().setModel(model);

        view.getTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    if(!view.getTextField().getText().isEmpty()){
                        model.addToModel(view.getTextField().getText());
                        view.getList().repaint();
                    }
                }
            }
        });

        view.getList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                    if(view.getList().getSelectedValue() != null){
                        System.out.println(view.getList().getSelectedValue());
                    }
                }else if(e.getClickCount() == 2){
                    model.remove(view.getList().getSelectedIndex());
                    view.getList().repaint();
                }
            }
        });
    }

    private View view;
    private Model model;
}
