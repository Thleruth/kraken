package co.codingnomads.kraken.exception;

import java.util.Arrays;

public class KrakenException extends Exception {

    String[] errors;
    String message;

    public KrakenException(String[] errors, String message) {
        this.errors = errors;
        this.message= message;
    }

    public KrakenException(String message) {
        this.errors = new String[0];
        this.message= message;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "KrakenException{" +
                "errors=" + Arrays.toString(errors) +
                ", message='" + message + '\'' +
                '}';
    }
}
