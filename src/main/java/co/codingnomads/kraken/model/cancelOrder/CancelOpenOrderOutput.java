package co.codingnomads.kraken.model;

public class CancelOpenOrderOutput {

    // Number of orders canceled
    int count;
    // If set, order(s) is/are pending cancellation
    String pending;

    // Fully qualified constructor
    public CancelOpenOrderOutput(int count, String pending) {
        this.count = count;
        this.pending = pending;
    }

    // Constructor minus pending
    public CancelOpenOrderOutput(int count) {
        this.count = count;
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
