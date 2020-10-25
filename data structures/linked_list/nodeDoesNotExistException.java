package linked_list;

public class nodeDoesNotExistException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public nodeDoesNotExistException() {
        super();
    }
    public nodeDoesNotExistException(String message){
        super(message);
    }
}
