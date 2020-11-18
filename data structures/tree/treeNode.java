package tree;

import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.function.Consumer;


public class treeNode {
    public Integer nodeId;
    public String nodeName;
    public treeNode left,right;
    public treeNode(Integer id, String name){
        this.nodeId=id;
        this.nodeName=name;
        this.left=null;
        this.right=null;
    }
    public treeNode(Integer id){
        this.nodeId=id;
        this.nodeName=null;
        this.left=null;
        this.right=null;
    }
    public void print(){
        System.out.printf("Node: %d, Name: %s\n", this.nodeId,this.nodeName);
    }
    public boolean isLeftEmpty(){
        if(this.left==null){
            return true;
        }
        else{
            return false;
        }
    }
    public void printCurrentNode(treeNode currentNode){
        currentNode.print();
    }
    public void iterativePreorderIterate(Consumer<treeNode> action){
        Stack<treeNode> tempSave=new Stack<>();
        treeNode tempNode=this;
        while(tempNode!=null || !tempSave.isEmpty()){
            if(tempNode!=null){
                action.accept(tempNode);
                tempSave.push(tempNode);
                tempNode=tempNode.left;
            }
            else{
                tempNode=tempSave.pop().right;
            }
        }
    }
    

    public void iterativeIndixIterate() {
        Stack<treeNode> tempSave=new Stack<>();
        treeNode tempNode=this;
        while(tempNode!=null || !tempSave.isEmpty()){
            if(tempNode!=null){
                tempSave.push(tempNode);
                tempNode=tempNode.left;
            }
            else{
                tempNode=tempSave.pop();
                tempNode.print();
                tempNode=tempNode.right;
            }
        }
    }

    public void iterativePostorderIterate(){
        Stack<treeNode> tempsave=new Stack<>();
        treeNode tempNode=this;
        treeNode preNode=null;
        tempsave.push(tempNode);
        while(!tempsave.isEmpty()){
            tempNode=tempsave.peek();
            if(tempNode.isLeftEmpty()&&tempNode.isRightEmpty() ||
                (preNode!=null && (preNode==tempNode.left || preNode==tempNode.right))){
                    tempNode.print();
                    tempsave.pop();
                    preNode=tempNode;
                }
            else{
                if(!tempNode.isRightEmpty()){
                    tempsave.push(tempNode.right);
                }
                if(!tempNode.isLeftEmpty()){
                    tempsave.push(tempNode.left);
                }
            }
        }
    }

    public void postorderIterate(){
        if(!this.isLeftEmpty()){
            this.left.postorderIterate();
        }
        if(!this.isRightEmpty()){
            this.right.postorderIterate();
        }
        this.print();
    }
    public void infixIterate(){
        if(!this.isLeftEmpty()){
            this.left.infixIterate();
        }
        this.print();
        if(!this.isRightEmpty()){
            this.right.infixIterate();
        }
    }
    public void  preorderIterate(){
        this.print();
        if(!this.isLeftEmpty()){
            this.left.preorderIterate();
        }
        if(!this.isRightEmpty()){
            this.right.preorderIterate();
        }
    }
    public boolean isRightEmpty(){
        if(this.right==null){
            return true;
        }
        else{
            return false;
        }
    }
}
