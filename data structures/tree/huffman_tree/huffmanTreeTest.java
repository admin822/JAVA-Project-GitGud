package tree.huffman_tree;

public class huffmanTreeTest {
    public static void main(String[] args) {
        Integer[] intArray={2,3,5,1,123,12,32,12};
        huffmanTree testTree=new huffmanTree(intArray);
        // testTree.printInitList();
        testTree.prefixIterate();
    }
}
