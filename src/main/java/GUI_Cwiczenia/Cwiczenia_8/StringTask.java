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
public class StringTask implements Runnable {
    
    private final String ThreadName;
    private String result = "";
    private final int multiple;
    private TaskState state;

    public StringTask(String ThreadName, int multiple) {
        this.ThreadName = ThreadName;
        this.multiple = multiple;
        this.state = TaskState.CREATED;
    }

    @Override
    public void run() {
        for (int j = 0; j < multiple; j++) {
            for (int i = ThreadName.length(); i > 0; i--) {
                this.result += this.ThreadName.substring(i);
            }
        }
        this.state = TaskState.READY;
    }

    void start() {
        this.state = TaskState.RUNNING;
        new Thread(()-> {
            while(this.state != TaskState.READY){
                this.run();
            }
        }).start();
    }

    public TaskState getState() {
       return this.state;
    }

    public boolean isDone() {
       return state == TaskState.ABORTED || state == TaskState.READY;
    }

    public String getResult() {
       return this.result;
    }

    public String getTxt() {
        return this.ThreadName;
    }
    
    public void abort(){
        this.state = TaskState.ABORTED;
    }
    
    
    
}
