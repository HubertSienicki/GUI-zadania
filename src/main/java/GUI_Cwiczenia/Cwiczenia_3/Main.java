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
public class Main {
        public static void main(String[] args)
    {       
        Figura fig[] = new Figura[2];
        fig[0] = new Kolo(10, 10, 5);                    // po?o?enie ko?a = srodek = (10,10), promie? = 5
        fig[1] = new Prostokat(20, 20, 15, 10);    // po?o?enie prostok?ta = lewy górny wierzcho?ek = (20,20), szeroko?? = 15, wysoko?? = 10
      
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

        k2.powrot();                    // powrót do poprzedniej pozycji (bezpo?rednio przed przesuni?ciem) ?rodka ko?a
        System.out.println(k2);
    
    }
}
