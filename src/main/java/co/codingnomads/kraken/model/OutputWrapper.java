package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;


/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T> {

    private final T result;
    private final String[] error;

    /**
     * Constructor
     *
     * @param result
     * @param error
     */
    @JsonCreator
    public OutputWrapper(@JsonProperty("return") T result, @JsonProperty("error") String[] error) {
        this.result = result;
        this.error = error;
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

//    String[] errors;
//
//    T result;
//
//    public OutputWrapper(String[] errors, T result) {
//        this.errors = errors;
//        this.result = result;
//    }
//
//    public String[] getErrors() {
//        return errors;
//    }
//
//    public void setErrors(String[] errors) {
//        this.errors = errors;
//    }
//
//    public T getResult() {
//        return result;
//    }
//
//    public void setResult(T result) {
//        this.result = result;
//    }
//
//    public String toString() {
//        return "OutputWrapper{" +
//                "errors=" + Arrays.toString(errors) +
//                ", result=" + result +
//                '}';
//    }
//
//    public OutputWrapper(T result) {
//        this.result = result;
//    }
//
//    public OutputWrapper() {
//    }
}
