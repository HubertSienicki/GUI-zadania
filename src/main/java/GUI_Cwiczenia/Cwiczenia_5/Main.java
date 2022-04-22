/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_5;

/**
 *
 * @author kneiv
 */
public class Main {

    public static void main(String[] args) {
        ArrayBox<Integer> box = new ArrayBox<>(2);
        box.add(1);
        box.add(2);

        box.add(4);

        box.add(5);

        box.add(7);
        box.print();
        
        Integer[] tab = {1,2,4};
        
        box.addAll(tab);
        
        box.print();
        
        box.delete(3);
        
        box.print();
        
        box.swap(0,2);
        
        box.print();
    }
}
