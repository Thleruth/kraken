package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class UnknownException extends Exception {

    String errorMsg;

    public UnknownException(String message) {
        super(message);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "UnkownException{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }
}