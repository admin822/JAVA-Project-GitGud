package linked_list;

public class linkedListTest {
    public static void main(String[] args) {
        linkedList testList=new linkedList();
        testList.append(1, "clark");
        testList.append(2, "bruce");
        testList.append(3, "diana");
        testList.append(4, "barry");
        testList.iterate();
    }
}
