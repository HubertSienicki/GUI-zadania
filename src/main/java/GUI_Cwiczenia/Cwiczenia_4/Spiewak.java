package GUI_Cwiczenia.Cwiczenia_4;



import java.util.ArrayList;
import java.util.Arrays;

public abstract class Spiewak implements Comparable<Spiewak> {
    private String nazwisko;
    private static int p = 1; //Increments with each new object
    private int numerStartowy;

    abstract String spiewaj();

    public Spiewak(String nazwisko) {
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
    public String toString() {
        return "(" + this.getNumerStartowy() + ") " + this.getNazwisko() + ": " + this.spiewaj();
    }

    public static Spiewak najglosniej(Spiewak[] Spiewacy) {
        int tempIndex = 0;
        char[] points = new char[Spiewacy.length]; //Points array

        for (int i = 0; i < points.length; i++) {
            points[i] = 0;
        }

        ArrayList voiceFormatted = new ArrayList();

        for (Spiewak s : Spiewacy) {
            char[] voice = s.spiewaj().toLowerCase().toCharArray(); // Changes to lowercase, function is not case sensetive
            // Adding the formatted voice into the arraylist
            for (int i = 0; i < voice.length; i++) {
                if ((byte) voice[i] >= 97 & (byte) voice[i] <= 122) { //using ascii values, evaluate if a character is within a desired range (only letters)
                    voiceFormatted.add(voice[i]);
                }
            }

            for (int i = 0; i < voiceFormatted.size(); i++) {
                for (int j = 0; j < voiceFormatted.size(); j++) {
                    if (voiceFormatted.get(i) != voiceFormatted.get(j)) { // Searching if an element is not duplicated
                        points[tempIndex] += 1; //If element is not
                    }
                }
            }
            tempIndex++;
            voiceFormatted = new ArrayList(); //Resetting arraylist after one iteration
        }
        tempIndex = 0;
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] < points[i + 1]) {
                tempIndex = i + 1;
            }
        }
        return Spiewacy[tempIndex];
    }

    public int findPoints() {
        int points = 0;

        ArrayList voiceFormatted = new ArrayList();

        char[] voice = this.spiewaj().toLowerCase().toCharArray(); // Changes to lowercase, function is not case sensetive
        // Adding the formatted voice into the arraylist
        for (int i = 0; i < voice.length; i++) {
            if ((byte) voice[i] >= 97 & (byte) voice[i] <= 122) { //using ascii values, evaluate if a character is within a desired range (only letters)
                voiceFormatted.add(voice[i]);
            }
        };
        ArrayList charsUsed = new ArrayList();

        for (int i = 0; i < voiceFormatted.size(); i++) {
            for (int j = 0; j < voiceFormatted.size(); j++) {
                if (voiceFormatted.get(i) != voiceFormatted.get(j)) { // Searching if an element is not duplicated
                    if(!charsUsed.contains(voiceFormatted.get(i))){
                        points++;
                        charsUsed.add(voiceFormatted.get(i));
                    }
                }
            }
        }
        return points;
    }

    @Override
    public int compareTo (Spiewak spiewak2){
        if(this.findPoints() != spiewak2.findPoints()){
            if(this.findPoints() - spiewak2.findPoints() > 0){
                return -1;
            }
            else if (this.findPoints() - spiewak2.findPoints() < 0){
                return 1;
            }
            return 0;
        }else if(!this.nazwisko.equals(spiewak2.getNazwisko())){
            return this.getNazwisko().compareTo(spiewak2.getNazwisko());
        }else{
            if(this.getNumerStartowy() - spiewak2.getNumerStartowy() > 0){
                return 1;
            }else if(this.getNumerStartowy() - spiewak2.getNumerStartowy() < 0){
                return -1;
            }
        }
    return 0;
    }
}