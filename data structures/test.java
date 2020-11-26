import java.util.HashMap;

import org.javatuples.Pair;

import tree.treeNode;


public class test {
    private static void func(treeNode node){
        node=null;
    }
    public static void main(String[] args) {
        Pair<String,Integer> a=new Pair<String,Integer>("test", 1);
        System.out.printf("%s,%d", a.getValue0(),a.getValue1());
    }
}
