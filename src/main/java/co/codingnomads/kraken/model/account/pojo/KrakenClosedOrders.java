package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenClosedOrders {
    /**
     * Created by Meghan Boyce on 12/07/17
     * this includes all fields from get open orders
     */

    // Array of GetOpenOrdersOutput info.
    String[] closed;
    // Additional fields:
    // Unix timestamp of when GetOpenOrdersOutput was closed
    String closetm;
    // Additional info on status (if any)
    String reason;

    // Amount of available GetOpenOrdersOutput info matching criteria
    String count;

    public KrakenClosedOrders(@JsonProperty("closed")String[] closed,
                              @JsonProperty("closetm")String closetm,
                              @JsonProperty("reason")String reason,
                              @JsonProperty("count")String count) {
        this.closed = closed;
        this.closetm = closetm;
        this.reason = reason;
        this.count = count;
    }

    public String[] getClosed() {
        return closed;
    }

    public void setClosed(String[] closed) {
        this.closed = closed;
    }

    public String getClosetm() {
        return closetm;
    }

    public void setClosetm(String closetm) {
        this.closetm = closetm;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
