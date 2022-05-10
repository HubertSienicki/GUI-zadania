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
public class Klient {
    private String name;
    private int capital;
    private final ArrayList<Pokoj> pokoje = new ArrayList<>();
    private String platnosc;
    private final ListaZyczen listaZyczen = new ListaZyczen();
    private Koszyk koszyk;
    
    public Klient(String name, int capital) {
        this.name = name;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }
    
    public void zaplac(String formaPlatnosci){
        Cennik cennik = Cennik.pobierzCennik();
        
        switch (formaPlatnosci) {
            case "karta" -> {
                for(Pokoj pokoj : pokoje){
                    if((capital - (cennik.getPrice(pokoj.getType(), pokoj.getName()) * pokoj.getDays())) < 0){
                        for (int i = 0; i < pokoj.getDays(); i++) {
                            if((capital - cennik.getPrice(pokoj.getType(), pokoj.getName())) > 0){
                                capital -= cennik.getPrice(pokoj.getType(), pokoj.getName());
                                pokoj.decreaseDays();
                            }
                        }
                    }else{
                        break;
                    }
                }
            }
            case "przelew" -> pokoje.forEach(pokoj -> {
                    if((capital - (cennik.getPrice(pokoj.getType(), pokoj.getName()) * pokoj.getDays())) < 0){
                        for (int i = 0; i < pokoj.getDays(); i++) {
                            if((capital - cennik.getPrice(pokoj.getType(), pokoj.getName())) > 0){
                                capital -= cennik.getPrice(pokoj.getType(), pokoj.getName());
                                pokoj.decreaseDays();
                            }
                        }
                    }else{
                        capital -= (cennik.getPrice(pokoj.getType(), pokoj.getName()) * pokoj.getDays());
                        this.koszyk.usunZKoszyka(pokoj);
                    }
            });

            default -> {
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int pobierzPortfel() {
        return capital;
    }

    
    public void przepakuj(Koszyk koszyk){
        Cennik cennik = Cennik.pobierzCennik();
        this.koszyk = koszyk;
        
        pokoje.stream().filter(pokoj -> (cennik.getPrice(pokoj.getType(), pokoj.getName()) > 0)).map(pokoj -> {
            koszyk.dodajDoKoszyka(pokoj);
            return pokoj;
        }).forEachOrdered(pokoj -> {
            listaZyczen.usunZListy(pokoj);
        });
        
        for (int i = 0; i < listaZyczen.getZyczenia().size(); i++) {
            pokoje.remove(listaZyczen.getZyczenia().get(i));
        }
    }
    
    public void dodaj(Pokoj pokoj){
        pokoje.add(pokoj);
        listaZyczen.dodajDoListy(pokoj);
    }
    
    public Koszyk pobierzKoszyk(){
        return this.koszyk;
    }
    
    public ListaZyczen pobierzListeZyczen(){
        return listaZyczen;
    }
    
    @Override
    public String toString(){
        return "Nazwa klienta: " + this.getName() + "Kapital " + this.getName() + ": " + this.pobierzPortfel();
    }
}
