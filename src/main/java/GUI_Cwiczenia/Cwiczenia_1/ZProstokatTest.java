/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_1;

public class ZProstokatTest {

    public static void main(String[] args) {

        ZProstokat zp[] = {
                new ZProstokat(4, 'a', 'e'),		// konstruktor z 3 parametrami
                new ZProstokat(5, 3 , '*', '+'),	// konstruktor z 4 parametrami
                new ZProstokat(1, 2, 'a','a'),
                new ZProstokat(3, 3, '+', 'x'),
                new ZProstokat(1, 2, 'x', 'y'),
                new ZProstokat(3, 4, '^', '$')
        };

        for (ZProstokat z : zp)
            try {
                z.rysuj();
            } catch(ZProstokatException e) {
                System.out.println(e.getMessage());
                System.out.println("");
            }
    }
}

class ZProstokat{

    private int w, h; //width , height

    private char b;	// border character
    private char i; // inside character

    private static int p = 1; //static variable, increments with each new object
    private static int k = 1;

    private int numP;
    private int numK;

    public ZProstokat(int w, int h, char i, char b){

        this.w = w;
        this.h = h;
        this.i = i;
        this.b = b;

        if(this.w == this.h){
            numK = k++;
        }else{
            numP = p++;
        }
    }

    public ZProstokat(int w, char i, char b){
        this(w,w,i,b);
    }

    public void rysuj() throws ZProstokatException
    {
        //Width and height should be different integers > 1
        //If either width or height = 1, then char I or B should be the same, if not throw exception
        /* Constraints :
        * All Sides of the rectangle should be filled with character B
        * The inside of a rectangle should be filled with character I
        * If the rectangle is of width or height = 1 , then it should be of one character*/

        if(this.w >= 1 & this.h >= 1 ){

                int bCounter = 0;
                int iCounter = 0;

                for (int j = 0; j < this.h; j++) {
                    for (int k = 0; k < this.w; k++) { //Drawing Rectangles
                        //Borders : When k == 0 or k == this.w - 1
                        // When j == 0 or j == this.h -1 ;
                        if(k == this.w - 1){
                            bCounter += 1;
                        }else {
                            if(k == 0 || k == this.w - 1 || j == 0 || j == this.h - 1){
                                bCounter +=1;
                            }else{
                                iCounter +=1;
                            }
                        }
                    }
                }

                if(this.h == 1 || this.w == 1 ){
                    System.out.println("Prostokat (" + this.numP + ")" + " rozmiaru " + this.h + "x" + this.w +
                            ", " + this.b + " = " + bCounter);
                }else{
                    if(this.h == this.w){
                        System.out.println("Kwadrat (" + this.numK + ")" + " rozmiaru " + this.h + "x" + this.w +
                                ", " + this.i + " = " + iCounter + ", " + this.b + " = " + bCounter);
                    }
                    else System.out.println("Prostokat (" + this.numP + ")" + " rozmiaru " + this.h + "x" + this.w +
                            ", " + this.i + " = " + iCounter + ", " + this.b + " = " + bCounter);
                }
            if((this.w == 1 || this.h == 1) & !(this.b == this.i)){
                throw new ZProstokatException("B??dny prostok?t");
            }else{

                    for (int j = 0; j < this.h; j++) {
                        for (int k = 0; k < this.w; k++) { //Drawing Rectangles
                            //Borders : When k == 0 or k == this.w - 1
                            // When j == 0 or j == this.h -1 ;
                            if(k == this.w - 1){
                                System.out.println(this.b);
                            }else {
                                if(k == 0 || k == this.w - 1 || j == 0 || j == this.h - 1){
                                    System.out.print(this.b);
                                }else{
                                    System.out.print(this.i);
                                }
                            }
                        }
                    }
                }
            }
        System.out.println("");
        }

    }

class ZProstokatException extends Exception {

    public ZProstokatException(String errorMessage){
        super(errorMessage);
    }
}
