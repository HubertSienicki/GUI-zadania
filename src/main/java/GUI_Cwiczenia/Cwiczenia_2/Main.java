/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_2;

/**
 *
 * @author kneiv
 */
public class Main {
    public static void main(String[] args)
    {
    	Spiewak s1 = new Spiewak("Dietrich"){
          @Override
          protected String spiewaj(){
              return "oooooooooooo";
          }
        };
  
        Spiewak s2 = new Spiewak("Piaf"){
          @Override
          protected String spiewaj(){
              return "a4iBBiii";
          }
        };
  
        Spiewak s3 = new Spiewak("Adele"){
          @Override
          protected String spiewaj(){
              return "aAa";
          }
        };
        Spiewak s4 = new Spiewak("Hubert"){
          @Override
          protected String spiewaj(){  //Test spiewak
              return "abcdefghijklmnoprstuwxyz";
          }
        };
  
        Spiewak sp[] = {s1, s2, s3, s4};
  
        for (Spiewak s : sp)
            System.out.println(s);
        
        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
