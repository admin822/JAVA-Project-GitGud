package tree;

public class emptyTreeException extends RuntimeException{
    public emptyTreeException(){
        super();
    }
    public emptyTreeException(String message){
        super(message);
    }
}
