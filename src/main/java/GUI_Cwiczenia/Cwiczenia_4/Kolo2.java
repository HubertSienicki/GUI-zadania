package GUI_Cwiczenia.Cwiczenia_4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kneiv
 */
public class Kolo2 extends Kolo implements Transformacja {
    private int previousX, previousY;

    public Kolo2(int promien, int x, int y) {
        super(promien, x, y);
        this.previousX = super.x;
        this.previousY = super.y;
    }
    
    
    
    
    @Override
    public void przesunDo(int x, int y) {
        if(this.previousX != super.x && this.previousY != super.y){
            this.previousX = super.x;
            this.previousY = super.y;
            super.x = x;
            super.y = y;
        }else{
            super.x = x;
            super.y = y;
        }
    }

    @Override
    public void powrot() {
        super.x = this.previousX;
        super.y = this.previousY;
    }
    
}
