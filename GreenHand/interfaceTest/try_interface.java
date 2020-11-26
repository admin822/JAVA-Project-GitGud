package GreenHand.interfaceTest;
public class try_interface implements testInterface {
    private int a;
    private final int b=10;
    private static int c;
    public void run() throws Exception
    {
        System.out.println(a);
        throw(new Exception());
    }
    public void get_data(int a)
    {
        this.a=a;
    }
    // public void test_change_final() 会报错的，因为我们在改变final
    // {
    //     b=11;
    // }
    public void testChangeStat()
    {
        c=12;
    }
    public static void main(String[] args) {
        try_interface testTryInterface=new try_interface();
        try
        {
            testTryInterface.run();
        }
        catch(Exception e)
        {
            System.out.println("An error occurred");
        }
        testTryInterface.getClass();
    }
}

abstract class abstractTestInterface implements testInterface{
    public abstract void myOwnFunc();
}

class concreteTestInterface extends abstractTestInterface //需要实现所有的接口以及父类中的abstract方法
{
    public void run() throws Exception
    {
        System.out.println("testing");
        throw(new Exception());
    }
    public void get_data(int a )
    {
        System.out.println(a);
    }
    public void myOwnFunc()
    {
        System.out.println("self made, not interface");
    }
}