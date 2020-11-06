package search;

import java.lang.annotation.Target;

public class binarySearch {

    private static int recursiveSearch(double []originArray, int start, int end, double target){
        // caution advised: when start equals to end, which means exactly ONE element is in your
        // input array, it still has a chance to match your target.
        if(start>end){
            return -1;
        }
        int middle=(start+end)/2;
        if(originArray[middle]==target){
            return middle;
        }
        // since the array is sorted in ascending order, check what's right to the middle!
        else if(originArray[middle]<target){
            return recursiveSearch(originArray,middle+1,end,target);
        }
        else{
            return recursiveSearch(originArray,start,middle-1,target);
        }
    }

    // unfinished
    private static int iterativeSearch(double []originArray, int start, int end, double target){
        return -1;

    }

    public static int search(double[] originArray, double target, boolean requireRecursion){
        if(requireRecursion){
            return recursiveSearch(originArray, 0, originArray.length-1, target);
        }
        else{
            return iterativeSearch(originArray,0,originArray.length-1,target);
        }
    }
}
