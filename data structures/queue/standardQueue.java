package queue;

import java.util.LinkedList;
import java.util.Queue;

public class standardQueue {
    private Queue <Integer> listQueue=new LinkedList<Integer>();
    private int maxsize;
    public standardQueue(int maxsize){
        this.maxsize=maxsize;
    }
    public int pop() throws invalidIndexException{
        Object result;
        result=this.listQueue.poll();
        if(result==null){
            throw new invalidIndexException();
        }
        else{
            return (int)result;
        }
    }
    public void push(int element) throws queueFullException{
        if(this.listQueue.size()==maxsize){
            throw new queueFullException();
        }
        else{
            this.listQueue.add(element);
        }
    }

}
