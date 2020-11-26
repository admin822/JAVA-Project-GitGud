package Threads;

public class customThreadTest {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        customThread t1=new customThread("test1", 10);
        customThread t2=new customThread("test2", 20);
        t1.start();
        t2.start();
        System.out.println(String.format("It took %d to finish", System.currentTimeMillis()-startTime));
    }
}
