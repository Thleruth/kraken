package co.codingnomads.kraken.model.account.output;

import co.codingnomads.kraken.model.OutputGeneric;

public class CancelOpenOrdersOutput extends OutputGeneric {
    /**
     * Created by Meghan Boyce on 11/30/17
     *
     */

    // Number of orders canceled
    int count;
    // If set, order(s) is/are pending cancellation
    String pending;

    // Fully qualified constructor
    public CancelOpenOrdersOutput(int count, String pending) {
        this.count = count;
        this.pending = pending;
    }

    // Empty Constructor
    public CancelOpenOrdersOutput() {
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

    @Override
    public String toString() {
        return "CancelOpenOrdersOutput{" +
                "count=" + count +
                ", pending='" + pending + '\'' +
                '}';
    }
}
