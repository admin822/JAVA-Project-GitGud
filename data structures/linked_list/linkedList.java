package linked_list;

public class linkedList {
    private linkedListNode head;
    private linkedListNode tail;
    public linkedList(){
        this.head=new linkedListNode();
        this.tail=null;
    }
    public linkedListNode getHead(){
        return this.head;
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
    public void deleteNode(Integer value) throws nodeDoesNotExistException{
        linkedListNode tempStart=this.head;
        while(true){
            if(tempStart.getNext()==null){
                break;
            }
            if(tempStart.getNext().getValue()==value){
                tempStart.setNext(tempStart.getNext().getNext());; // find the node we need to delete
                return;
            }
            else{
                tempStart=tempStart.getNext();
            }
        }
        throw  new nodeDoesNotExistException(String.format("There is no node with value %d exist!", value)); // throw exception since no such node exists
    }
    public void appendByOrder(Integer value,String name) throws duplicateNodeException{
        // 
        linkedListNode tempStart=this.head;
        while(true){
            if(tempStart.getNext()==null)
                break;
            if(tempStart.getNext().getValue()>value){
                linkedListNode newNode=new linkedListNode(value, name);// this is the place to insert new node
                newNode.setNext(tempStart.getNext());
                tempStart.setNext(newNode);
                return;
            }
            else if(tempStart.getNext().getValue()==value){
                System.out.println(tempStart.getNext().getValue());
                throw new duplicateNodeException(String.format("Current value : %d has already existed!", value)); // throw exception,cannot allow duplicate node with the same value
            }
            else{
                tempStart=tempStart.getNext();
            }
        }
        append(value, name); // all the existing nodes have values less than the new value, insert at the end.
    }
    public void changeName(Integer value,String name) throws nodeDoesNotExistException{
        linkedListNode tempStart=this.head;
        while(true){
            if(tempStart.getNext()==null)
                break;
            if(tempStart.getNext().getValue()==value){
                tempStart.getNext().setName(name);
                return;
            }
            else{
                tempStart=tempStart.getNext();
            }
        }
        throw new nodeDoesNotExistException(String.format("There is no node with value %d exist!", value)); // didn't find a node with the specified value, thorw exception.
    }
    public void iterativelyPrintAllNodes(){
        linkedListNode iterateStartPoint =this.head;
        while(iterateStartPoint.getNext()!=null){
            iterateStartPoint=iterateStartPoint.getNext();
            System.out.printf("Current Node's value is %d and name is %s\n", iterateStartPoint.getValue(),iterateStartPoint.getName());
        }
    }
}
