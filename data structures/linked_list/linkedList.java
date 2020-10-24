package linked_list;

public class linkedList {
    private linkedListNode head;
    private linkedListNode tail;
    public linkedList(){
        this.head=new linkedListNode();
        this.tail=null;
    }
    public void append(Integer value,String name){
        if(this.tail==null){
            this.tail=new linkedListNode(value,name);
            this.head.setNext(this.tail);
        }
        else{
            linkedListNode newTail=new linkedListNode(value,name);
            this.tail.setNext(newTail);
            this.tail=newTail;
        }
    }
    public void iterate(){
        linkedListNode iterateStartPoint =this.head;
        while(iterateStartPoint.getNext()!=null){
            iterateStartPoint=iterateStartPoint.getNext();
            System.out.printf("Current Node's value is %d and name is %s\n", iterateStartPoint.getValue(),iterateStartPoint.getName());
        }
    }
}
