package sort.other_sort;


public class mergeSort {
    
    
    private static void mergeTwo(double[] originArray,int start, int end,boolean isReversed){
        double tempArray[]=new double[end-start+1];
        int startBackUp=start;
        int firstEnd=(end+start)/2;
        int secondStart=firstEnd+1;
        int tempArrayCounter=0;
        while(start<=firstEnd && secondStart<=end){
            if(isReversed){
                if(originArray[start]>=originArray[secondStart]){
                    tempArray[tempArrayCounter]=originArray[start];
                    start++;
                }
                else{
                    tempArray[tempArrayCounter]=originArray[secondStart];
                    secondStart++;
                }
            }
            else{
                if(originArray[start]<=originArray[secondStart]){
                    tempArray[tempArrayCounter]=originArray[start];
                    start++;
                }
                else{
                    tempArray[tempArrayCounter]=originArray[secondStart];
                    secondStart++;
                }
            }
            tempArrayCounter++;
        }
        while(start<=firstEnd){
            tempArray[tempArrayCounter]=originArray[start];
            tempArrayCounter++;
            start++;
        }
        while(secondStart<=end){
            tempArray[tempArrayCounter]=originArray[secondStart];
            tempArrayCounter++;
            secondStart++;
        }
        System.arraycopy(tempArray, 0, originArray, startBackUp,tempArray.length);
    }


    private static void sort(double[] originArray, int start, int end, boolean isReversed){
        if(start>=end){
            return;
        }
        sort(originArray,start,(end+start)/2, isReversed);
        sort(originArray,(end+start)/2+1,end, isReversed);
        mergeTwo(originArray, start, end, isReversed);
    }

    public static void sort(double[] originArray, boolean isReversed){
        sort(originArray, 0, originArray.length-1, isReversed);
    }
}
