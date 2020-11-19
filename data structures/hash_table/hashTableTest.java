package hash_table;

import java.util.ArrayList;
import java.util.Random;

import linked_list.linkedListNode;
import linked_list.nodeDoesNotExistException;

public class hashTableTest {
    public static void main(String[] args) {
        hashtable testTable=new hashtable(15);
        String nameString="askldfujljsxvoiujol23n18904ulknjo89%^*(%^^&ashjkdfjkauioq2wuraskdf";
        Random idGenerator=new Random(20201118);
        int counter=0;
        Integer newId;
        ArrayList<linkedListNode> result=new ArrayList<linkedListNode>();
        String newName;
        for(int i=0;i<20;i++){
            newId=idGenerator.nextInt(1000);
            newName=nameString.substring(counter%(nameString.length()-5), counter%(nameString.length()-5)+5);
            counter+=5;
            System.out.println(newId);
            testTable.append(newId, newName);
        }
        testTable.append(30,"sadfasdf");
        testTable.printHashTable();
        try{
            result=testTable.find(300000);
            for(linkedListNode lln:result){
                System.out.println(lln.getName());
            }
        }catch(nodeDoesNotExistException e){
            System.out.println("Does not exist");
        }
        
        

    }
}
