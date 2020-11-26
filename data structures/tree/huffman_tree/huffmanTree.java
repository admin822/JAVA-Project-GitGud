package tree.huffman_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import linked_list.linkedList;


public class huffmanTree {
    private huffmanTreeNode root;
    private ArrayList<huffmanTreeNode> initList=new ArrayList<>();
    public huffmanTree(Integer[] init){
        for(Integer i:init){
            initList.add(new huffmanTreeNode(i));
        }
        Collections.sort(initList);
        System.out.printf("Current nodes are:\t");
        printInitList();
        buildHuffmanTree();
    }
    public huffmanTree(Integer[] initWeights, Character[] initValues){
        for(int i=0;i<initValues.length;i++){
            initList.add(new huffmanTreeNode(initWeights[i], initValues[i]));
        }
        buildHuffmanTree();
    }
    private void buildHuffmanTree(){
        huffmanTreeNode leftNode;
        huffmanTreeNode rightNode;
        while(initList.size()>1){
            Collections.sort(initList);
            leftNode=initList.get(0);
            rightNode=initList.get(1);
            huffmanTreeNode parentNode=new huffmanTreeNode(leftNode.getWeight()+rightNode.getWeight());
            parentNode.left=leftNode;
            parentNode.right=rightNode;
            initList.remove(leftNode);
            initList.remove(rightNode);
            initList.add(parentNode);
        }
        root=initList.get(0);
    }
    public HashMap<Character,String> getHuffmanCodes(){
        HashMap<Character,String> result=new HashMap<Character,String>();
        Queue<huffmanTreeNode> tempSave=new LinkedList<huffmanTreeNode>();
        huffmanTreeNode tempNode;
        tempSave.offer(this.root);
        while(!tempSave.isEmpty()){
            tempNode=tempSave.poll();
            if(tempNode.getValue()!=null){
                result.put(tempNode.getValue(),tempNode.getCode());
            }
            if(tempNode.left!=null){
                tempNode.left.setCode(tempNode.getCode()+"0");
                tempSave.offer(tempNode.left);
            }
            if(tempNode.right!=null){
                tempNode.right.setCode(tempNode.getCode()+"1");
                tempSave.offer(tempNode.right);
            }
        }
        return result;
    }
    private void prefixIterate(huffmanTreeNode start){
        if(start.getValue()!=null){
            System.out.printf("%d:%s\t", start.getWeight(),start.getValue());
        }
        else{
            System.out.printf("%d\t", start.getWeight());
        }
        if(start.left!=null){
            prefixIterate(start.left);
        }
        if(start.right!=null){
            prefixIterate(start.right);
        }
    }   
    public void prefixIterate(){
        prefixIterate(root);
        System.out.println();
    }
    public void printInitList(){
        for(huffmanTreeNode temp:initList){
            if(temp.getValue()!=null){
                System.out.printf("%d:%s\t", temp.getWeight(),temp.getValue());
            }
            else{
                System.out.printf("%d\t", temp.getWeight());
            }
            System.out.printf("%d\t", temp.getWeight());
        }
        System.out.println();
    }
    public huffmanTreeNode getRoot(){
        return this.root;
    }
}
