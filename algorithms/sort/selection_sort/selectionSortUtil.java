package sort.selection_sort;

public class selectionSortUtil {
    public static void swapTwo(double[] array, int i, int j){
        double temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static int findLargestElementIndex(double[] array, int startIndex){
        double max=array[startIndex];
        int maxIndex=startIndex;
        for(int i=startIndex+1;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    public static int findSmallestElementIndex(double[] array, int startIndex){
        double min=array[startIndex];
        int minIndex=startIndex;
        for(int i=startIndex+1;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
}
