package co.codingnomads.kraken.model;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class OutputWrapper<T extends OutputGeneric> {

    String[] errors;

    T result;

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
