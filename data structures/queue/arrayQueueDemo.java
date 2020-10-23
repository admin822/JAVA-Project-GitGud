package queue;

import java.util.Random;


public class arrayQueueDemo {
    public static void main(String[] args) {
        int aflag=0;
        int sflag=0;
        int action=0;
        int newElement;
        int aresult;
        int sresult;
        standardQueue squeue=new standardQueue(100);
        arrayQueue aqueue=new arrayQueue(100);
        Random randIntGenerator=new Random(202010);
        Random randActionGenerator=new Random(202011);
        System.out.println("started");
        for(int i=0;i<1000000;i++){
            sflag=0;
            aflag=0;
            aresult=-1;
            sresult=-1;
            action=randActionGenerator.nextInt(2)+1;
            if(action==1){
                newElement=randIntGenerator.nextInt(100);
                try{
                    aqueue.push(newElement);
                }catch (queueFullException e){
                    aflag=1;
                }
                try{
                    squeue.push(newElement);
                }catch(queueFullException e){
                    sflag=1;
                }
                if(aflag!=sflag){
                    System.out.println("Push error");
                    break;
                }
            }
            else{
                try{
                    aresult=aqueue.pop();
                }catch(invalidIndexException e){
                    aflag=2;
                }
                try{
                    sresult=squeue.pop();
                }catch(invalidIndexException e){
                    sflag=2;
                }
                if(aflag!=sflag || aresult!=sresult){
                    System.out.println("pop error");
                    break;
                }
            }
        }
    }
}
