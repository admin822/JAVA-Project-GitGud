package sort.swap_sort;

import sort.sortingUtil;

public class bubbleSort {

    public static void sort(double [] originArray,boolean isReversed){
            boolean hasSwaped=false;
            for(int i=originArray.length-1;i>0;i--){
                hasSwaped=false;
                for(int j=0;j<i;j++){
                    if(isReversed){
                        if(originArray[j]<originArray[j+1]){
                            swapSortUtil.swapTwo(originArray, j,j+1);
                            hasSwaped=true;
                        }
                            
                    }
                    else{
                        if(originArray[j]>originArray[j+1]){
                            swapSortUtil.swapTwo(originArray, j, j+1);
                            hasSwaped=true;
                        }
                    }
                }
                if(hasSwaped==false){
                    break;
                }
            }
    }
    public static void main(String[] args) {
        double[] testArray={1,47,35,0,123,1,23,41,12,76};
        sortingUtil.printDoubleArray(testArray);
        sort(testArray, true);
        sortingUtil.printDoubleArray(testArray);
    }

}
