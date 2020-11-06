package search;

import java.util.ArrayList;

public class util {

    public  static void printDoubleArray(double [] dArray){
        for(double d: dArray){
            System.out.printf("%.2f\t", d);
        }
        System.out.println();
    }

    public static void printArrayList(ArrayList<Integer> aList){
        for (Integer d:aList){
            System.out.printf("%d\t", d);
        }
        System.out.println();
    }
}
