package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class BackLogFullException extends Exception {


    String errorMessage;

    public BackLogFullException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "BackLogFullException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}