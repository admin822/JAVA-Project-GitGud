package search;

public class linearSearch {
    public static int search(double[] originArray, double target){
        for(int i=0; i< originArray.length;i++){
            if(originArray[i]==target){
                return -1;
            }
        }
        return -1;
    }
}
