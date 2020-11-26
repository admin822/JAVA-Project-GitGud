package tree.huffman_tree;

public class huffmanCodingTest {
    public static void main(String[] args) {
        String originalText="abc::()<,cbadf";
        huffmanCoding testCoding=new huffmanCoding(originalText);
        testCoding.printHuffmanCodeDictionary();
        testCoding.getCodingTree().prefixIterate();
        
        System.out.println(testCoding.getBinaryCode().length()); //466
        System.out.println(testCoding.getHuffmanCoding().length()); //270
        byte[] huffmanCodingByte=testCoding.getHuffmanCodingByte();
        byte[] originalByte=originalText.getBytes();
        System.out.println(huffmanCodingByte.length);
        System.out.println(originalByte.length);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        for(byte b:huffmanCodingByte){
            System.out.println(b);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        for(byte b:originalByte){
            System.out.println(b);
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$");
        String standardHuffmanCode=testCoding.getHuffmanCoding();
        System.out.println(testCoding.huffmanCodingBytesToHuffmanCode(huffmanCodingByte,standardHuffmanCode.length()));
        System.out.println(standardHuffmanCode);
    }
}
