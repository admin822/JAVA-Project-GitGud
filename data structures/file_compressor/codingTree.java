package file_compressor;

import java.util.ArrayList;
import java.util.Collections;

public class codingTree {
    private codingTreeNode root;
    private ArrayList<codingTreeNode> initList=new ArrayList<>();
    public codingTree(Integer[] initWeights,Byte[] initValues){
        for(int i=0;i<initValues.length;i++){
            initList.add(new codingTreeNode(initWeights[i], initValues[i]));
        }
        buildCodingTree();
    }
    private void buildCodingTree(){
        codingTreeNode leftNode;
        codingTreeNode rightNode;
        while(initList.size()>1){
            Collections.sort(initList);
            leftNode=initList.get(0);
            rightNode=initList.get(1);
            codingTreeNode parentNode=new codingTreeNode(leftNode.getWeight()+rightNode.getWeight());
            parentNode.left=leftNode;
            parentNode.right=rightNode;
            initList.remove(leftNode);
            initList.remove(rightNode);
            initList.add(parentNode);
        }
        root=initList.get(0);
    }
    public codingTreeNode getRoot(){
        return this.root;
    }

}
