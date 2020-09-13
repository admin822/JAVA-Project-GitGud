package class6;


/**
 * As a abstract method, you CANNOT have abstract static as decorator.
 */

public abstract class parentClass {
    public double a=10;
    private double c=11;
    protected double d=12;
    public abstract void draw();
    public abstract void scale(double b);
    public void showA(){
        System.out.print(this.a);
    }
    public void f(){
        System.out.println("parent");
    }
    public static void g(parentClass p){
        p.f();
    }
}
