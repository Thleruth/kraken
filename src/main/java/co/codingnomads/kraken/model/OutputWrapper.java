package co.codingnomads.kraken.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T extends OutputGeneric> {

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
}
