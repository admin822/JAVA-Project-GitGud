package package2;
import package1.p1_hello_world;

public class p2_hello_world {
    double instance_var=1.123123;
    static int static_var=10;
    public static void main(String[] args) {
        int method_var=1;
        int test_int=10;
        test_int+=method_var;
        int thry_int=test_int>method_var?3:4;
        System.out.println(thry_int);
        System.out.println(test_int);
        String s_var="asdfasd";
        String s_sum=s_var+method_var;
        System.out.println(s_sum);
        p2_hello_world test_p1=new p2_hello_world();
        //int c=test_p1.reduction(5, 3);
        System.out.println(method_var);
        System.out.println(test_p1.instance_var);
        System.out.println(static_var);
        System.out.println(test_p1.instance_var+static_var);
        int temp1=test_p1.summation(1, 2);
        int temp2=test_p1.summation(1, 2, 3);
        double temp3=test_p1.summation(1.123123, 2.123);
    }
    public double summation (double a ,double b)
    {
        System.out.println(" this is  the summation of two doubles");
        return a+b;
    }
    public int summation(int a , int b )
    {
        System.out.println("this is the summation of two number");
        return (a+b);
    }
    public int summation(int a, int b, int c)
    {
        System.out.println("this is the summation of three number");
        return (a+b+c);
    }

}