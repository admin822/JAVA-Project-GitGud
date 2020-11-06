package search;

import java.util.ArrayList;
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
        if(tossUp<originArray.length){
            return originArray[tossUp];
        }
        else{
            return randomDoubleGenerator.nextDouble();
        }
    }

    public static void main(String[] args) {
        int SIZEOFARRAY=31;
        long startTime=System.currentTimeMillis();
        Random randomDoubleGenerator= new Random(20200922);
        Random randomIntGenerator=new Random(20200822);

        // multi-turn test
        for( int i =0;i<5000000;i++){
            double [] arrayForCandidate=createRandomDoubleArray(randomDoubleGenerator, SIZEOFARRAY);
            quickSort.sort(arrayForCandidate, false);
            double target= generateRandomTarget(arrayForCandidate, randomDoubleGenerator, randomIntGenerator,2*SIZEOFARRAY);
            ArrayList<Integer> standardIndex=linearSearch.search(arrayForCandidate, target);
            // ArrayList<Integer> testIndex=binarySearch.search(arrayForCandidate, target, false); //5154(20), 8313(31)
            ArrayList<Integer> testIndex=binarySearch.search(arrayForCandidate, target, true); //Finished in 5179(20), 8275(31)
            if(util.twoArrayListEqual(standardIndex, testIndex)==false){
                System.out.printf("test failed!\n");
                util.printArrayList(standardIndex);
                util.printArrayList(testIndex);
                util.printDoubleArray(arrayForCandidate);
                System.out.println(target);
                break;
            }
        }
        
        //single test to show the result
        // double[] test={0.045551,0.070124,0.211741,0.231815,0.235034,0.235547,0.261222,0.289920,0.430186,0.552746,0.595124,0.643247, 0.760060, 0.793720,.798288, 0.803105, 0.885878,  0.904442, 0.961163, 0.974991};
        // quickSort.sort(test, false);
        // ArrayList<Integer> indexes=binarySearch.search(test, 0.08436308851432517,false);
        // ArrayList<Integer> anotherindex=linearSearch.search(test, 2);
        // util.printArrayList(anotherindex);
        // util.printArrayList(indexes);
        System.out.printf("Finished in %d",System.currentTimeMillis()-startTime);
    }
}
