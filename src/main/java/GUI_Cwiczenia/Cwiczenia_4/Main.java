package GUI_Cwiczenia.Cwiczenia_4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kneiv
 */
public class Main {
        public static void main(String[] args)
    {       
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // po?o?enie ko?a = srodek = (10,10), promie? = 5
        fig[1] = new Prostokat(20, 20, 15, 10);    // po?o?enie prostok?ta = lewy g�rny wierzcho?ek = (20,20), szeroko?? = 15, wysoko?? = 10
      
            // polimorficzne wywo?anie metody toString() z klas Kolo/Prostokat,
            // a nie z klasy Figura
        for (Figura f : fig)              // p?tla for-each
            System.out.println(f);    // System.out.println(f.toString());
      
        fig[0].pozycja(12, 12);                    
        fig[1].pozycja(25, 30);
        
        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');       // prostok?t rozmiaru 10 x 5 b?dzie "rysowany" na konsoli za pomoc? znaku '*'
        ((Prostokat2)p2).rysuj();                             //Poniewaz p2 jest obiektem klasy figura, a metoda rysuj nalezy do klasy prostokat2, dlatego nalezy wywolac ja z miejsca klasy prostokat2 a nie klasy figura
        
        Kolo2 k2 = new Kolo2(15, 20, 5);
       
        k2.przesunDo(50, 40);    // przesuni?cie ?rodka ko?a do punktu (50, 40)
        System.out.println(k2);

        k2.powrot();                    // powr�t do poprzedniej pozycji (bezpo?rednio przed przesuni?ciem) ?rodka ko?a
        System.out.println(k2);


        Spiewak s3 = new Spiewak("Darrey") {
            @Override
            String spiewaj() {
                return "bebe";
            }
        };

        Spiewak s4 = new Spiewak("Darrey") {
            @Override
            String spiewaj() {
                return "eeae";
            }
        };

        Spiewak s1 = new Spiewak("Houston") {
            @Override
            String spiewaj() {
                return "a4iBBiii";
            }
        };

        Spiewak s2 = new Spiewak("Carrey") {
            @Override
            String spiewaj() {
                return "ooaooooooo";
            }
        };
        Spiewak s5 = new Spiewak("Madonna") {
            @Override
            String spiewaj() {
                return "aAa";
            }
        };

        ArrayList<Spiewak> spiewacy = new ArrayList<>();
        spiewacy.add(s1);
        spiewacy.add(s2);
        spiewacy.add(s3);
        spiewacy.add(s4);
        spiewacy.add(s5);

        System.out.println(s3.findPoints());
        System.out.println(s4.findPoints());
        Collections.sort(spiewacy);

        System.out.println(spiewacy);

        ArrayList<Figura> figury = new ArrayList<>();

        figury.add(new Kolo(1,1,5));
        figury.add(new Prostokat(9,4,1,1));
        figury.add(new Prostokat(6,6,2,2));

        Collections.sort(figury);

        for (int i = 0; i < figury.size() ; i++) {
            System.out.println(figury.get(i).toString());
        }
        
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

            // iteracja po znakach napisu,
            // domy?lnie zaczynaj?c od pierwszego znaku (o indeksie 0)
            // i z krokiem iteracji = 1
        for (char z: napis)
            System.out.print(z + " ");
   
        System.out.println();

        napis.ustawPoczatek(2);     // ustawienie pocz?tku iteracji (tu: 2-gi znak, o indeksie 2)
        napis.ustawKrok(3);         // ustawienie kroku iteracji (tu: co 3-ci znak)
   
            // iteracja po znakach napisu,
            // od ustalonego znaku, z okre?lonym krokiem
        for (char z: napis)
            System.out.print(z + " ");

        System.out.println("");
        System.out.println("");
            
        
	napis.forEach((Character z) -> {
            System.out.print(z.toString().toLowerCase());
        });		
	

    }
}
