package sparse_matrix;

public class tooManyInformativeException extends Exception {
    /**
     * defines exception that will be thrown when too many informative points are declared .
     */
    private static final long serialVersionUID = 1L;

    public tooManyInformativeException() {
        super();
    }
    public tooManyInformativeException(String message){
        super(message);
    }
}
