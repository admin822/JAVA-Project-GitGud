package tree.AVL;

import java.util.Random;

import linked_list.nodeDoesNotExistException;
import tree.emptyTreeException;

public class AVLTest {
    public static void main(String[] args) {
        Random randomIntGenerator=new Random(20201125);
        Integer[] init=new Integer[10];
        for(int i=0;i<5000000;i++){
            for(int j=0;j<10;j++){
                init[j]=randomIntGenerator.nextInt(100);
            }
            AVL testAVL=new AVL(init);
            if(testAVL.checkIfUnbalance()){
                try{
                    testAVL.infixIterate();
                }catch (emptyTreeException e){
                    System.out.println("empty tree");
                }
                break;
            }
            for(int k:init){
                try{
                    testAVL.delete(k);
                    if(testAVL.checkIfUnbalance()){
                        testAVL.infixIterate();
                        System.out.println("$$$$$$$$$$$$$$$$");
                        for(int y:init){
                            System.out.printf("%d\t", y);
                        }
                        return;
                    }
                }catch(nodeDoesNotExistException e){
                    System.out.println("node does not exist");
                    return;
                }catch(emptyTreeException e1){
                    System.out.println("tree is empty");
                    return;
                }
            }
        }
    }
    
}
