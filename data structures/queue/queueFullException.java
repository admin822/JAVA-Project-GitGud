package queue;

public class queueFullException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public queueFullException() {
        super();
    }
    public queueFullException(String message){
        super(message);
    }
}
