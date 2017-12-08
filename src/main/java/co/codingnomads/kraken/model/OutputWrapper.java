package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T> {

    String[] error;
    T result;

    /**
     * Constructor
     *
     * @param result
     * @param error
     */
    @JsonCreator
    public OutputWrapper(@JsonProperty("return") T result, @JsonProperty("error") String[] error) {
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

    public OutputWrapper() {
    }


    public boolean isSuccess() {
        return error.length == 0;
    }

    @Override
    public String toString() {
        return String.format("KrakenResult[%s: %s]", isSuccess() ? "OK" : "error", isSuccess() ? result.toString() : printError());
    }
}
