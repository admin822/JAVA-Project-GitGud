package Threads;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class raceConditionDemo implements Runnable{
    private Integer sharedResource;
    private Integer step;
    private Map<String,String> sharedMap=new ConcurrentHashMap<>();

    public raceConditionDemo(Integer step){
        sharedResource=0;
        this.step=step;
    }

    public void run(){
        for(int i=0;i<100000;i++){

            // synchronized(this){
            //     sharedResource+=step;
            // }

            incrementSharedResource();
        }
        for(int i=0;i<1000000;i++){
            checkAndAct();
        }
        print();
    }

    private synchronized void incrementSharedResource(){
        sharedResource+=step;
    }

    private synchronized void checkAndAct(){

        if(sharedMap.containsKey("testKey")){
            String result=sharedMap.remove("testKey");
            if(result==null){
                System.out.println(String.format("removal returns null"));
            }
        }
        else{
            sharedMap.put("testKey", "testValue");
        }

    }

    public void print(){
        System.out.println(sharedResource);
    }

}
