package ringed_linked_list;

public class ringedListTest {
    public static void josephProblem(Integer numberOfNodes,Integer startWith, Integer count ){
        ringedList rList=new ringedList();
        for(int i=0;i<numberOfNodes;i++){
            rList.append(i+1, null);
        }
        rList.iterativelyPrintAllNodes();
        rList.josepthAlgorithm(startWith, count);
    }
    public static void main(String[] args) {
        ringedList testRingedList=new ringedList();
        testRingedList.append(1, "barry");
        testRingedList.append(2, "clark");
        testRingedList.append(3, "diana");
        testRingedList.append(4, "bruce");
        testRingedList.iterativelyPrintAllNodes();
        josephProblem(10, 2, 3);
    }
}
