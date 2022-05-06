/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_8;

/**
 *
 * @author kneiv
 */
import java.util.Random;

public class Player extends Thread{
    private int sum;
    private int points;

    public Player(String name){
        super(name);
    }

    public int getSum() {
        return sum;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public void run(){
        while(true){
            Random r = new Random();

            int rand = r.nextInt(1000);
            try{
                sleep(rand);
            }catch(InterruptedException e){
                return;
            }
            points = r.nextInt(100) + 1;
            sum += this.points;
        }
    }
}

