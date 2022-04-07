package GUI_Cwiczenia.Cwiczenia_4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kneiv
 */
public class Prostokat extends Figura {
    int wysokosc, szerokosc;

    @Override
    public String getName() {
        return "Prostokat";
    }

    public Prostokat(int wysokosc, int szerokosc, int x, int y) {
        super(x, y); //Lewy gorny wierzcholek
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc; //Prawy dolny wierzcholek
    }
    
    

    @Override
    public void pozycja(int dx, int dy) {
        if(dx >= super.x && dx <= this.szerokosc + super.x && dy >= super.y && dy <= this.wysokosc + super.y){
            System.out.println("Punkt(" + dx +", " + dy + ") znajduje sie wewnatrz prostokata");
            System.out.println("");
        }else{
            System.out.println("Punkt(" + dx +", " + dy + ") nie znajduje sie wewnatrz prostokata");
            System.out.println("");
        }
    }
    
    @Override
    public String toString(){
        return super.toString()
                + "Lewy Gorny - (" + super.x + ", " + super.y + ")" + "\n" 
                + "Szerokosc: " + this.szerokosc + ", " + "Wysokosc: " + this.wysokosc + "\n";
    }

    @Override
    public double Area() {
        return this.szerokosc * this.wysokosc;
    }

    @Override
    public double Radius() {
        return 2 * this.szerokosc + 2 * this.wysokosc;
    }

    
}
