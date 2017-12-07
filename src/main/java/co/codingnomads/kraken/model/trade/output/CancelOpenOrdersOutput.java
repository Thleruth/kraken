package co.codingnomads.kraken.model.trade.output;

import co.codingnomads.kraken.model.OutputWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Meghan Boyce on 11/30/17
 *
 */

public class CancelOpenOrdersOutput extends OutputWrapper {

    // Number of orders canceled
    int count;
    // If set, order(s) is/are pending cancellation
    String pending;

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

    public CancelOpenOrdersOutput(@JsonProperty("count") int count,
                                  @JsonProperty("pending") String pending) {
        this.count = count;
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