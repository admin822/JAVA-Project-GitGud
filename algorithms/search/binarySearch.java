package search;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class binarySearch {

    private static ArrayList<Integer> recursiveSearch(double []originArray, int start, int end, double target){
        // caution advised: when start equals to end, which means exactly ONE element is in your
        // input array, it still has a chance to match your target.
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(start>end){
            return result;
        }
        int middle=(start+end)/2;
        if(originArray[middle]==target){
            result.add(middle);
            int temp=middle-1;
            while(temp>=start && originArray[temp]==target){
                result.add(temp);
                temp--;
            }
            temp=middle+1;
            while(temp<=end && originArray[temp]==target){
                result.add(temp);
                temp++;
            }
            return result;
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
    private static ArrayList<Integer> insertionSearch(double []originArray, int start, int end, double target){
        ArrayList<Integer> result=new ArrayList<Integer>();
        // System.out.printf("%d,%d\n",start,end);
        if(start>end){
            return result;
        }
        // we cannot allow this situation proceed to the next section, because it will cause the self adjusting offset
        // calculation go wrong.
        if(start==end){
            if(originArray[start]==target){
                result.add(start);
            }
            return result;
        }

        // very crucial, if target larger than largest in array or smaller than smallest, it's gonna cause the classic
        // stack overflow exception.
        if(target<originArray[start]||target>originArray[end]){
            return result;
        }


        double selfAdjustingOffset=(target-originArray[start])/(originArray[end]-originArray[start])*(end-start);
        int middle=start+(int) selfAdjustingOffset;
        if(originArray[middle]==target){
            result.add(middle);
            int temp=middle-1;
            while(temp>=start && originArray[temp]==target){
                result.add(temp);
                temp--;
            }
            temp=middle+1;
            while(temp<=end && originArray[temp]==target){
                result.add(temp);
                temp++;
            }
            return result;
        }
        // since the array is sorted in ascending order, check what's right to the middle!
        else if(originArray[middle]<target){
            return insertionSearch(originArray,middle+1,end,target);
        }
        else{
            return insertionSearch(originArray,start,middle-1,target);
        }

    }

    public static ArrayList<Integer> search(double[] originArray, double target, boolean requireInsertion){
        if(requireInsertion==false){
            return recursiveSearch(originArray, 0, originArray.length-1, target);
        }
        else{
            return insertionSearch(originArray,0,originArray.length-1,target);
        }
    }
}
