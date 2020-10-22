package sparse_matrix;
import java.util.Arrays;
import java.util.Random;





/**
 * this class will create 2d sparse matirx and then reverse the process.
 */

public class sparseMatrix {

    private static boolean checkIfInformative(int[][] origin,int xAxis, int yAxis,int rows, int cols,int invalid) throws IndexOutOfBoundsException{
        if(xAxis>=rows || yAxis>=cols){
            throw new IndexOutOfBoundsException();
        }
        else if(origin[xAxis][yAxis]!=invalid){
            return true;
        }
        else{
            return false;
        }
    }

    private static void initializeOrigin(int[][] origin,int invalid){
        int rows=origin.length;
        int cols=origin[0].length;
        for(int i =0;i<rows;i++)
            for (int j=0;j<cols;j++){
                origin[i][j]=invalid;
            }
    }

    private static int[][]  setUp(int numberOfInformativeElements,int rows, int cols,int invalid, int valid) throws IndexOutOfBoundsException,tooManyInformativeException{
        // create a two dim matrix filled with 0(meanning less element)
        if(numberOfInformativeElements>(rows*cols)){
            throw new tooManyInformativeException();
        }
        int origin[][]=new int[rows][cols];
        initializeOrigin(origin, invalid);
        boolean ifInformative=false;
        Random randintGenerator=new Random(202010);
        int counter=0;
        while(counter<numberOfInformativeElements){
            int x=randintGenerator.nextInt(10);
            int y=randintGenerator.nextInt(10);
            try{
                ifInformative=checkIfInformative(origin,x,y,rows, cols,invalid);
                if(ifInformative==false){
                    origin[x][y]=valid;
                    counter++;
                }
                
            }catch (IndexOutOfBoundsException e){
                ;
            }
            
        }
        return origin;
    }
    private static void printTwoDimensionalArray(int[][] origin){
        int rows=origin.length;
        for(int i=0;i<rows;i++){
            System.out.println(Arrays.toString(origin[i]));
        }
    }

    private static int checkNumberOfInformatives(int[][] origin,int invalid){
        int counter=0;
        for( int i=0;i<origin.length;i++)
            for(int j=0;j<origin[0].length;j++){
                if(origin[i][j]!=invalid){
                    counter++;
                }
            }
        return counter;
    }

    private static void fillInSmallMatrix(int[][] origin,int[][] smallMatrix,int invalid){
        int counter=1;
        for(int i=0;i<origin.length;i++)
            for(int j=0;j<origin[0].length;j++){
                if(origin[i][j]!=invalid){
                    smallMatrix[counter][0]=i;
                    smallMatrix[counter][1]=j;
                    smallMatrix[counter][2]=origin[i][j];
                    counter++;
                }
            }
    }   

    public int[][] buildSmallMatrix(int [][] origin,int invalid){
        int numberOfInformatives=checkNumberOfInformatives(origin, invalid);
        int smallMatrix[][]=new int[numberOfInformatives+1][3];
        smallMatrix[0][0]=origin.length;
        smallMatrix[0][1]=origin[0].length;
        smallMatrix[0][2]=numberOfInformatives;
        fillInSmallMatrix(origin, smallMatrix, invalid);
        return smallMatrix;
    }

    public int[][] reverseSmallMatrix(int[][] smallMatrix,int invalid){
        int [][] origin=new int [smallMatrix[0][0]][smallMatrix[0][1]];
        initializeOrigin(origin, invalid);
        for(int i=1;i<smallMatrix.length;i++){
            origin[smallMatrix[i][0]][smallMatrix[i][1]]=smallMatrix[i][2];
        }
        return origin;
    }


    public static void main(String[] args) {
        try{
            int origin[][]=setUp(6, 6, 6, 1, 5);
            printTwoDimensionalArray(origin);
            sparseMatrix sm=new sparseMatrix();
            int[][] smallMatrix=sm.buildSmallMatrix(origin, 1);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
            printTwoDimensionalArray(smallMatrix);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
            int[][] reversedOrigin=sm.reverseSmallMatrix(smallMatrix, 1);
            printTwoDimensionalArray(reversedOrigin);
        }catch(tooManyInformativeException e){
            System.out.println("The nunber of informative elements exceed the total number in the original matrix");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

    }

    }
