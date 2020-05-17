package za.co.in2it.exception;

/**
 * Created by rchennupati on 1/26/18.
 */
public class FindPathOperationsException extends Exception {

    public FindPathOperationsException() {

    }

    public FindPathOperationsException(String message) {
        super (message);
    }

    public FindPathOperationsException(Throwable cause) {
        super (cause);
    }

    public FindPathOperationsException(String message, Throwable cause) {
        super (message, cause);
    }
}
