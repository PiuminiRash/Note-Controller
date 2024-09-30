package lk.ijse.notecontrollerspring.Exceptions;

public class DataPersistentException extends RuntimeException{
    public DataPersistentException() {
        super();
    }

    public DataPersistentException(String message) {
        super(message);
    }

    public DataPersistentException(String message, Throwable cause) {
        super(message, cause);
    }
}
