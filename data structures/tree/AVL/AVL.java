package tree.AVL;

import java.lang.annotation.Target;

import linked_list.nodeDoesNotExistException;
import tree.emptyTreeException;
import tree.treeNode;
import tree.BST.BST;

public class AVL {
    protected treeNode root;
    public AVL(Integer rootVal){
        root=new treeNode(rootVal);
    }
    public AVL(Integer[] allVals){
        root=new treeNode(allVals[0]);
        for(int i=1;i<allVals.length;i++){
            add(allVals[i]);                        
        }
    }
    public void delete(int target) throws emptyTreeException, nodeDoesNotExistException{
        if(this.root==null){
            throw new emptyTreeException();
        }
        else{
            try{
                delete(null, this.root, target);
            }catch (nodeDoesNotExistException e){
                throw e;
            }
        }
    }
    public void infixIterate() throws emptyTreeException{
        if(this.root==null){
            throw new emptyTreeException();
        }
        this.root.infixIterate();
    }
    public boolean checkIfUnbalance(){
        if(this.root==null){
            return false;
        }
        boolean result;
        result=this.root.checkIfUnbalanced();
        return result;
    }
    private void deleteLeaf(treeNode parent, treeNode current){
                /**
                 * 1. senario one: target is a leaf node.
                 */
                if(parent==null){ // root is target.
                    this.root=null;
                }
                else{
                    if(current==parent.left){
                        parent.left=null;
                    }
                    else{
                        parent.right=null;
                    }
                }
    }
    private void deleteOneChild(treeNode parent, treeNode current){
        /**
         * 3. senario three: target is one-childed
         */
        if(parent==null){ // root is target.
            if(this.root.isLeftEmpty()){
                this.root=this.root.right;
            }
            else{
                this.root=this.root.left;
            }
        }
        else{
            if(current==parent.left){
                if(current.isRightEmpty()){
                    parent.left=current.left;
                }
                else{
                    parent.left=current.right;
                }
            }
            else{
                if(current.isRightEmpty()){
                    parent.right=current.left;
                }
                else{
                    parent.right=current.right;
                }
            }
        }
    }
    private void deleteTwoChildren(treeNode current) throws nodeDoesNotExistException{
        /**
         * 2. senario two: target is double childrened
         */
        treeNode replacementParent=findReplacementOnTheRight(current.right);
        if(replacementParent==null){ // target's right node is the leftist on the right
            current.nodeId=current.right.nodeId;
            current.nodeName=current.right.nodeName;
            try{
                delete(current, current.right, current.right.nodeId);
            }catch(nodeDoesNotExistException e){
                throw e;
            }
        }
        else{
            current.nodeId=replacementParent.left.nodeId;
            current.nodeName=replacementParent.left.nodeName;
            try{
                delete(current, current.right, replacementParent.left.nodeId);
            }catch(nodeDoesNotExistException e){
                throw e;
            }
            
        }
    }
    private void adjust(treeNode rootNode){
        unbalancedType balanceCheck;
        balanceCheck=isUnbalanced(rootNode);
        if(balanceCheck==unbalancedType.RIGHTHIGER){
            if(rootNode.right.getLeftHeight()>rootNode.right.getRightHeight()){
                rightLeftRotate(rootNode);
            }
            else{
                leftRotate(rootNode);
            }
            
        }
        else if(balanceCheck==unbalancedType.LEFTHIGHER){
            if(rootNode.left.getRightHeight()>rootNode.left.getLeftHeight()){
                leftRightRotate(rootNode);
            }
            else{
                rightRotate(rootNode);
            }
        }
    }
    private void delete(treeNode parent, treeNode current, int target) throws nodeDoesNotExistException{
        if(current.nodeId==target){
            // target acquired
            if(current.isLeftEmpty()&&current.isRightEmpty()){
                deleteLeaf(parent, current);
            }
            else if(!current.isLeftEmpty()&&!current.isRightEmpty()){
                try{
                    deleteTwoChildren(current);
                }catch (nodeDoesNotExistException e){
                    throw e;
                }
                
            }
            else{
                deleteOneChild(parent, current);
            }

        }
        else if(current.nodeId>target){
            if(current.isLeftEmpty()){
                throw new nodeDoesNotExistException();
            }
            else{
                delete(current, current.left,target);
            }
        }
        else{
            if(current.isRightEmpty()){
                throw new nodeDoesNotExistException();
            }
            else{
                delete(current, current.right,target);
            }
        }
        adjust(current);
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
    /**
     * left rotate is meant to handle situation where right tree is higher than the left.
     * steps:
     * 1. newNode=new node(current.value)
     * 2. newNode.left=current.left
     * 3. newNode.right=current.right.left
     * 4. current.value=current.right.value
     * 5. current.right=current.right.right
     * 6. current.left =newNode
     */
    private void leftRotate(treeNode node){
        treeNode newNode=new treeNode(node.nodeId,node.nodeName);
        newNode.left=node.left;
        newNode.right=node.right.left;
        node.nodeId=node.right.nodeId;
        node.right=node.right.right;
        node.left=newNode;
    }
    /**
     * aim to solve left higher than right problem
     * newNode=new node(curernt.value)
     * newNode.right=current.right
     * node.left=current.left.right
     * current.value=current.left.value
     * current.left=current.left.left
     * current.right=newNode
     */
    private void rightRotate(treeNode node){
        treeNode newNode=new treeNode(node.nodeId,node.nodeName);
        newNode.right=node.right;
        newNode.left=node.left.right;
        node.nodeId=node.left.nodeId;
        node.left=node.left.left;
        node.right=newNode;
    }
    private void rightLeftRotate(treeNode node){
        rightRotate(node.right);
        leftRotate(node);
    }
    private void leftRightRotate(treeNode node){
        leftRotate(node.left);
        rightRotate(node);
    }

    public void add(Integer newVal){
        add(this.root, newVal);
    }

    private unbalancedType isUnbalanced(treeNode node){
        int leftHeight;
        int rightHeight;
        if(node.isLeftEmpty()){
            leftHeight=0;
        }
        else{
            leftHeight=node.left.getHeight();
        }
        if(node.isRightEmpty()){
            rightHeight=0;
        }
        else{
            rightHeight=node.right.getHeight();
        }
        if(Math.abs(rightHeight-leftHeight)>1){
            if(rightHeight>leftHeight){
                return unbalancedType.RIGHTHIGER;
            }
            else{
                return unbalancedType.LEFTHIGHER;
            }
        }
        else{
            return unbalancedType.BALANCED;
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
        adjust(rootNode);
    }

}
