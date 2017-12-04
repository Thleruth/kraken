package co.codingnomads.kraken.model;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonCreator;


/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T> {

    String[] errors;

    T result;

    public OutputWrapper(String[] errors, T result) {
        this.errors = errors;
        this.result = result;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String toString() {
        return "OutputWrapper{" +
                "errors=" + Arrays.toString(errors) +
                ", result=" + result +
                '}';
    }

    public OutputWrapper(T result) {
        this.result = result;
    }

    public OutputWrapper() {
    }
}
