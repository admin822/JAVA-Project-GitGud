package file_compressor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class fileCompressor {
    public static void decompress(String src, String dst) throws Exception{
        InputStream is=null;
        ObjectInputStream ois=null;
        OutputStream os=null;
        try{
            is=new FileInputStream(src);
            ois=new ObjectInputStream(is);
            byte[] compressedBytes=(byte[]) ois.readObject();
            HashMap<Byte,String> huffmanCodeDict=(HashMap<Byte,String>) ois.readObject();
            String huffmanString=getDecompressedHuffmanString(compressedBytes);
            byte[] decompressedBytes=getOriginalBytes(huffmanString, huffmanCodeDict);
            os=new FileOutputStream(dst);
            os.write(decompressedBytes);
        }catch(Exception e){
            throw e;
        }finally{
            try{
                ois.close();
                os.close();
            }catch(Exception e){
                throw e;
            }
        }
        
    }
    public static void compress(String src, String dst) throws Exception{
        FileInputStream inputStream=null;
        FileOutputStream outputStream=null;
        ObjectOutputStream objectStream=null;
        try{
            inputStream=new FileInputStream(src);
            byte[] fileBytes=new byte[inputStream.available()];
            inputStream.read(fileBytes);
            HashMap<Byte,Integer> byteFreq=getByteFreq(fileBytes);
            Integer[] initWeights=new Integer[byteFreq.size()];
            Byte[] initValues=new Byte[byteFreq.size()];
            initWeights=byteFreq.values().toArray(initWeights);
            initValues=byteFreq.keySet().toArray(initValues);
            codingTree huffmanCoder =new codingTree(initWeights,initValues);
            codingTreeNode coderRoot=huffmanCoder.getRoot();
            HashMap<Byte,String> huffmanCodeDict=getHuffmanCodeDic(coderRoot);
            String huffmanCodeString=getHuffmanCode(huffmanCodeDict, fileBytes);
            byte[] compressedResult=getHuffmanCodingByte(huffmanCodeString);
            System.out.printf("Compression Compele, compression rate is %.2f\n",(fileBytes.length-compressedResult.length+0.0)/fileBytes.length);
            outputStream=new FileOutputStream(dst);
            objectStream=new ObjectOutputStream(outputStream);
            objectStream.writeObject(compressedResult);
            objectStream.writeObject(huffmanCodeDict);

        }catch(Exception e){
            throw e;
        }finally{
            try{
                inputStream.close();
                objectStream.close();
            }catch (Exception e){
                throw e;
            }
        }
    }
    private static byte[] getOriginalBytes(String huffmanString, HashMap<Byte,String> huffmanCodeDictMap){
        HashMap<String,Byte> reverseDict=getReverseHuffmanCodeDict(huffmanCodeDictMap);
        ArrayList<Byte> originalByteList=new ArrayList<>();
        int startPoint=0;
        String codeSnipt;
        for(int i=0;i<huffmanString.length();i++){
            codeSnipt=huffmanString.substring(startPoint, i+1);
            if(reverseDict.get(codeSnipt)!=null){
                startPoint=i+1;
                originalByteList.add(reverseDict.get(codeSnipt));
            }
        }
        byte[] result=new byte[originalByteList.size()];
        int counter=0;
        for(byte b:originalByteList){
            result[counter]=b;
            counter++;
        }
        return result;
    }
    private static HashMap<String,Byte> getReverseHuffmanCodeDict( HashMap<Byte,String> huffmanCodeDictMap){
        HashMap<String, Byte> reverseDict=new HashMap<>();
        for(byte b:huffmanCodeDictMap.keySet()){
            reverseDict.put(huffmanCodeDictMap.get(b), b);
        }
        return reverseDict;
    }
    private static String getDecompressedHuffmanString(byte[] huffmanBytes){
        String result="";
        String ifChanged=Integer.toBinaryString(huffmanBytes[huffmanBytes.length-1]);
        for(int i =0;i<huffmanBytes.length-2;i++){
            result+=byteToString(false, huffmanBytes[i]);
        }
        String temp=byteToString(true, huffmanBytes[huffmanBytes.length-2]);
        if(ifChanged.equals("1")){
            StringBuilder tempbBuilder=new StringBuilder(temp);
            tempbBuilder.setCharAt(0, '0');
            temp=tempbBuilder.toString();
        }
        result+=temp;
        return result;
    }
    private static String byteToString(boolean isLast, byte val){
        String result;
        int newVal=val&0xFF;
        if(isLast){
            // result=String.format("%8s", Integer.toBinaryString(newVal).replace(' ', '0'));
            result=Integer.toBinaryString(newVal);
        }
        else{
            result=String.format("%8s", Integer.toBinaryString(newVal)).replace(' ', '0');
        }
        return result;
    }

    private static byte[] getHuffmanCodingByte(String huffmanCode){
        int byteLength=(huffmanCode.length()+7)/8;
        boolean flag=false;
        byte[] huffmanCodingByte=new byte[byteLength+1];
        String temp;
        byte tempByte;
        int huffmanCodingByteIndex=0;
        for(int i=0;i<huffmanCode.length();i+=8){
            if(i+8>huffmanCode.length()){
                temp=huffmanCode.substring(i);
                if(temp.charAt(0)!='1'){
                    StringBuilder tempBuilder=new StringBuilder(temp);
                    tempBuilder.setCharAt(0, '1');
                    temp=tempBuilder.toString();
                    flag=true;
                }
            }
            else{
                temp=huffmanCode.substring(i, i+8);
            }
            tempByte=(byte)Integer.parseInt(temp, 2);
            huffmanCodingByte[huffmanCodingByteIndex]=tempByte;
            huffmanCodingByteIndex++;
        }
        if(flag){
            huffmanCodingByte[huffmanCodingByteIndex]=(byte)Integer.parseInt("00000001",2);
        }
        else{
            huffmanCodingByte[huffmanCodingByteIndex]=(byte)Integer.parseInt("00000000",2);
        }
        return huffmanCodingByte;
    }

    private static String getHuffmanCode(HashMap<Byte,String> huffmanCodeDict, byte[] originalBytes){
        String result="";
        for(byte b:originalBytes){
            result+=huffmanCodeDict.get(b);
        }
        return result;
    }
    private static HashMap<Byte,String> getHuffmanCodeDic(codingTreeNode root){
        HashMap<Byte,String> result=new HashMap<Byte,String>();
        Queue<codingTreeNode> tempSave=new LinkedList<codingTreeNode>();
        codingTreeNode tempNode;
        tempSave.offer(root);
        while(!tempSave.isEmpty()){
            tempNode=tempSave.poll();
            if(tempNode.getValue()!=null){
                result.put(tempNode.getValue(),tempNode.getCode());
            }
            if(tempNode.left!=null){
                tempNode.left.setCode(tempNode.getCode()+"0");
                tempSave.offer(tempNode.left);
            }
            if(tempNode.right!=null){
                tempNode.right.setCode(tempNode.getCode()+"1");
                tempSave.offer(tempNode.right);
            }
        }
        return result;
    }
    private static HashMap<Byte,Integer> getByteFreq(byte[] originalBytes){
        Integer tempInt;
        HashMap<Byte,Integer> byteFreq=new HashMap<>();
        for(byte b:originalBytes){
            if(byteFreq.get(b)==null){
                byteFreq.put(b, 1);
            }
            else{
                tempInt=byteFreq.get(b);
                byteFreq.put(b, tempInt+1);
            }
        }
        return byteFreq;
    }
}
