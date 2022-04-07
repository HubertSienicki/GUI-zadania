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

abstract class Figura implements Obliczanie, Comparable<Figura>{
    int x, y;

    private int numerFigury = 0;
    static int p = 0;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
        numerFigury = p++;
    }
    
    public abstract String getName();

    public double Area(){
        if(this instanceof Kolo){
            return 3.14 * Math.pow(((Kolo) this).promien, 2);
        }else if (this instanceof Prostokat){
            return ((Prostokat) this).szerokosc * ((Prostokat) this).wysokosc;
        }
        return 0;
    };

    @Override
    public double Radius() {
        if(this instanceof Kolo){
            return 2*3.14* ((Kolo) this).promien;
        }else if(this instanceof Prostokat){
            return 2* ((Prostokat) this).szerokosc + 2 * ((Prostokat) this).wysokosc;
        }
        return 0;
    }

    public abstract void pozycja(int dx, int dy);
    
    @Override
    public String toString(){
       return this.getName() + "\n";
    }

    @Override
    public int compareTo(Figura f)
    {
        // obiekty: this, f
        // obiekt1.compareTo(obiekt2)

        if (this.Area() - f.Area() < 0)
            return -1;	// < 0
        else if (this.Area() - f.Area() > 0)
            return 1; 	// > 0
        else if (this.Area() == f.Area()){
            if(this.Radius() - f.Radius() < 0){
                return -1;//teraz sprawdzamy obwody
            }else if(this.Radius() - f.Radius() > 0){
                return 1;
            }
        }else if(this.Radius() == f.Radius()){
            if(this.numerFigury - f.numerFigury < 0){
                return -1;
            }else if(this.numerFigury - f.numerFigury > 0){
                return 1;
            }
        }
        return 0;
    }
}
