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

public class Dwojka extends Pokoj {
    
    private int days;
    
    public Dwojka(String type, int days) {
        super(type);
        this.days = days;
    }
    
    @Override
    public int getDays(){
        return this.days;
    }
    
    @Override
    public void decreaseDays() {
        this.days -= 1;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
    @Override
    public String getName(){
        return "dwojka";
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
    public String toString() {
        return " Typ: " + super.type + ", Nazwa: " + this.getName() + ", Ilosc dni: " + this.getDays();
    }
    
}
