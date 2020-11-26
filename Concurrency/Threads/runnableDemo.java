package Threads;


public class runnableDemo implements Runnable {
    private String threadName;
    private boolean isRunning;

    public runnableDemo( String name) {
        isRunning=false;
       threadName = name;
       System.out.println("Creating " +  threadName );
    }

    private boolean checkIsRunning(){
        return isRunning==true;
    }

    public void stopRunning(){
        isRunning=false;
    }

    

    public void run(){

        System.out.println( threadName+"starts running");
        isRunning=true;
        Integer i=0;
        try {
           while(checkIsRunning()){
            System.out.println(String.format("%s: %d", threadName,i++));
            Thread.sleep(100);
           }
        } catch (InterruptedException e) {
           System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }





}
