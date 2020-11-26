package tree.BST;

import java.util.ArrayList;

import linked_list.nodeDoesNotExistException;
import tree.treeNode;
import tree.binary_tree.nodeOperation;

public class BST {
    protected treeNode root;
    public BST(Integer rootVal){
        root=new treeNode(rootVal);
    }
    public BST(Integer[] allVals){
        //TODO: allVals could be an empty array.
        root=new treeNode(allVals[0]);
        for(int i=1;i<allVals.length;i++){
            add(allVals[i]);                        
        }
    }
    private void add(treeNode rootNode,Integer newVal){
        if(newVal>rootNode.nodeId){
            if(rootNode.isRightEmpty()){
                rootNode.right=new treeNode(newVal);
            }
            else{
                add(rootNode.right, newVal);
            }
        }
        else{
            if(rootNode.isLeftEmpty()){
                rootNode.left=new treeNode(newVal);
            }
            else{
                add(rootNode.left, newVal);
            }
        }
    }
    public treeNode getRoot(){
        return this.root;
    }
    public treeNode searchParent(int target) throws nodeDoesNotExistException{
        treeNode temp=this.root;
        if(temp.nodeId==target){
            return null;
        }
        while(temp!=null){
            if(!temp.isLeftEmpty()&&temp.left.nodeId==target){
                return temp;
            }
            else if(!temp.isRightEmpty()&&temp.right.nodeId==target){
                return temp;
            }
            else{
                if(temp.nodeId>target){
                    temp=temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
        }
        throw new nodeDoesNotExistException();
    }
    public treeNode search(int target) throws nodeDoesNotExistException{
        treeNode temp=this.root;
        while(temp!=null){
            if(temp.nodeId==target){
                return temp;
            }
            else{
                if(temp.nodeId>target){
                    temp=temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
        }
        throw new nodeDoesNotExistException();
    }
    
    /**
     * find the target node and its parent node, decide whether its a leaf, one-child parent, two-children parent. call the functions below.
     * only delete one node once, call this function multiple times if multiple targets.
     */
    public void delete(Integer target) throws nodeDoesNotExistException{
        try{
            treeNode targetParent=searchParent(target);
            if(targetParent==null){
                if(this.root.isLeftEmpty()&&this.root.isRightEmpty()){
                    this.root=null;
                }
                else if(this.root.isRightEmpty()){
                    treeNode temp=findReplacementOnTheLeft(this.root.left);
                    
                    if(temp==null){
                        this.root.nodeId=this.root.left.nodeId;
                        this.root.nodeName=this.root.left.nodeName;
                        this.root.left=this.root.left.left;
                    }
                    else{
                        this.root.nodeId=temp.right.nodeId;
                        this.root.nodeName=temp.right.nodeName;
                        temp.right=temp.right.left;
                    }
                }
                else{
                    deleteTwoChildren(this.root);
                }
            }
            else{
                treeNode tempTarget;
                boolean isLeft=false;
                if(targetParent.nodeId>target){
                    tempTarget=targetParent.left;
                    isLeft=true;
                }
                else{
                    tempTarget=targetParent.right;
                }
                if(tempTarget.isLeftEmpty()&&tempTarget.isRightEmpty()){
                    deleteLeaf(targetParent,tempTarget);
                }
                else if((tempTarget.isLeftEmpty()&&!tempTarget.isRightEmpty())||(tempTarget.isRightEmpty()&&!tempTarget.isLeftEmpty())){
                    deleteOneChild(targetParent, tempTarget, isLeft);
                }
                else{
                    deleteTwoChildren(tempTarget);
                }
            }
            
        }catch(nodeDoesNotExistException e){
            throw e;
        }
        
    }
    /**
     * just delete the leaf node
     */
    private void deleteLeaf(treeNode targetParent, treeNode target){
        if(target==targetParent.left){
            targetParent.left=null;
        }
        else{
            targetParent.right=null;
        }
    }
    /**
     * decide whether the target node is left or right child of its parent
     * decide whether the target node has a left or right child
     */
    private void deleteOneChild(treeNode targetParent, treeNode target, boolean isLeft){
        if(isLeft){
            if(target.isLeftEmpty()){
                targetParent.left=target.right;
            }
            else{
                targetParent.left=target.left;
            }
        }
        else{
            if(target.isLeftEmpty()){
                targetParent.right=target.right;
            }
            else{
                targetParent.right=target.left;
            }
        }
    }
    /**
     * find smallest node on target's right branch, delete it, assign its value to target node.
     */
    private void deleteTwoChildren(treeNode target){
        treeNode replacementParent=findReplacementOnTheRight(target.right);
        if(replacementParent!=null){
            treeNode tempRight=replacementParent.left.right;
            target.nodeId=replacementParent.left.nodeId;
            target.nodeName=replacementParent.left.nodeName;
            replacementParent.left=tempRight;
        }
        else{
            target.nodeId=target.right.nodeId;
            target.nodeName=target.right.nodeName;
            target.right=target.right.right;
        }
    }
    private treeNode findReplacementOnTheRight(treeNode startPoint){
        while(!startPoint.isLeftEmpty()&&!startPoint.left.isLeftEmpty()){
            startPoint=startPoint.left;
        }
        if(startPoint.isLeftEmpty()){
            return null;
        }
        else{
            return startPoint;
        }
    }
    private treeNode findReplacementOnTheLeft(treeNode startPoint){
        while(!startPoint.isRightEmpty()&&!startPoint.right.isRightEmpty()){
            startPoint=startPoint.right;
        }
        if(startPoint.isRightEmpty()){
            return null;
        }
        else{
            return startPoint;
        }
    }
    public void prefixIterate(){
        if(this.root!=null){
            this.root.preorderIterate();
        }
        else{
            System.out.println("tree is empty");
        }
    }
    public void infixIterate(){
        if(this.root!=null){
            this.root.infixIterate();
        }
        else{
            System.out.println("tree is empty");
        }
    }
    public void add(Integer newVal){
        add(this.root, newVal);
    }
}
