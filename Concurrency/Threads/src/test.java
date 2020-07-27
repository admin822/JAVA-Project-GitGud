import java.io.IOException;

public class test {
    private static int a;
    private double b;
    public static void main(String[] args) {
        test t1=new test(1,1.1);
        test t2= new test(2,2.2);
        test t3=new test(3,3.3);
        t1.show_a();
        t2.show_a();
        t3.show_a();
    }
    public test(int a,double b)
    {
        this.b=b;
        test.a=a;
    }
    public void show_a()
    {
        System.out.println(a);
        System.out.println(b);
    }
    
}