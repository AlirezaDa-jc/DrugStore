package ir.maktab.demo.exception;

/**
 * @author Alireza.d.a
 */
public class InvalidRequestException extends Exception{

    private final Long code;

    public InvalidRequestException(String message, Long code) {
        super(message);
        this.code = code;
    }

    public InvalidRequestException(String message, Throwable cause, Long code) {
        super(message, cause);
        this.code = code;
    }

    public InvalidRequestException(Throwable cause, Long code) {
        super(cause);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }
}
