package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import tree.binary_tree.illegalTargetException;
import tree.binary_tree.nodeOperation;


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
        
        System.out.printf("Node: %d, Name: %s, left height is %d, right height is %d, is it unbalanced: %b\n", this.nodeId,this.nodeName,getLeftHeight(),getRightHeight(),Math.abs(getLeftHeight()-getRightHeight())>1);
    }
    public String getDescription(){
        return String.format("Node: %d, Name: %s\n", this.nodeId,this.nodeName);
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
    public void deleteNode(Integer target) throws illegalTargetException{
        if(this.nodeId==target){
            throw new illegalTargetException();
        }
        Queue<treeNode> tempSave=new LinkedList<>();
        treeNode tempNode;
        tempSave.offer(this);
        while(!tempSave.isEmpty()){
            tempNode=tempSave.poll();
            /* judge if this node need to be deleted*/
            if(!tempNode.isLeftEmpty()){
                if(tempNode.left.nodeId==target){
                    tempNode.left=null;
                }
                else{
                    tempSave.offer(tempNode.left);
                }
            }
            if(!tempNode.isRightEmpty()){
                if(tempNode.right.nodeId==target){
                    tempNode.right=null;
                }
                else{
                    tempSave.offer(tempNode.right);
                }
            }
        }
    }


    public ArrayList<String> iterativePreorderIterate(nodeOperation nodeOp){
        Stack<treeNode> tempSave=new Stack<>();
        ArrayList<String> opResults= new ArrayList<>();
        treeNode tempNode=this;
        String tempResult;
        while(tempNode!=null || !tempSave.isEmpty()){
            if(tempNode!=null){
                tempResult=nodeOp.operateNode(tempNode);
                if(tempResult!=null){
                    opResults.add(tempResult);
                }
                tempSave.push(tempNode);
                tempNode=tempNode.left;
            }
            else{
                tempNode=tempSave.pop().right;
            }
        }
        return opResults;
    }
    

    public void iterativeIndixIterate(nodeOperation nodeOp) {
        Stack<treeNode> tempSave=new Stack<>();
        treeNode tempNode=this;
        String opResult;
        while(tempNode!=null || !tempSave.isEmpty()){
            if(tempNode!=null){
                tempSave.push(tempNode);
                tempNode=tempNode.left;
            }
            else{
                tempNode=tempSave.pop();
                opResult=nodeOp.operateNode(tempNode);
                System.out.println(opResult);
                tempNode=tempNode.right;
            }
        }
    }
    public int getLeftHeight(){
        if(isLeftEmpty()){
            return 0;
        }
        else{
            return left.getHeight();
        }
    }
    public int getRightHeight(){
        if(isRightEmpty()){
            return 0;
        }
        else{
            return right.getHeight();
        }
    }
    public int getHeight(){
        if(isLeftEmpty()&&isRightEmpty()){
            return 1;
        }
        else if(isLeftEmpty()){
            return right.getHeight()+1;
        }
        else if(isRightEmpty()){
            return left.getHeight()+1;
        }
        else{
            return Math.max(left.getHeight(), right.getHeight())+1;
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
    public boolean checkIfUnbalanced(){
        boolean result=false;
        if(!this.isLeftEmpty()){
            result=this.left.checkIfUnbalanced();
        }
        if(result){
            return result;
        }
        else{
            if(Math.abs(this.getLeftHeight()-this.getRightHeight())>1){
                print();
                return true;
            }
        }
        if(!this.isRightEmpty()){
            result=this.right.checkIfUnbalanced();
        }
        if(result){
            return result;
        }
        return false;
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
