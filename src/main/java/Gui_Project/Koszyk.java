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
public class Koszyk {
    private final ArrayList<Pokoj> koszyk = new ArrayList<>();
    private final Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
    }
    
    public void dodajDoKoszyka(Pokoj pokoj){
        this.koszyk.add(pokoj);
    }
    
    public void usunZKoszyka(Pokoj pokoj){
        this.koszyk.remove(pokoj);
    }
    
    public ArrayList getKoszyk(){
        return koszyk;
    }
    
    public String pobierzKoszyk(){
        return this.toString();
    }
    
    @Override
    public String toString(){
        if(koszyk.isEmpty()){
            return "--pusto \n";
        }else{
            String tempString = "";
        
            for (int i = 0; i < koszyk.size(); i++) {
                tempString += koszyk.get(i);
            }
            
            tempString += "\n";
            return tempString;
        }
    }
    
}
