package recursion;

public class backTrackingTest {
    public static void main(String[] args) {
        int[][] obstacles={{2,1},{2,2}};
        backTracking testBackTracking=new backTracking(5, 5,obstacles);
        if(testBackTracking.findIfReachable(2, 3)){
            System.out.println("Can be reached, the traces show as follows:");
            testBackTracking.printTrace();
        }
        else{
            System.out.println("Cannot be reached");
        }
    }
}
