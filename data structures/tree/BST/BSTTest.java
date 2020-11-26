package tree.BST;


import linked_list.nodeDoesNotExistException;

public class BSTTest {
    public static void main(String[] args) {
        // Integer[] init={12,8,20,4,10,6,9,7,22,21};
        Integer[] init={12,20,22,21,10};
        BST testBST=new BST(init);
        testBST.infixIterate();
        System.out.println("Deletion started ....");
        System.out.println();
        try{
            System.out.printf("Deleting %d\n",12);
            testBST.delete(12);
            testBST.infixIterate();
            System.out.println();
            System.out.println();

            System.out.printf("Deleting %d\n",20);
            testBST.delete(20);
            testBST.infixIterate();
            System.out.println();
            System.out.println();

            System.out.printf("Deleting %d\n",10);
            testBST.delete(10);
            testBST.infixIterate();
            System.out.println();
            System.out.println();

            System.out.printf("Deleting %d\n",22);
            testBST.delete(22);
            testBST.infixIterate();
            System.out.println();
            System.out.println();

            System.out.printf("Deleting %d\n",21);
            testBST.delete(21);
            testBST.infixIterate();
            System.out.println();
            System.out.println();

            // System.out.printf("Deleting %d\n",8);
            // testBST.delete(8);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();

            // System.out.printf("Deleting %d\n",22);
            // testBST.delete(22);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();

            // System.out.printf("Deleting %d\n",21);
            // testBST.delete(21);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();

            // System.out.printf("Deleting %d\n",12);
            // // System.out.println(testBST.getRoot().left.nodeId);
            // testBST.delete(12);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();

            // System.out.printf("Deleting %d\n",9);
            // testBST.delete(9);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();

            // System.out.printf("Deleting %d\n",6);
            // testBST.delete(6);
            // testBST.infixIterate();
            // System.out.println();
            // System.out.println();
        }catch(nodeDoesNotExistException e){
            System.out.println("Node does not exist, deletion failed");
        }
        
    }
}
