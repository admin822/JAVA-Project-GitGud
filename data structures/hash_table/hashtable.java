package hash_table;

import java.util.ArrayList;

import linked_list.linkedList;
import linked_list.linkedListNode;
import linked_list.nodeDoesNotExistException;

public class hashtable {
    private Integer size;
    private linkedList[] table;

    public hashtable(Integer size){
        this.size=size;
        this.table=new linkedList[size];
        for(int i=0;i<size;i++){
            this.table[i]=new linkedList();
        }
    }

    public void printHashTable(){
        for(int i=0;i<this.size;i++){
            System.out.printf("$$$$$$$$$$$$$$$$%d$$$$$$$$$$$$$$$$$\n", i+1);
            this.table[i].iterativelyPrintAllNodes();
            System.out.printf("$$$$$$$$$$$$$$$$%d$$$$$$$$$$$$$$$$$\n", i+1);
            System.out.println();
        }
    }

    private int hashFunction(int input){
        return input%this.size;
    }

    public void append(int nodeId, String nodeName){
        int position=this.hashFunction(nodeId);
        this.table[position].append(nodeId,nodeName);
    }

    public void delete(int nodeId) throws nodeDoesNotExistException{
        int position=this.hashFunction(nodeId);
        try{
            this.table[position].deleteNode(nodeId);
        }catch (nodeDoesNotExistException e){
            throw e;
        }
    }

    public ArrayList<linkedListNode> find(int nodeId) throws nodeDoesNotExistException{
        int position=this.hashFunction(nodeId);
        ArrayList<linkedListNode> result=this.table[position].findNode(nodeId);
        if(result.isEmpty()){
            throw new nodeDoesNotExistException();
        }
        else{
            return result;
        }
    }
}
