/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_Project;

/**
 *
 * @author kneiv
 */
public class Jedynka extends Pokoj  {
    
    
    
    public Jedynka(String type) {
        super(type);
    }

    public Jedynka(String type, int days) {
        super(type, days);
    }
   
    @Override
    public String getType() {
        return super.type;
    }

    @Override
    public void setType(String type) {
        super.type = type;
    }

    @Override
    public String getName() {
        return "jedynka";
    }
    
    @Override
    public int getDays(){
        return super.days;
    }
    
    public void setDays(int days){
        this.days = days;
    }

    @Override
    public String toString(){
         return "Typ: " + super.type + ", Nazwa: " + this.getName() + ", Ilosc dni: " + this.getDays();
    }

    @Override
    public void decreaseDays() {
        this.days -= 1;
    }
    
    
}
