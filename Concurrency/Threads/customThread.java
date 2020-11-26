package Threads;


public class customThread extends Thread {
    private String tName;
    private Integer startpoint;
    public customThread(String threadName,Integer startpoint){
        this.tName=threadName;
        this.startpoint=startpoint;
    }
    public void run(){
        try{
            for(int i=0;i<4;i++){
                System.out.println(String.format("%s: %d", tName, startpoint+i));
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println(String.format("%s has been ternimated because of interruption", tName));
        }
    
    }
}
