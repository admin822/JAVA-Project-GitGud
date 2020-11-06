package search;

import java.util.Arrays;
import java.util.Random;

import sort.swap_sort.quickSort;
import search.util;


public class searchingTest {

    private static double[] createRandomDoubleArray(Random randomGenerator,int size){
        double [] dArray=new double[size];
        for(int i=0; i<size;i++){
            dArray[i]=randomGenerator.nextDouble();
        }
        return dArray;
    }

    private static double generateRandomTarget(double [] originArray,Random randomDoubleGenerator, Random randomIntGenerator, int upperBound){
        int tossUp=randomIntGenerator.nextInt(upperBound);
        if(upperBound<originArray.length){
            return originArray[tossUp];
        }
        else{
            return randomDoubleGenerator.nextDouble();
        }
    }

    public static void main(String[] args) {
        int SIZEOFARRAY=20;
        long startTime=System.currentTimeMillis();
        Random randomDoubleGenerator= new Random(20200922);
        Random randomIntGenerator=new Random(20200822);
        for( int i =0;i<5000000;i++){
            double [] arrayForCandidate=createRandomDoubleArray(randomDoubleGenerator, SIZEOFARRAY);
            quickSort.sort(arrayForCandidate, false);
            double target= generateRandomTarget(arrayForCandidate, randomDoubleGenerator, randomIntGenerator,5*SIZEOFARRAY);
            int standardIndex=linearSearch.search(arrayForCandidate, target);
            int testIndex=binarySearch.search(arrayForCandidate, target, true); //5068
            if(standardIndex!=testIndex){
                util.printDoubleArray(arrayForCandidate);
                System.out.printf("The printout for standard index is %d ,and test is %d, target is %.2f\n",standardIndex,testIndex,target);
                break;
            }
        }
        System.out.printf("Finished in %d",System.currentTimeMillis()-startTime);
    }
}
