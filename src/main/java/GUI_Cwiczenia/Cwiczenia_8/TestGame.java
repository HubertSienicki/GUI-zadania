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
public class TestGame {

    public static void main(String[] args)
    {
        Player p1 = new Player("ppj");                                            // tworzenie gracza ze swoim identyfikatorem
        Player p2 = new Player("gui");
        Player p3 = new Player("pjc");

        Referee ref = new Referee(10, new Player[]{p1,p2, p3});                       // arbiter ustala czas gry (w sekundach), "rejestruje" tablic? graczy

        ref.startGame();                                                          // arbiter startuje swój w?tek: mierzy czas oraz daje sygna? startu graczom

        try {
            ref.join();                                                           // czekamy, a? w?tek arbitra zako?czy swoj? prac?, tzn. po up?ywie okre?lonego czasu przerywa prac? w?tków wszystkich graczy

            // join() jest metod? z klasy Thread

        } catch (InterruptedException exc){

        }

        ref.result();                                                              // arbiter og?asza wynik gry

    }
}
