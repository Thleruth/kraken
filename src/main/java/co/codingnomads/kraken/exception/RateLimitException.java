package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class RateLimitException extends KrakenException {

    public RateLimitException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public String toString() {
        return "RateLimitException{" +
                "errorMessage='" + message + '\'' +
                '}';
    }
}