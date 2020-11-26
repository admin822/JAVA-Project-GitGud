package class1;

public class testLinkedList {
    private static void sillyFunc(linkedListNode root){
        root=null;
    }
    public static void main(String[] args) {
        int[]a={2,1,3,2,4,7,2};
        linkedList myList=new linkedList(a);
        myList.printList();
        // sillyFunc(myList.getRoot());
        // myList.printList();
    }
}
