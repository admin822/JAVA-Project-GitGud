package sort.insertion_sort;

public class naiveInsertionSort {
    public static void sort(double[] originArray,boolean isReversed){
        for(int i=1;i<originArray.length;i++){
            if(isReversed){
                insertionSortUtil.insertReverse(originArray[i], originArray, i-1);
            }
            else{
                insertionSortUtil.insert(originArray[i], originArray, i-1);
            }
        }
    }
}
