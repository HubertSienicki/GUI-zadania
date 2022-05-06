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
public class Referee extends Thread{
    private final int time;
    private final Player[] p1;

    public Referee(int time, Player[] p1) {
        super("Ref");
        this.time = time;
        this.p1 = p1;
    }

    void startGame(){
        this.start();
        for (Player player : p1) {
            player.start();
        }
    }

    @Override
    public void run(){
        int tempCounter = 0;
        while(tempCounter <= time){
           try{
               sleep(1000);
               System.out.println("Czas: " + tempCounter);
               for (Player p : p1) {
                   System.out.println(p.getName() + ": " + p.getPoints());
               }
               System.out.println();
               tempCounter++;
           }catch(InterruptedException e){
               return;
           }
        }
        for (Player player : p1) {
            player.interrupt();
        }
    }

    public void result(){
        Player temp = p1[0];
        boolean tie = true;
        for (Player player : p1) {
            System.out.println("Wynik " + player.getName() + ": " + player.getSum());

            if(temp.getSum() != player.getSum()){
                tie = false;
                if (temp.getSum() < player.getSum()) {
                    temp = player;
                }
            }
        }
        if(tie){
            System.out.println("Remis miedzy wszystkimi graczami");
        }else{
            System.out.println(temp.getName() + " wygral!");
        }
    }
    
}

