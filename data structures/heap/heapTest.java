package heap;

import tree.binary_tree.test;

public class heapTest {
    public static void main(String[] args) {
        Double[] initArray={1.0,3.0,4.0,2.0,11.0,331.0,23.0,1.0};
        heap testHeap=new heap(initArray);
        testHeap.buildHeap(initArray.length-1, true);
        testHeap.print();
        testHeap.buildHeap(initArray.length-1, false);
        testHeap.print();
    }
}
