package class1;

import java.util.*;
public class testDeleteAll {
    public static void main(String[] args) {
        int[] a1={2,1,3,2,4,7,2};
        linkedList myList=new linkedList(a1);
        linkedList mySecondList=new linkedList(a1);
        linkedList myThirdList=new linkedList(a1);
        linkedList myFifthList=new linkedList(a1);
        deleteAll myIterativeCleaner=new deleteAll(true);
        deleteAll myRecursiveCleaner=new deleteAll(false);
        deleteAll myIterativeMercifulCleaner=new deleteAll(true);
        deleteAll myRecursiveMercifulCleaner=new deleteAll(false);
        myList.printList();
        mySecondList.printList();
        myThirdList.printList();
        myFifthList.printList();
        myIterativeCleaner.dremoveAll(2, myList.getRoot(),myList.getAnchor());
        myRecursiveCleaner.dremoveAll(2, mySecondList.getRoot(),mySecondList.getAnchor());
        linkedList myFourthList=myIterativeMercifulCleaner.removeAll(2, myThirdList.getRoot());
        linkedList mySixthList=myRecursiveMercifulCleaner.removeAll(2, myFifthList.getRoot());
        myList.printList();
        mySecondList.printList();
        myThirdList.printList();
        myFourthList.printList();
        myFifthList.printList();
        mySixthList.printList();

}
}
