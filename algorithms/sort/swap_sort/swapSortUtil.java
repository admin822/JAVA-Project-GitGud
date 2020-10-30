package sort.swap_sort;

public class swapSortUtil {
    public static void swapTwo(double[] array, int i, int j){
        double temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
