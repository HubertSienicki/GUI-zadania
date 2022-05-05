/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_Project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kneiv
 */
public class ListaZyczen{
   private final ArrayList<Pokoj> Zyczenia = new ArrayList<>();

    public ListaZyczen() {
    }
    
    public ArrayList<Pokoj> getZyczenia(){
        return this.Zyczenia;
    }
    
    public void usunZListy(Pokoj pokoj){
        for (int i = 0; i < Zyczenia.size(); i++) {
            if(Zyczenia.get(i).getName().equals(pokoj.getName()) && Zyczenia.get(i).getType().equals(pokoj.getType())){
                this.Zyczenia.remove(pokoj);
            }
        }
    }
    
    public void dodajDoListy(Pokoj pokoj){
        Zyczenia.add(pokoj);
    }
   
   @Override
   public String toString(){
       String s = "{ ";
       
       for (Pokoj pokoj : Zyczenia) {
           s += "{";
           s += pokoj.toString();
           s += "}, ";
       }
       s += "}";
       s += "\n";
       
       return s;
   }
   
}
