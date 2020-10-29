package recursion;


public class eightQueens {
    private int numberOfQueens;
    private int[] chessboard;
    private int numberOfSolutions;
    
    public eightQueens(Integer numberOfQueens){
        this.numberOfQueens=numberOfQueens;
        this.chessboard=new int[this.numberOfQueens];
        this.numberOfSolutions=0;
    }

    public void showChessboard(){
        System.out.print("The current chess show as follows:\t");
        for (int i:this.chessboard){
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    // this function will be used to check whether the current placement of queen is legal, if legal return true, else false
    private boolean checkPrevious(Integer queenNumber,Integer currentPlace){
        for(int i=0;i<queenNumber;i++){
            if(this.chessboard[i]==currentPlace)
                return false; // queens cannot be on the same column
            else if(Math.abs(queenNumber-i)==Math.abs(currentPlace-chessboard[i]))
                return false;
        }
        return true;
    }

    private void printChessboard(){
        for(int i:chessboard){
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public int getNumberOfSolutions(){
        return this.numberOfSolutions;
    }

    // this function will be used to place queen with a recursive manner.
    public void placeQueen(Integer queenNumber){
        if(queenNumber==this.numberOfQueens-1){
            for(int i=0;i<this.numberOfQueens;i++){
                if(this.checkPrevious(queenNumber, i)){
                    this.chessboard[queenNumber]=i;
                    // System.out.println("asdfa");
                    this.numberOfSolutions++;
                    this.printChessboard();
                }
        }
    }
        else{
            for(int i=0;i<this.numberOfQueens;i++){
                if(this.checkPrevious(queenNumber, i)){
                    this.chessboard[queenNumber]=i;
                    // System.out.printf("%d:%d", queenNumber,i);
                    // System.out.println();
                    placeQueen(queenNumber+1);
                }
            }
        }
    }
}

