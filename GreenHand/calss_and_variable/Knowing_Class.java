package GreenHand.calss_and_variable;




public class Knowing_Class
{
    private int a;
    public static final int HIS_IS_CONSTANT=1; // usually when we use static(class) variable, we also use final and public to decorate it.
    public Knowing_Class(int a)
    {
        this.a=a;
    }

    public void summation(int a)
    {
        System.out.println(a+this.a+Knowing_Class.HIS_IS_CONSTANT);
    }
    public static void main(String[] args) {
        int a =1;
        double b=a+1.0;
        System.out.println(b);
    }
}

