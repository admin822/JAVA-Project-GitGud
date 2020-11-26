package file_compressor.test_data;

import file_compressor.fileCompressor;

public class compressorTest {
    public static void main(String[] args) {
        /**
         * test compressing text file
         */
        // try{
        //     fileCompressor.compress("file_compressor/test_data/testImage.png", "file_compressor/test_data/CompressedtestImage.hmc");
        // }catch(Exception e){
        //     System.out.printf("compression failed due to :%s\n",e.getMessage());
        // }

        /**
         * test decompressing text file
         */
        try{
            fileCompressor.decompress("file_compressor/test_data/CompressedtestImage.hmc", "file_compressor/test_data/DecompressedtestImage.png");
        }catch(Exception e){
            System.out.printf("compression failed due to :%s\n",e.getMessage());
        }

    }
}
