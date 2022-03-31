/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_3;

/**
 *
 * @author kneiv
 */
abstract class Figura implements Obliczanie {
    int x, y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public abstract String getName();
    
    public abstract void pozycja(int dx, int dy);
    
    @Override
    public String toString(){
       return this.getName() + "\n";
    }
}
