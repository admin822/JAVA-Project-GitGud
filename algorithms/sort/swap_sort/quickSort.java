package sort.swap_sort;


public class quickSort {

    private static void sort(double[] originArray, int start, int end){
        if(start>=end){
            return;
        }
        int right=end;
        int left= start;
        int pivot=(left+right)/2;
        double pivotVal=originArray[pivot];
        swapSortUtil.swapTwo(originArray, pivot, right);
        right--;
        // this while loop will make sure that the values to the left of the pivot are smaller(if not reversed)l
        while(left<=right){
            while(originArray[left]<pivotVal){
                left++;
            }
            while(right>left && originArray[right]>pivotVal){
                right--;
            }
            if(right<=left){
                break;
            }
            else{
                swapSortUtil.swapTwo(originArray, left, right);
                left++;
                right--;
            }
        }
        swapSortUtil.swapTwo(originArray, left, end);
        quickSort.sort(originArray, left+1, end);
        quickSort.sort(originArray,start , left-1);
    }

    private static void reverseSort(double[] originArray, int start, int end){
        if(start>=end){
            return;
        }
        int right=end;
        int left= start;
        int pivot=(left+right)/2;
        double pivotVal=originArray[pivot];
        swapSortUtil.swapTwo(originArray, pivot, right);
        right--;
        // this while loop will make sure that the values to the left of the pivot are smaller(if not reversed)l
        while(left<=right){
            while(originArray[left]>pivotVal){
                left++;
            }
            while(right>left && originArray[right]<pivotVal){
                right--;
            }
            if(right<=left){
                break;
            }
            else{
                swapSortUtil.swapTwo(originArray, left, right);
                left++;
                right--;
            }
        }
        swapSortUtil.swapTwo(originArray, left, end);
        quickSort.reverseSort(originArray, left+1, end);
        quickSort.reverseSort(originArray,start , left-1);
    }



    public static void sort(double [] originArray, boolean isReversed){
        if(isReversed){
            reverseSort(originArray, 0, originArray.length-1);
        }
        else{
            sort(originArray, 0, originArray.length-1);
        }
        
    }
}
