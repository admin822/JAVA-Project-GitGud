package queue;

public class invalidIndexException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public invalidIndexException(){
        super();
    }
    public invalidIndexException(String message){
        super(message);
    }
}
