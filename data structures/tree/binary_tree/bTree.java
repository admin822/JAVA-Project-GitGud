package tree.binary_tree;

import tree.treeNode;

public class bTree {
    private treeNode root;
    public bTree(Integer id, String name){
        root=new treeNode(id, name);
    }
    public bTree(Integer id){
        root=new treeNode(id);
    }
    public treeNode getRoot(){
        return root;
    }
    public void preorderIterate(){
        this.root.preorderIterate();
    }
    public void infixIterate(){
        this.root.infixIterate();
    }
    public void postorderIterate(){
        this.root.postorderIterate();
    }
    public void iterativePreorderIterate(){
        this.root.iterativePreorderIterate(tempNode-> tempNode.print());
    }
    public void preorderSearch(Integer target){
        this.root.iterativePreorderIterate(tempNode->{
            if(tempNode.nodeId==target){
                tempNode.print();
            }
        });
    }
    public void iterativeIndixIterate(){
        this.root.iterativeIndixIterate();
    }
    public void iterativePostorderIterate(){
        this.root.iterativePostorderIterate();
    }
}
