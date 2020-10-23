package queue;

public class arrayQueue {
    private int queue[];
    private int maxsize; // indicate the max size of the queue
    private int head; // indicate the current head element
    private int rear; // indicate the current rear element
    public arrayQueue(int maxsize){
        this.maxsize=maxsize;
        this.queue=new int[this.maxsize];
        this.head=0;
        this.rear=-1;
    }
    public int pop() throws invalidIndexException{
        if(this.head<=this.rear){
            this.head++;
            return this.queue[(this.head-1)%this.maxsize];

        }
        else{
            throw new invalidIndexException("There is no element in the queue!");
        }
    }
    public void push(int newElement) throws queueFullException{
    
        if(this.rear-this.head+1==this.maxsize){
            throw new queueFullException("The queue is full and cannot hold more elements!");
        }
        else{
            this.rear++;
            this.queue[this.rear%this.maxsize]=newElement;
        }
    }
    public int length(){
        return this.rear-this.head+1;
    }
    public int head(){
        return this.queue[this.head];
    }

}
