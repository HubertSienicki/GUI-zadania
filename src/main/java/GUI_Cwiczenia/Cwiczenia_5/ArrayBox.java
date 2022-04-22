/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author kneiv
 * @param <T>
 */

public class ArrayBox<T> {

    private int size;
    private Object[] container;
    private int currentIndex = 0;

    /**
     *
     * @param size
     */
    public ArrayBox(int size) {
        container = new Object[size];
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean add(T element) {
        if (search(element)) {
            System.out.println("Duplication of elements");
            return false;

        } else {
            if (willFit()) {
                scaleContainer();
                this.container[currentIndex++] = element;
                return true;
            } else {
                this.container[currentIndex++] = element;
                return true;
            }
        }
    }
    
    public boolean delete(T element){
        int index = getIndex(element);
        if(index > -1){
            this.container[index] = null;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean swap(int pos, int des){
        if(des > size){
            return false;
        }else{
            if(pos < 0){
                return false;
            }else{
                T temp = (T) this.container[pos];
                this.container[pos] = this.container[des];
                this.container[des] = temp;
                return true;
            }
        }
    }
    
    public boolean addAll(T[] tab){
        boolean flag = false;
        
        for (T tab1 : tab) {
            if(search(tab1) == false){    
                if (willFit()) {
                    scaleContainer();
                    this.container[currentIndex++] = tab1;
                    flag = true;
                }else{
                    this.container[currentIndex++] = tab1;
                    flag = true;
                }
            }
        }
        
        return flag;
    }

    //--------------HELPER METHODS-------------//
    private boolean search(T element) { //If element is duplicated return true;
        for (int i = 0; i < size; i++) {
            if (this.container[i] == element) {
                return true;
            }
        }
        return false;
    }
    
    private int getIndex(T element){
        for (int i = 0; i < size; i++) {
            if (this.container[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        String tab = "[";

        for (int i = 0; i < currentIndex; i++) {

            if (this.container[i] != null) {
                if (i == 0) {
                    tab += this.container[i];
                } else {
                    tab += ", " + this.container[i];
                }
            }
        } 
        
        System.out.println(tab + "]");
    }

    private boolean scaleContainer() {
        int previousSize = this.size;
        Object[] temp = new Object[size];

        //Copies the container to temp array to further scale it without losing elements
        System.arraycopy(this.container, 0, temp, 0, size);

        this.size = this.size * 2;
        this.container = new Object[size]; // Doubles array size

        //Copies the elements back
        System.arraycopy(temp, 0, this.container, 0, previousSize);
        return true;
    }

    private boolean willFit() {
        return currentIndex + 1 > size;
    }
    
}
