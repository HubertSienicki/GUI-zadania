package GUI_Cwiczenia.Cwiczenia_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class Spiewak {
    private String nazwisko;
    private static int p = 1; //Increments with each new object
    private int numerStartowy;

    abstract String spiewaj();

    public Spiewak(String nazwisko){
        this.nazwisko = nazwisko;
        this.numerStartowy = p++;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getNumerStartowy() {
        return numerStartowy;
    }

    @Override
    public String toString(){
        return "(" +  this.getNumerStartowy() + ") " + this.getNazwisko() + ": " + this.spiewaj();
    }

    public static String najglosniej(Spiewak[] Spiewacy){
        int tempIndex = 0;
        char[] points = new char[Spiewacy.length]; //Points array
        
        for (int i = 0; i < points.length; i++) {
            points[i] = 0;
        }
        ArrayList voiceFormatted = new ArrayList(); 

        for(Spiewak s : Spiewacy){
            char[] voice = s.spiewaj().toLowerCase().toCharArray(); // Changes to lowercase, function is not case sensetive
            // Adding the formatted voice into the arraylist
            for (int i = 0; i < voice.length; i++) {
                System.out.println((byte) voice[i]);
                if ((byte) voice[i] >= 97 & (byte) voice[i] <= 122) { //using ascii values, evaluate if a character is within a desired range (only letters)
                    voiceFormatted.add(voice[i]);
                }
            }
            
            for (int i = 0; i < voiceFormatted.size() ; i++) {
                for (int j = 0; j < voiceFormatted.size() ; j++) {
                    if(voiceFormatted.get(i) != voiceFormatted.get(j)){ // Searching if an element is not duplicated
                        points[tempIndex] += 1; //If element is not
                    }
                }
            }
            tempIndex++;
            voiceFormatted = new ArrayList(); //Resetting arraylist after one iteration
        }
        tempIndex = 0;
        System.out.println(Arrays.toString(points));
        System.out.println(voiceFormatted.toString());
        System.out.println(tempIndex);
        for (int i = 0; i < points.length - 1 ; i++) {
            if(points[i] < points[i+1]){
                tempIndex = i+1;
            }
        }
        return Spiewacy[tempIndex].toString();
    }
}
