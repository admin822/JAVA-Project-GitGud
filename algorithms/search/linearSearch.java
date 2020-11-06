package search;

import java.util.ArrayList;

public class linearSearch {
    public static ArrayList<Integer> search(double[] originArray, double target){
        ArrayList<Integer> results=new ArrayList<Integer>();
        for(int i=0; i< originArray.length;i++){
            if(originArray[i]==target){
                results.add(i);
            }
        }
        return results;
    }
}
