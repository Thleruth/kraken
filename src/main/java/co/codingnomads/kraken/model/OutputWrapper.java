package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T> {

    String[] error;

    T result;

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

    public String toString() {
        return "OutputWrapper{" +
                "error=" + Arrays.toString(error) +
                ", result=" + result +
                '}';
    }

    public String printError() {
        return "error=" + Arrays.toString(error);
    }

//    public OutputWrapper(@JsonProperty("error") String[] error,
//                @JsonProperty("result") T result){
//            this.error = error;
//            this.result = result;
//    }

    public OutputWrapper(T result) {
        this.result = result;
    }

    public OutputWrapper() {
    }
}
