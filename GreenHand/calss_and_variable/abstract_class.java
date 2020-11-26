package GreenHand.calss_and_variable;

abstract class abstract_class {
    private boolean flag;
    public int a;
    protected double b;
    public abstract int get_a();
    public abstract void set_flag();
    protected abstract double get_b();
    public boolean get_flag(double b)
    {
        set_b(b);
        return this.flag;
    }
    private void set_b(double b)
    {
        this.b=b;
    }
}