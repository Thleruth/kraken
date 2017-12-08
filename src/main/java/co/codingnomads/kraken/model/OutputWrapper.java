package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T> {

    private final String[] error;
    private final T result;

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

//    public OutputWrapper(){}

    public boolean isSuccess() {

        return error.length == 0;
    }

    public T getResult() {

        return result;
    }

    public String[] getError() {

        return error;
    }

    @Override
    public String toString() {

        return String.format("KrakenResult[%s: %s]", isSuccess() ? "OK" : "error", isSuccess() ? result.toString() : error);
    }
}
