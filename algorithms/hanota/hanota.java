package hanota;

import java.util.List;
import java.util.Stack;
// leetcode: https://leetcode-cn.com/problems/hanota-lcci/submissions/
public class hanota {
    public  static List<Integer> classA=new Stack<>();
    public static List<Integer> classB=new Stack<>();
    public static List<Integer> classC=new Stack<>();
    public static void print(){
        System.out.println("A:"+classA);
        System.out.println("B:"+classB);
        System.out.println("C:"+classC);
        System.out.println("========================");
    }
    private static void move(int num,List<Integer>from,List<Integer>via,List<Integer>to){
        if(num==0){
            return;
        }
        if(num==1){
            to.add(from.remove(from.size()-1));
            return;
        }
        move(num-1, from, to, via);
        move(1, from, via, to);
        move(num-1, via, from, to);
    }
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }
    public static void main(String[] args) {
        
        classA.add(0);
        classA.add(1);
        classA.add(2);
        classA.add(3);
        classA.add(4);
        
        hanota(classA, classB, classC);
        for(int i:classC){
            System.out.printf("%d\t",i);
        }
    }
}