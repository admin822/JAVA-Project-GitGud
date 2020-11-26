package class1;

public class linkedListNode {
    private int head;
    private linkedListNode tail;
    public linkedListNode(int head){
        this.head=head;
        this.tail=null;
    }
    public void setHead(int head){
        this.head=head;
    }
    public void setTail(int tail){
        this.tail=new linkedListNode(tail);
    }
    public linkedListNode getTail(){
        return this.tail;
    }
    public int getHead(){
        return this.head;
    }
    public void setTail(linkedListNode newTail){
        this.tail=newTail;
    }
}
