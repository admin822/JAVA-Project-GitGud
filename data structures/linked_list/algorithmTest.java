package linked_list;


import queue.invalidIndexException;

public class algorithmTest {

    public static linkedListNode getLastKNode(linkedListNode head,Integer index) throws invalidIndexException{
        linkedListNode fastPointer=head;
        linkedListNode slowPointer=head;
        for(Integer i=0;i<index;i++){
            if(fastPointer==null){
                throw new invalidIndexException(String.format("Index %d is not reachable!", index)); // index cannot be reached since the list is not long enogh.
            }
            fastPointer=fastPointer.getNext();
        }
        while(fastPointer!=null){
            fastPointer=fastPointer.getNext();
            slowPointer=slowPointer.getNext();
        }
        return slowPointer;
    } //leetcode 金典面试题02.02
    
    public static void reverseList(){
        ;// leetcode 206
    }
    public static void printListInReverseOrder(){
        ; //LeetCode 剑指06
    }
    
}
