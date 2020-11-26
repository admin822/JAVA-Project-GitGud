package tree.AVL;

public class isolatedAVLTest {
    public static void main(String[] args) {
        Integer[] init={31,91,24,66,3,54,30,69,58,12};
        AVL testAVL=new AVL(init);
        testAVL.infixIterate();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ ");
        try{
            testAVL.delete(31);
            testAVL.infixIterate();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$ ");
            testAVL.delete(91);
            testAVL.infixIterate();
        }catch(Exception e){
            System.out.println("deletion failed");
        }
        
    }
}
