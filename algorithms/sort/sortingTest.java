package sort;


import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import sort.swap_sort.bubbleSort;
import sort.swap_sort.quickSort;
import sort.insertion_sort.hillSort;
import sort.other_sort.mergeSort;
import sort.selection_sort.naiveSelectionSort;

public class sortingTest {
    
    private static double[] createRandomDoubleArray(Random randomGenerator,int size){
        double [] dArray=new double[size];
        for(int i=0; i<size;i++){
            dArray[i]=randomGenerator.nextDouble();
        }
        return dArray;
    }

    // I ran the below time consumption test on a Alienware m17r2 laptop, you can search for the specs yourself.
    // when trying to sort in a descending order, I have to use my own bubblesort algorithm as a 'standard algorithm'
    // since the java people find it really brilliant that their sorting Algorithm should not provide a reverse sorting for 
    // primative type arrays.
    public static void main(String[] args) {
        Random doubleRandomGenerator=new Random();
        double [] arrayForCandidate;
        double [] arrayForStandard;
        double [] arrayForBackup;
        long startTime;
        startTime=System.currentTimeMillis();
        for(int i=0;i<5000000;i++){
            arrayForCandidate=createRandomDoubleArray(doubleRandomGenerator, 5);
            arrayForStandard=Arrays.copyOf(arrayForCandidate, arrayForCandidate.length);
            arrayForBackup=Arrays.copyOf(arrayForCandidate, arrayForCandidate.length);
            Arrays.sort(arrayForStandard);
            // bubbleSort.sort(arrayForStandard, true); 
            
            // bubbleSort.sort(arrayForCandidate, false); //7574 secs
            // naiveSelectionSort.sort(arrayForCandidate, false); //602 secs
            // naiveSelectionSort.sort(arrayForCandidate, false); //641secs
            // hillSort.sort(arrayForCandidate, false); //The whole process took 1146 secs
            quickSort.sort(arrayForCandidate, false); //The whole process took 6306 secs
            // mergeSort.sort(arrayForCandidate, false); //The whole process took 1070 secs
            if(Arrays.equals(arrayForCandidate, arrayForStandard)==false){
                sortingUtil.printDoubleArray(arrayForCandidate);
                sortingUtil.printDoubleArray(arrayForStandard);
                sortingUtil.printDoubleArray(arrayForBackup);
                break;
            }
        }
        System.out.printf("The whole process took %d secs", System.currentTimeMillis()-startTime);
    }
}
