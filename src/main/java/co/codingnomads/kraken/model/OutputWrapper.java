package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


/**
 * Created by Thomas Leruth on 11/29/17
 */

/**
 * Response OutputWrapper class including a field for potential error and one the result of the call (if no error)
 * @param <T> The result will depending on the call
 */
public class OutputWrapper<T> {

    String[] error;
    T result;

    /**
     * JSON constructor
     * @param result the call response
     * @param error a potential API error returned
     */
    @JsonCreator
    public OutputWrapper(@JsonProperty("result") T result, @JsonProperty("error") String[] error) {
        this.error = error;
        this.result = result;
    }

    public String[] getError() {
        return error;
    }

    public void setError(String[] error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String printError() {
        return Arrays.toString(error);
    }

    public OutputWrapper() {}

    public boolean isSuccess() {
        return error.length == 0;
    }

    /**
     * Modified toString method to print in a nice format the result with error or a valid one
     * @return
     */
    @Override
    public String toString() {
        return String.format("KrakenResult[%s: %s]", isSuccess() ? "OK" : "error", isSuccess() ? result.toString() : printError());
    }
}
