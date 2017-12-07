package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class UnkownException extends Exception {

    String errorMsg;

    public UnkownException(String message) {
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