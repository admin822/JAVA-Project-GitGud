package tree.binary_tree;

import tree.emptyTreeException;

public class arrayTreeTest {
    public static void main(String[] args) {
        Integer[] init={1,2,3,4,null,null,5,null,6,null,null,null,null,7,null};
        arrayBTree testTree=new arrayBTree(init);
        try{
            testTree.preorderIterate();
        } catch(emptyTreeException e){
            System.out.println("Tree is empty");
        }
        System.out.println();
        try{
            testTree.infixIterate();
        } catch(emptyTreeException e){
            System.out.println("Tree is empty");
        }
        System.out.println();
        try{
            testTree.postorderIterate();
        } catch(emptyTreeException e){
            System.out.println("Tree is empty");
        }
        }
}
