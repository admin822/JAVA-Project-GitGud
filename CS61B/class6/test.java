package class6;
public class test{
    private static int[] a ={1,2,3,4,5}; 
    public static void main(String[] args) {
        mergeArrays myMergeFunc=new mergeArrays();
        int []a={1,2,3};
        int[]b={4,5,6};
        int []c;
        c=myMergeFunc.mergeTwoArrays(a, b);
        int [][] arr=new int [3][];
        arr[0]=arr[1]=arr[2]=new int [] {0,0,0};
        System.out.println(arr[0]+"\t"+arr[1]+"\t"+arr[2]);
    }
}