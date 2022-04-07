/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_4;

import java.util.Iterator;

       // java.lang.Iterable
class IterNap implements Iterable<Character> {
	
	private final String sentence;
        private int beginning = 0;
        private int step = 1;

    public IterNap(String sentence) {
        this.sentence = sentence;
    }
    
    public void ustawPoczatek(int beginning){
        this.beginning = beginning;
    }
    
    public void ustawKrok(int step){
        this.step = step;
    }
       

        @Override
	public Iterator<Character> iterator() {

		// return new WlasnyIterator<Character>(...);
		return new Iterator<Character>(){

	        	private int currentIndex = beginning;
                        private boolean notPassed = true;
                        
                        //Czy istnieje nastepny element oraz czy zdanie nie jest puste
                        @Override
			public boolean hasNext() {
                                if(currentIndex == 0){
                                    return currentIndex < sentence.length() && !sentence.isEmpty();  
                                }else{
                                    return currentIndex + step < sentence.length() && !sentence.isEmpty();
                                }                         
                        }
                        
                        //Zwracanie nastepnego elementu
                        @Override
			public Character next() {
                            if(notPassed){
                                notPassed = false;
                                return sentence.charAt(currentIndex);
                            }else{
                                return sentence.charAt(currentIndex += step);
                            }
                            
			}
                        
                        
                        @Override
                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
		};
	}
}