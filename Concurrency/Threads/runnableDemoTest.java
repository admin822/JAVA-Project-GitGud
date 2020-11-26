package Threads;

public class runnableDemoTest {
    public static void main(String[] args) {
        runnableDemo r1=new runnableDemo("thread 1");
        runnableDemo r2=new runnableDemo("thread 2");
        Thread thread1=new Thread(r1);
        Thread thread2=new Thread(r1);
        thread1.start();
        thread2.start();
        try{
            Thread.sleep(600);
        }catch(InterruptedException e){
            System.out.println("main thread interrupted");
            r1.stopRunning();
            r2.stopRunning();
        }
        r1.stopRunning();

        /**
         * another way of implementing runnable instance in new thread.
         */
        // Runnable anonymousRunnable=
        // new Runnable(){
        //     public void run(){
        //         try{
        //             for(int i=0;i<4;i++){
        //                 System.out.println(i);
        //                 Thread.sleep(50);
        //             }
        //         }catch (InterruptedException e){
        //             System.out.println("thread interruption");

        //         }
                
        //     }
        // };
        // Thread r3=new Thread(anonymousRunnable, "thread 3");
        // r3.start();
    }
}
