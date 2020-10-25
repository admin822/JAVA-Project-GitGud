package linked_list;

public class linkedListTest {
    public static void main(String[] args) {
        linkedList testList=new linkedList();
        linkedList orderedTesList=new linkedList();
        testList.append(2, "clark");
        testList.append(4, "bruce");
        testList.append(3, "diana");
        testList.append(1, "barry");
        testList.iterativelyPrintAllNodes();
        try{
            orderedTesList.appendByOrder(10, "clark");
            orderedTesList.appendByOrder(14, "bruce");
            orderedTesList.appendByOrder(12, "diana");
            orderedTesList.appendByOrder(11, "barry");
            orderedTesList.iterativelyPrintAllNodes();

        }catch (duplicateNodeException e){
            System.out.println("appending new nodes by order failed due to "+e);
        }
        try{
            orderedTesList.changeName(10, "victor");
            orderedTesList.changeName(11, "haul");
            orderedTesList.iterativelyPrintAllNodes();
            orderedTesList.changeName(145, "author");
            orderedTesList.iterativelyPrintAllNodes();

        }catch(nodeDoesNotExistException e){
            System.out.println("changing name by order failed due to "+e);
        }
        try{
            orderedTesList.deleteNode(11);
            orderedTesList.deleteNode(14);
            orderedTesList.iterativelyPrintAllNodes();
            orderedTesList.deleteNode(145);
        }catch(nodeDoesNotExistException e){
            System.out.println("deleting node failed failed due to "+e);
        }
    }
}
