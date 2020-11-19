package tree.binary_tree;

import java.util.Stack;

import tree.emptyTreeException;

public class arrayBTree {
    private Integer[] idTree;
    public arrayBTree(Integer[] arr){
        idTree=arr;
    }
    /**
     * left node is 2n+1
     * right node is 2n+2
     * parent is (n-1)/2
     */
    public void postorderIterate(){
        Stack<Integer> tempSave=new Stack<>();
        if(idTree.length==0){
            throw new emptyTreeException();
        }
        int currentIndex=0;
        int preindex=-1;
        tempSave.push(currentIndex);
        while(!tempSave.isEmpty()){
            currentIndex=tempSave.peek();
            if(2*currentIndex+1>idTree.length || 
                (idTree[2*currentIndex+1]==null && (2*currentIndex+2>idTree.length||idTree[2*currentIndex+2]==null)) || 
                    (preindex==2*currentIndex+1|| preindex==2*currentIndex+2)){
                        tempSave.pop();
                        System.out.printf("%d\t", idTree[currentIndex]);
                        preindex=currentIndex;
                    }
            else{
                if(2*currentIndex+2<idTree.length && idTree[2*currentIndex+2]!=null){
                    tempSave.push(2*currentIndex+2);
                }
                if(2*currentIndex+1<idTree.length && idTree[2*currentIndex+1]!=null){
                    tempSave.push(2*currentIndex+1);
                }
            }
        }
    }
    public void infixIterate(){
        if(idTree.length==0){
            throw new emptyTreeException();
        }
        Stack<Integer> tempSave=new Stack<>();
        int index=0;
        Integer tempInteger=idTree[index];
        while(!tempSave.isEmpty()||tempInteger!=null){
            if(tempInteger!=null){
                tempSave.push(index);
                if(index*2+1<idTree.length){
                    index=index*2+1;
                    tempInteger=idTree[index];
                }
                else{
                    tempInteger=null;
                }
            }
            else{
                index=tempSave.pop();
                tempInteger=idTree[index];
                System.out.printf("%d\t", tempInteger);
                if(index*2+2<idTree.length){
                    index=index*2+2;
                    tempInteger=idTree[index];
                }
                else{
                    tempInteger=null;
                }
            }
        }
    }
    private void preorderIterate(int index){
        System.out.printf("%d\t", idTree[index]);
        if(index*2+1<idTree.length && idTree[index*2+1]!=null){
            preorderIterate(2*index+1);
        }
        if(index*2+2<idTree.length && idTree[index*2+2]!=null){
            preorderIterate(2*index+2);
        }
    }

    public void preorderIterate() throws emptyTreeException{
        if(idTree.length==0){
            throw new emptyTreeException();
        }
        preorderIterate(0);
    }
}
