package tree.binary_tree;

import java.util.ArrayList;
import java.util.spi.TimeZoneNameProvider;

import tree.treeNode;

public class bTree {
    private treeNode root;
    public bTree(Integer id, String name){
        root=new treeNode(id, name);
    }
    public bTree(Integer id){
        root=new treeNode(id);
    }
    public void delete(Integer target) throws illegalTargetException{
        try{
            this.root.deleteNode(target);
        }catch(illegalTargetException e){
            throw e;
        }
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
        nodeOperation nodeOp=tempNode ->{
            return tempNode.getDescription();
        };
        ArrayList<String> results;
        results=this.root.iterativePreorderIterate(nodeOp);
        for(String result: results){
            System.out.println(result);
        }
    }
    public void preorderSearch(Integer target){
        nodeOperation nodeOp=tempNode->{
            if(tempNode.nodeId==target){
                return tempNode.getDescription();
            }
            else{
                return null;
            }
        };
        ArrayList<String> results;
        results=this.root.iterativePreorderIterate(nodeOp);
        if(results.isEmpty()){
            System.out.println("No node found!");
            return;
        }
        for(String result: results){
            System.out.println(result);
        }
    }
    public void iterativeIndixIterate(nodeOperation nodeOp){
        this.root.iterativeIndixIterate(nodeOp);
    }
    public void iterativePostorderIterate(){
        this.root.iterativePostorderIterate();
    }
}
