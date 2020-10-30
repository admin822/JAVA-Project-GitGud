package sort.selection_sort;

public class naiveSelectionSort {
    public static void sort(double[] originArray,boolean isReversed){
        int targetIndex;
        for(int i=0;i<originArray.length-1;i++){
            if(isReversed==false){
                targetIndex=selectionSortUtil.findSmallestElementIndex(originArray, i);
            }
            else{
                targetIndex=selectionSortUtil.findLargestElementIndex(originArray, i);
            }
            selectionSortUtil.swapTwo(originArray, i, targetIndex);
        }
    }
    
}
