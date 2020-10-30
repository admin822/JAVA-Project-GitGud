package sort.insertion_sort;

public class insertionSortUtil {
    public static void insert(double value, double[] array, int endIndex){
        int i;
        for(i=endIndex;i>=0;i--){
            if(value<array[i]){
                array[i+1]=array[i];
            }
            else{
                break;
            }
        }
        array[i+1]=value;
    }
    public static void insertReverse(double value, double[] array, int endIndex){
        int i;
        for(i=endIndex;i>=0;i--){
            if(value>array[i]){
                array[i+1]=array[i];
            }
            else{
                break;
            }
        }
        array[i+1]=value;
    }
}
