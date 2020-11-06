package search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class util {

    public  static void printDoubleArray(double [] dArray){
        for(double d: dArray){
            System.out.printf("%f\t", d);
        }
        System.out.println();
    }


    public static void printArrayList(ArrayList<Integer> aList){
        for (Integer d:aList){
            System.out.printf("%d\t", d);
        }
        System.out.println();
    }

    public static boolean twoArrayListEqual(ArrayList<Integer>a,ArrayList<Integer>b){
        Collections.sort(a);
        Collections.sort(b);
        if(a.equals(b)){
            return true;
        }
        else{
            return false;
        }
    }
}
