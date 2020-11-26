import class1.test;
import class6.childClass;
import class6.parentClass;

public class testChildClass {
    public static void h(parentClass pc){
        parentClass.g(pc);
    }
    public static void main(String[] args) {
        childClass testChild=new childClass();
        h(testChild);
    }
}
