package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class RateLimitException extends Exception {

    String errorMessage;

    public RateLimitException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "RateLimitException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}