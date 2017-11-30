package co.codingnomads.kraken.model.cancelOrder;

import co.codingnomads.kraken.model.OutputGeneric;

public class CancelOpenOrderOutput extends OutputGeneric {

    // Number of orders canceled
    int count;
    // If set, order(s) is/are pending cancellation
    String pending;

    // Fully qualified constructor
    public CancelOpenOrderOutput(int count, String pending) {
        this.count = count;
        this.pending = pending;
    }

    // Empty Constructor
    public CancelOpenOrderOutput() {
    }

    // Getters and setters
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPending() {
        return pending;
    }

    public void setPending(String pending) {
        this.pending = pending;
    }
}
