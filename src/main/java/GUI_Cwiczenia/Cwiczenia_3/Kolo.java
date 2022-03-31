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
public class Kolo extends Figura {
    double promien;
    private final double pi = 3.14;

    @Override
    public String getName() {
        return "Kolo";
    }

    @Override
    public void pozycja(int dx, int dy) {
        double radius = 2 * pi * this.promien;
        
        if((Math.pow((dx - super.x), 2) + Math.pow((dy - super.y), 2)) < radius){
            System.out.println("Punkt(" + dx +", " + dy + ") znajduje sie wewnatrz kola");
            System.out.println("");
        }else {
            System.out.println("Punkt(" + dx +", " + dy + ") nie znajduje sie wewnatrz kola");
            System.out.println("");
        }
    }

    public Kolo(int x, int y, int promien) {
        super(x, y);
        this.promien = promien;
    }
    
    @Override
    public String toString(){
        return super.toString() 
                + "Srodek - (" + super.x + ", " + super.y + ")" + "\n" 
                + "Promien - " + this.promien + "\n";
    }    

    @Override
    public double Area() {
        return pi * Math.pow(this.promien, 2);
    }

    @Override
    public double Radius() {
        return 2 * pi * this.promien;
    }
}
