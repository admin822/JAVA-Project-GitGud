package tree.binary_tree;

import tree.treeNode;

public class test {
    public static void main(String[] args) {
        bTree testTree=new bTree(1);
        treeNode testRoot=testTree.getRoot();
        testRoot.left=new treeNode(2);
        testRoot.right=new treeNode(3);
        testRoot.left.left=new treeNode(4);
        testRoot.right.right=new treeNode(5);
        testRoot.left.left.right=new treeNode(6);
        testRoot.right.right.left=new treeNode(7);
        testTree.preorderIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.iterativePreorderIterate();
        System.out.println("#############################");
        System.out.println();
        testTree.infixIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.iterativeIndixIterate();
        System.out.println("#############################");
        System.out.println();
        testTree.postorderIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.iterativePostorderIterate();
        System.out.println("#############################");
        System.out.println();
        testTree.preorderSearch(2);
    }
}
