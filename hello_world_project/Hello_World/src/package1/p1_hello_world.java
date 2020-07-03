package package1;

public class p1_hello_world {
    public static void main(String [] args)
    {
        System.out.println("hello world");
        p1_hello_world test_p=new p1_hello_world();
        int c=test_p.multiplication(3,4);
        System.out.println(c);
    }
    protected int summation(int a,int b)
    {
        return a+b;
    }
    public int reduction(int a , int b)
    {
        return a-b;
    }
    private int multiplication(int a , int b)
    {
        return a*b;
    }
}