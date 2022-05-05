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
public class Trojka extends Pokoj {
    private int days;

    public Trojka(String type) {
        super(type);
    }
    
    public Trojka(String type, int days) {
        super(type);
        this.days = days;
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
        return "trojka";
    }
    
     @Override
    public void decreaseDays() {
        super.days -= 1;
    }
    
    @Override
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
    
    @Override
    public String toString(){
        return "Typ: " + super.type + ", Nazwa: " + this.getName() + ", Ilosc dni: " + this.getDays();
    }
    
    
}