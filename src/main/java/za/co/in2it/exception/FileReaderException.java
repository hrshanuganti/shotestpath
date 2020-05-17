package za.co.in2it.exception;

/**
 * Created by rchennupati on 1/26/18.
 */
public class FileReaderException extends Exception {

    public FileReaderException() {

    }

    public FileReaderException(String message) {
        super (message);
    }

    public FileReaderException(Throwable cause) {
        super (cause);
    }

    public FileReaderException(String message, Throwable cause) {
        super (message, cause);
    }
}
