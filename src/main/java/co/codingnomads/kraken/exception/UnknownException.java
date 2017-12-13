package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */

public class UnknownException extends KrakenException {

    String errorMsg;

    public UnknownException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "UnkownException{" +
                "errorMsg='" + message + '\'' +
                '}';
    }
}