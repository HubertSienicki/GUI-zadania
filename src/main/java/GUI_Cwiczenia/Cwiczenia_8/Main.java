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
public class Main {

  public static void main(String[] args) throws InterruptedException {
    StringTask task = new StringTask("ABC", 50000);
    System.out.println("Task " + task.getState());
    task.start();
    if (args.length > 0 && args[0].equals("abort")) {
        new Thread(() -> {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                return;
            }
            task.abort();
        }).start();
    }

    while (!task.isDone()) {
      Thread.sleep(500);
      switch(task.getState()) {
        case RUNNING -> System.out.print("R.");
        case ABORTED -> System.out.println(" ... aborted.");
        case READY -> System.out.println(" ... ready.");
        default -> System.out.println("uknown state");
      }
    }
    
    System.out.println("Task " + task.getState());
    System.out.println(task.getResult().length());
    System.out.println(task.getResult().substring(0,task.getTxt().length()));
  }

}
