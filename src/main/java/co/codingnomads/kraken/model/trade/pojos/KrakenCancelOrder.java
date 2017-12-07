package co.codingnomads.kraken.model.trade.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenCancelOrder {
    /**
     * Created by Meghan Boyce on 12/07/17
     *
     */

    // Number of orders canceled
    int count;
    // If set, order(s) is/are pending cancellation
    boolean pending;

    public KrakenCancelOrder(@JsonProperty("count")int count, @JsonProperty("pending")boolean pending) {
        this.count = count;
        this.pending = pending;
    }

    public int getCount() {
        return count;
    }

    public boolean isPending() {
        return pending;
    }

    @Override
    public String toString() {
        return "KrakenCancelOrder{" +
                "count=" + count +
                ", pending=" + pending +
                '}';
    }
}
