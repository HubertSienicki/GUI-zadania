package GUI_Cwiczenia.Cwiczenia_4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GUI_Cwiczenia.Cwiczenia_4.Rysowanie;

/**
 *
 * @author kneiv
 */
public class Prostokat2 extends Prostokat implements Rysowanie {
    private char znak;
    
    public Prostokat2(int wysokosc, int szerokosc, int x, int y, char znak) {
        super(wysokosc, szerokosc, x, y);
        this.znak = znak;
    }
    
    @Override
    public void rysuj() {
        for (int i = 0; i < super.y; i++) {
            for (int j = 0; j < super.x; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    
}
