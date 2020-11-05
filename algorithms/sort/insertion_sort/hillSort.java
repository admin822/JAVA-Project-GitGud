package sort.insertion_sort;

import java.util.ArrayList;

import sort.sortingTest;
import sort.sortingUtil;

public class hillSort {
    private static void innerInsert(double[] array,ArrayList<Integer> indexs){
        double target;
        int j;
        for(int i=1;i<indexs.size();i++){
            target=array[indexs.get(i)];
            for(j=i-1;j>=0;j--){
                if(target>=array[indexs.get(j)]){
                    break;
                }
                else{
                    array[indexs.get(j+1)]=array[indexs.get(j)];
                }
            }
            array[indexs.get(j+1)]=target;
        }
    }
    private static void innerInsertReverse(double[] array,ArrayList<Integer> indexs){
        double target;
        int j;
        for(int i=1;i<indexs.size();i++){
            target=array[indexs.get(i)];
            for(j=i-1;j>=0;j--){
                if(target<=array[indexs.get(j)]){
                    break;
                }
                else{
                    array[indexs.get(j+1)]=array[indexs.get(j)];
                }
            }
            array[indexs.get(j+1)]=target;
        }
    }
    public static void sort(double []origin,boolean isReversed){
        int step=origin.length/2;
        ArrayList<Integer> indexes=new ArrayList<Integer>();
        while(step>0){
            for(Integer i=0;i<step;i++){
                indexes.clear();
                for(Integer j=i;j<origin.length;j+=step){
                    indexes.add(j);
                }
                // sortingUtil.printArrayList(indexes);
                if(isReversed){
                    innerInsertReverse(origin, indexes);
                }
                else{
                    innerInsert(origin, indexes);
                    // sortingUtil.printDoubleArray(origin);
                }
                
            }
            step/=2;
        }
    }
}
