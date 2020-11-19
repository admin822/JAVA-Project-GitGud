package tree.binary_tree;

import tree.treeNode;

public class test {
    public static void main(String[] args) {
        bTree testTree=new bTree(1,"clark");
        treeNode testRoot=testTree.getRoot();
        testRoot.left=new treeNode(2,"diana");
        testRoot.right=new treeNode(3,"bruce");
        testRoot.left.left=new treeNode(3,"barry");
        testRoot.right.right=new treeNode(5,"haul");
        testRoot.left.left.right=new treeNode(6,"victor");
        testRoot.right.right.left=new treeNode(7,"arthor");
        testTree.preorderIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.iterativePreorderIterate();
        System.out.println("#############################");
        System.out.println();
        testTree.infixIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        nodeOperation nodeOp=tempNode-> {
            return tempNode.nodeName;
        };
        testTree.iterativeIndixIterate(nodeOp);
        System.out.println("#############################");
        System.out.println();
        testTree.postorderIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.iterativePostorderIterate();
        System.out.println("#############################");
        System.out.println();
        testTree.preorderSearch(3);
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.preorderIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        try{
            testTree.delete(1);
            System.out.println("successful node deletion");
        }catch (illegalTargetException e){
            System.out.println("target illegal, node deletion failed");
        }
        
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        testTree.preorderIterate();

    }
}
