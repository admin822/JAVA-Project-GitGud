package heap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.function.DoublePredicate;

import tree.binary_tree.test;

public class heapTest {
    private static boolean checkIfSame(Double[] a, Double[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int HEAPSIZE=8;
        heap testHeap;
        Random doubleGenerator=new Random(202011);
        Double [] candidateArray=new Double[HEAPSIZE];
        Double[] standardArray;
        Double[] backup;
        for(int j=0;j<100000;j++){
            for(int i=0;i<HEAPSIZE;i++){
                candidateArray[i]=doubleGenerator.nextDouble();
            }
            testHeap=new heap(candidateArray);
            standardArray=candidateArray.clone();
            backup=candidateArray.clone();
            Arrays.sort(standardArray);
            testHeap.sort(false);
            if(checkIfSame(testHeap.getHeap(), standardArray)==false){
                testHeap.print();
                for(Double d:standardArray){
                    System.out.printf("%f\t", d);
                }
                System.out.println();
                for(Double f:backup){
                    System.out.printf("%f\t", f);
                }
                break;
            }
        }
    }
}
