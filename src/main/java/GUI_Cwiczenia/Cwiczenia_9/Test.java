/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Cwiczenia.Cwiczenia_9;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

class Buffer {

    private final int[] arr;
    private boolean ready = true;
    public static int currentIndex = 0; 
    
		// konstruktor
    public Buffer(int size) {
        this.arr = new int[size];
    }

	//...
	
   public synchronized void put(int n){
       
       while(!ready){ //Not a get method
            try{
                wait(); // awaits other thread finishing
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
        if(currentIndex + 1 > this.arr.length){
            System.out.println("Buffor is full... Awaiting free space.");
            this.ready = false;
            notifyAll(); //Notifies other threads if a method has finished
        }else{
            this.arr[currentIndex] = n;
            currentIndex++;
            System.out.print("Buffor: [");

            for (int i = 0; i < this.arr.length; i++) {
                System.out.print(this.arr[i] + ",");
            }
            System.out.print("]");
            System.out.println("");
        }
        
       
    }
    
    
    public synchronized int get(){
       while(ready){
           try{
               wait();
           }catch(InterruptedException e){
               Thread.currentThread().interrupt();
               System.out.println("Thread Interrupted.");
           }
       }
       if(this.currentIndex == 0){
           System.out.println("Buffor is empty... Awaiting products.");
           this.ready = true;
           notifyAll();
           return 0;
       }else{
           currentIndex--;
           int tempProd = this.arr[currentIndex];
           this.arr[currentIndex] = 0;
           
            System.out.print("Buffor: [");

            for (int i = 0; i < this.arr.length; i++) {
                System.out.print(this.arr[i] + ",");
            }
            System.out.print("]");
            System.out.println("");
           return tempProd;
       }
        
    }
    
}

class Producer implements Runnable {

    private final Buffer buff;
    private int product;    
    public Producer(Buffer b) {
        this.buff = b;
        
    }

	@Override
    public void run() {
        while (true){
            Random r = new Random();
            this.product = r.nextInt(10);
            this.buff.put(product);
            System.out.println("Producer has sent a product: " + this.product);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 2000));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Producer has finished");
                break;
            }
	}
    }
}

class Consumer implements Runnable {

    private final Buffer buff;
    private int product;
    
    public Consumer(Buffer b) {
	this.buff = b;
    }

	@Override
    public void run() {
        while (true){
            product = buff.get();
            System.out.println("Consumer recieved a product: " + this.product);
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(0, 2000));
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Consumer has finished");
                break;
            }
        }
    }
}


public class Test {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        
        producerThread.start();
        consumerThread.start();
        
        try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
		e.printStackTrace();
            } finally {
            producerThread.interrupt();
            consumerThread.interrupt();
        }
    }
}
