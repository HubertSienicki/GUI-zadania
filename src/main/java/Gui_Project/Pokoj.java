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
public abstract class Pokoj {
    public String type;
    private String name;
    public int days;

    public Pokoj(String type) {
        this.type = type;
    }
    
    public Pokoj(String type, int days) {
        this.type = type;
        this.days = days;
    }

    public abstract String getType();

    public abstract void setType(String type);

    public abstract String getName();
    
    public abstract int getDays();
    
    public abstract void decreaseDays();
    
    @Override
    public String toString(){
        return "Typ: " + this.type;
    }
    
    
}
