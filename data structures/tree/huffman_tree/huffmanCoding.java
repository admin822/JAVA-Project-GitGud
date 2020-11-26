package tree.huffman_tree;

import java.util.HashMap;
import java.util.Set;

import jdk.jshell.execution.StreamingExecutionControl;


public class huffmanCoding {
    private huffmanTree codingTree;
    private String originalText;
    private HashMap<Character,Integer> characterFreq=new HashMap<>();
    private HashMap<Character,String> characterCode=new HashMap<>();
    private HashMap<String,Character> reverseCharacterCode=new HashMap<>();
    public huffmanCoding(String originalText){
        this.originalText=originalText;
        getCharFreq();
        Integer[] initWeights=new Integer[characterFreq.size()];
        Character[] initValues=new Character[characterFreq.size()];
        initWeights=characterFreq.values().toArray(initWeights);
        initValues=characterFreq.keySet().toArray(initValues);
        codingTree=new huffmanTree(initWeights,initValues);
        characterCode=codingTree.getHuffmanCodes();
        getReverseHuffmanCodes();
    }
    public huffmanTree getCodingTree(){
        return this.codingTree;
    }
    private void getReverseHuffmanCodes(){
        for(Character c:characterCode.keySet()){
            reverseCharacterCode.put(characterCode.get(c), c);
        }
    }
    private void getCharFreq(){
        Character tempChar;
        Integer tempInt;
        for(int i=0;i<originalText.length();i++){
            tempChar=originalText.charAt(i);
            if(characterFreq.get(tempChar)==null){
                characterFreq.put(tempChar,1);
            }
            else{
                tempInt=characterFreq.get(tempChar);
                characterFreq.put(tempChar,tempInt+1);
            }
        }
    }
    private String str2Binary(String originalString){
        String result="";
        for(int i=0;i<originalString.length();i++){
            result+=Integer.toBinaryString(originalString.charAt(i));
        }
        return result;
    }
    public void printHuffmanCodeDictionary(){
        for(Character c:characterCode.keySet()){
            System.out.println(String.format("%c:\t%s", c,characterCode.get(c)));
        }
    }
    public String getBinaryCode(){
        return str2Binary(this.originalText);
    }
    public String fromHuffmanToString(String huffmanCodeString){
        String result="";
        String codeSnipt;
        int startPoint=0;
        for(int i=0;i<huffmanCodeString.length();i++){
            codeSnipt=huffmanCodeString.substring(startPoint, i+1);
            if(reverseCharacterCode.get(codeSnipt)!=null){
                startPoint=i+1;
                result+=reverseCharacterCode.get(codeSnipt);
            }
        }
        return result;
    }
    public String getHuffmanCoding(){
        String result="";
        for(int i=0;i<originalText.length();i++){
            result+=characterCode.get(originalText.charAt(i));
        }
        return result;
    }
    public byte[] getHuffmanCodingByte(){
        String huffmanCode=getHuffmanCoding();
        int byteLength=(huffmanCode.length()+7)/8;
        byte[] huffmanCodingByte=new byte[byteLength];
        String temp;
        byte tempByte;
        int huffmanCodingByteIndex=0;
        for(int i=0;i<huffmanCode.length()-1;i+=8){
            if(i+8>huffmanCode.length()){
                temp=huffmanCode.substring(i);
            }
            else{
                temp=huffmanCode.substring(i, i+8);
            }
            tempByte=(byte)Integer.parseInt(temp, 2);
            huffmanCodingByte[huffmanCodingByteIndex]=tempByte;
            huffmanCodingByteIndex++;
        }
        return huffmanCodingByte;
    }
    private String byteToString(boolean isLast, byte val, int lastLength){
        String result;
        int newVal=val&0xFF;
        if(isLast){
            // result=String.format("%8s", Integer.toBinaryString(newVal).replace(' ', '0'));
            result=String.format("%8s", Integer.toBinaryString(newVal)).replace(' ', '0');
            result=result.substring(8-lastLength);
        }
        else{
            result=String.format("%8s", Integer.toBinaryString(newVal)).replace(' ', '0');
        }
        return result;
    }
    public String huffmanCodingBytesToHuffmanCode(byte[] huffmanBytes,int huffmanCodeLength){
        String result="";
        int lastLength=huffmanCodeLength%8;
        for(int i =0;i<huffmanBytes.length;i++){
            if(i==huffmanBytes.length-1){
                result+=byteToString(true, huffmanBytes[i],lastLength);
            }
            else{
                result+=byteToString(false, huffmanBytes[i],lastLength);
            }
        }
        return result;
    }
}
