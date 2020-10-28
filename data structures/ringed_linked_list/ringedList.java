package ringed_linked_list;

import java.util.concurrent.LinkedBlockingDeque;

import linked_list.linkedListNode;

public class ringedList {
    public linkedListNode head;
    public linkedListNode tail;
    public ringedList(){
        this.head=null;
        this.tail=null;
    }
    public void append(Integer value,String name){
        if(this.head==null){
            this.head=new linkedListNode(value, name);
            this.tail=this.head;
            this.tail.setNext(this.head);
        }
        else{
            linkedListNode newNode=new linkedListNode(value, name);
            this.tail.setNext(newNode);
            this.tail=newNode;
            this.tail.setNext(this.head);
        }
    }
    public void iterativelyPrintAllNodes(){
        linkedListNode temp=this.head;
        if(temp==null){
            System.out.println("Empty list, nothing to print!");
            return;
        }
        while(true){
            System.out.println(temp.getValue());
            temp=temp.getNext();
            if(temp==this.head){
                System.out.println("Finished printing!");
                return;
            }
        }
    }
    public void josepthAlgorithm(Integer startWith, Integer count){
        int counter=1;
        linkedListNode temp=this.head;
        linkedListNode prev=null;
        if(temp==null){
            System.out.println("Failed to call joseph algorithm, because the linked list is empty!");
            return;
        }
        while(true){
            if(counter<startWith){
                counter++;
                prev=temp;
                temp=temp.getNext();
                if(temp==this.head){
                    System.out.println("Failed to call joseph algorithm, because start with number is larger than the length of linkedlist!");
                    return;
                }
            }
            else{
                break;
            }
        }
        System.out.printf("start with the node with value %d\n",temp.getValue());
        counter=0;
        while(true){
            if(temp==prev){
                this.head=null;
                this.tail=null;
                System.out.println(temp.getValue());
                System.out.println("\nJoseph algorithm is finished!");
                return;
            }
            counter++;
            if(counter<count){
                prev=temp;
                temp=temp.getNext();
            }
            else{
                System.out.printf("%d\t",temp.getValue());
                prev.setNext(temp.getNext());
                temp=prev.getNext();
                counter=0;
            }
        }
    }
}
