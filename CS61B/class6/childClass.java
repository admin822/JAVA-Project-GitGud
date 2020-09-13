package class6;

/**
 * childClass MUST inherit and implement ALL abstract methods in parentClass
 * childClass CANNOT inherit private variale, OKAY to inherit protected and public
 * 
 */

public class childClass extends parentClass{
    private double radius;
    public double a=41;
    public void scale(double b){
        System.out.println("in child scale");
        this.radius*=b;
    }
    public void f(){
        System.out.println("child");
    }
    public static void g(childClass c){
        c.f();
    }
    public void showA(){
        System.out.println(this.a);
    }
    
    public void showRadius(){
        System.out.print(radius);
    }
    public void draw(){
        System.out.println("in child scale");
        /**
         * the functionality of drawing a circle with radius=radius
         */
    }
}
