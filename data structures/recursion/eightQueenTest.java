package recursion;


public class eightQueenTest {
    public static void main(String[] args) {
        eightQueens testEightQueens=new eightQueens(5);
        testEightQueens.placeQueen(0);
        System.out.printf("There are %d solutions found", testEightQueens.getNumberOfSolutions());
    }
}
