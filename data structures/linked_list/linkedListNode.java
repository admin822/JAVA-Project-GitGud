package linked_list;

public class linkedListNode {
    private Integer value;
    private String name;
    private linkedListNode next; 
    public linkedListNode(int val,String name,linkedListNode next){
        this.value=val;
        this.name=name;
        this.next=next;
    }
    public linkedListNode(int val,String name){
        this.value=val;
        this.name=name;
    }
    public linkedListNode(){
        this.value=null;
        this.name=null;
        this.next=null;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setValue(Integer newValue){
        this.value=newValue;
    }
    public void setNext(linkedListNode next){
        this.next=next;
    }
    public linkedListNode getNext(){
        return this.next;
    }
    public Integer getValue(){
        return this.value;
    }
    public String getName(){
        return this.name;
    }
}
