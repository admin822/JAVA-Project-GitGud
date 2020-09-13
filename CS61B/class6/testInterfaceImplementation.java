package class6;
public class testInterfaceImplementation implements testInterface {
    private double a;
    public Object get(){
        return this.a;
    }
    public void put(Object b){
        this.a=(double)b;
    }
}
