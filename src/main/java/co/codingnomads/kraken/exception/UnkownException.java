package co.codingnomads.kraken.exception;

/**
 * @author Kevin Neag
 */
public class UnkownException extends Exception {

    String errorMsg = "Unknown Exception";

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "UnkownException{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }
}