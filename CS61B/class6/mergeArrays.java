package class6;

public class mergeArrays {

    /**
     * input:(1) array  a (2)array b
     * output: (1) new array 
     * description: this function will mergetwo SORTED arrays and return a new array that has all the elements in the input arrays, and still SORTED, this one will be the iterative one
     */
    public int[] mergeTwoArrays(int[]a,int[]b){
        int[]c =new int[a.length+b.length];
        int aIndex=0;
        int bIndex=0;
        int cIndex=0;
        if(a.length==0&&b.length==0){
            return c;
        }
        if(a.length==0){
            System.arraycopy(b, 0, c, 0, b.length);
        }
        else if(b.length==0){
            System.arraycopy(a, 0, c, 0, a.length);
        }
        else{
            while(aIndex<a.length&&bIndex<b.length){
                if(a[aIndex]>b[bIndex]){
                    c[cIndex]=b[bIndex];
                    bIndex+=1;
                }
                else{
                    c[cIndex]=a[aIndex];
                    aIndex+=1;
                }
                cIndex+=1;
            }
            if(aIndex!=a.length){
                System.arraycopy(a, aIndex, c, cIndex, a.length-aIndex);
            }
            else{
                System.arraycopy(b, bIndex, c, cIndex, b.length-bIndex);
            }
        }
        return c;
    }
}
