package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class UnkownException extends KrakenException {

    public UnkownException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "UnkownException{" +
                "errorMsg='" + message + '\'' +
                '}';
    }
}