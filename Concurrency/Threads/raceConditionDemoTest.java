package Threads;

public class raceConditionDemoTest {
    public static void main(String[] args) {
        raceConditionDemo r1=new raceConditionDemo(1);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);
        t1.start();
        t2.start();
    }
}
