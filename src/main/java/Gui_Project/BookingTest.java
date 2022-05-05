/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_Project;

import java.util.ArrayList;

/**
 *
 * @author kneiv
 */
public class BookingTest {
  
	// cena pokoi (o podanym typie) z koszyka 
  static int cena(Koszyk k, String typ) {
      ArrayList<Pokoj> temp;
      temp = k.getKoszyk();
      int price = 0;
      
      Cennik cennik = Cennik.pobierzCennik();
      System.out.println(temp);
      for (int i = 0; i < temp.size(); i++) {
          if(temp.get(i).getType().equals(typ)){
              price += (cennik.getPrice(temp.get(i).getType(), temp.get(i).getName())) * temp.get(i).getDays();
              System.out.println(price);
          }
      }
      return price;
  }

  public static void main(String[] args) {
   
		// cennik
	Cennik cennik = Cennik.pobierzCennik();
 
		// dodawanie nowych cen do cennika
    	cennik.dodaj("jedynka", "standard", 4, 100, 80);	// pokój jednoosobowy typu standardowego kosztuje 100 z?/noc je?li klient zarezerwuje mniej ni? 4 noce, 
    								// w innym przypadku kosztuje 80 z?/noc
 
    	cennik.dodaj("dwojka", "budzet", 140);			// pokój dwuosobowy typu bud?etowego kosztuje 140 z?/noc niezale?nie od liczby nocy
 
    	cennik.dodaj("trojka", "standard", 300);		// pokój trzyosobowy typu standardowego kosztuje 300 z?/noc niezale?nie od liczby nocy

	cennik.dodaj("rodzina", "premium", 500);		// pokój rodzinny typu premium kosztuje 500 z?/noc niezale?nie od liczby nocy
        
   		// Klient ocean deklaruje kwot? 2200 z? na rezerwacje
    	Klient ocean = new Klient("ocean", 2200);

    		// Klient ocean dodaje do listy ?ycze? ró?ne rodzaje pokoi: 
		// 4 noce w pokoju jednoosobowym typu standardowego, 5 nocy w pokoju trzyosobowym typu standardowego, 
		// 3 noce w pokoju dwuosobowym typu premium, 3 noce w pokoju dwuosobowym bud?etowym
    	ocean.dodaj(new Jedynka("standard", 4));
    	ocean.dodaj(new Trojka("standard", 5));
    	ocean.dodaj(new Dwojka("premium", 3));
    	ocean.dodaj(new Dwojka("budzet", 2));
		
		// Lista ?ycze? klienta ocean   	
	ListaZyczen listaOceanu = ocean.pobierzListeZyczen();
 
    	System.out.println("Lista zyczen klienta " + listaOceanu);

		// Przed p?aceniem, klient przepakuje pokoje z listy ?ycze? do koszyka.
		// Mo?liwe, ?e na li?cie ?ycze? s? pokoje niemaj?ce ceny w cenniku,
    		// w takim przypadku zosta?yby usuni?te z koszyka (ale nie z listy ?ycze?)     	
	Koszyk koszykOceanu = new Koszyk(ocean);
    	ocean.przepakuj(koszykOceanu);

    		// Co jest na li?cie ?ycze? klienta ocean
    	System.out.println("Po przepakowaniu, lista zyczen klienta " + ocean.pobierzListeZyczen());

		// Co jest w koszyku klienta ocean
	System.out.println("Po przepakowaniu, koszyk klienta " + koszykOceanu); 

		// Ile wynosi cena wszystkich pokoi typu standardowego w koszyku klienta ocean
    	System.out.println("Pokoje standardowe w koszyku klienta ocean kosztowaly:  "
        	+ cena(koszykOceanu, "standard"));

    		// Klient zap?aci...
    	ocean.zaplac("karta");	// p?aci kart? p?atnicz?, bez prowizji

    		// Ile klientowi ocean zosta?o pieni?dzy?
    	System.out.println("Po zaplaceniu, klientowi ocean zostalo: " + ocean.pobierzPortfel() + " zl");
	
    		// Mog?o klientowi zabrakn?? srodków, wtedy pokoje s? odk?adane,
		// w innym przypadku koszyk jest pusty po zap?aceniu 
    	System.out.println("Po zaplaceniu, koszyk klienta " + ocean.pobierzKoszyk());
	System.out.println("Po zaplaceniu, koszyk klienta " + koszykOceanu); 	
 
		// Teraz przychodzi klient morze,
    		// deklaruje 780 z? na rezerwacje
    	Klient morze = new Klient("morze", 780);

    		// Zarezerwowa? za du?o jak na t? kwot?
	morze.dodaj(new Jedynka("standard", 3));
    	morze.dodaj(new Dwojka("budzet", 4));
    
    		// Co klient morze ma na swojej li?cie ?ycze?
    	System.out.println("Lista zyczen klienta " + morze.pobierzListeZyczen());
		
		// Przepakowanie z listy ?ycze? do koszyka,
		// mo?e si? okaza?, ?e na li?cie ?ycze? s? pokoje niemaj?ce ceny w cenniku,
    		// w takim razie zosta?yby usuni?te z koszyka (ale nie z listy ?ycze?)     		
	Koszyk koszykMorza = new Koszyk(morze);
    	morze.przepakuj(koszykMorza);
	
    		// Co jest na li?cie ?ycze? morze
    	System.out.println("Po przepakowaniu, lista zyczen klienta " + morze.pobierzListeZyczen());

	    	// A co jest w koszyku klienta morze
    	System.out.println("Po przepakowaniu, koszyk klienta " + morze.pobierzKoszyk());
    	
		// klient morze p?aci
    	morze.zaplac("przelew");	// p?aci przelewem, prowizja 10 z?
		
		// Ile klientowi morze zosta?o pieni?dzy? 
	System.out.println("Po zaplaceniu, klientowi morze zosta?o: " + morze.pobierzPortfel() + " zl");
		
		// Co zosta?o w koszyku klienta morze (za ma?o pieni?dzy mia?)
 	System.out.println("Po zaplaceniu, koszyk klienta " + koszykMorza); 	

   }
}
