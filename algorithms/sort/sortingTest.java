package sort;


import java.util.Arrays;
import java.util.Random;

import sort.swap_sort.bubbleSort;
import sort.selection_sort.naiveSelectionSort;

public class sortingTest {
    private static double[] createRandomDoubleArray(Random randomGenerator,int size){
        double [] dArray=new double[size];
        for(int i=0; i<size;i++){
            dArray[i]=randomGenerator.nextDouble();
        }
        return dArray;
    }

    public static void main(String[] args) {
        Random doubleRandomGenerator=new Random();
        double [] arrayForCandidate;
        double [] arrayForStandard;
        long startTime;
        startTime=System.currentTimeMillis();
        for(int i=0;i<5000000;i++){
            arrayForCandidate=createRandomDoubleArray(doubleRandomGenerator, 8);
            arrayForStandard=Arrays.copyOf(arrayForCandidate, arrayForCandidate.length);
            Arrays.sort(arrayForStandard);
            // bubbleSort.sort(arrayForCandidate, false); //1680 secs
            // naiveSelectionSort.sort(arrayForCandidate, false); //1733 secs
            naiveSelectionSort.sort(arrayForCandidate, false); //1786secs
            if(Arrays.equals(arrayForCandidate, arrayForStandard)==false){
                sortingUtil.printDoubleArray(arrayForCandidate);
                sortingUtil.printDoubleArray(arrayForStandard);
                break;
            }
        }
        System.out.printf("The whole process took %d secs", System.currentTimeMillis()-startTime);
    }
}
