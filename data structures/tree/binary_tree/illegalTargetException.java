package tree.binary_tree;

public class illegalTargetException extends RuntimeException{
    public illegalTargetException(){
        super();
    }
    public illegalTargetException(String message){
        super(message);
    }
}
