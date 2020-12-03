import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;


class testClass implements Comparable{
    
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }
}

class test{
    public static void main(String[] args) {
        int a=Integer.MAX_VALUE;
        int []aaa={1,2};
        aaa=Arrays.copyOfRange(aaa, 1, aaa.length);
        for(int i:aaa){
            System.out.println(i);
        }
        double b=Double.POSITIVE_INFINITY;
        System.out.println(a);
        Queue q=new LinkedList<String>();
        Map<Character,Integer> dic=new HashMap<>();
        dic.put('c', 9031);
        LinkedList<Integer> linkeda=new LinkedList<>();
        linkeda.add(0, 10123);
        linkeda.add(0,2012321);
        for(int i:linkeda){
            System.out.println(i);
        }
        ArrayList<Integer> testA=new ArrayList<>();
        double[]abc=new double[10];
        ArrayList<int[]> testAA=new ArrayList<>();
        testA.add(1);
        testA.add(2);
        Stack<Integer> sa=new Stack<>();
        sa.push(156);
        sa.push(270);
        
        int []saa= sa.stream().mapToInt(i->i).toArray();
        for(int i:saa){
            System.out.println(i);
        }
        String ssa="123";
        Stack<Character> csa=new Stack<>();
        csa.add('c');
        int csaCast=(int) csa.peek();
        System.out.println(csaCast);
        System.out.println(String.valueOf(ssa.charAt(0)));
        sa.push(Character.getNumericValue(ssa.charAt(2)));
        System.out.println(testA.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", ""));
        }
}
