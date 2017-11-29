package co.codingnomads.kraken.model;

import java.util.Arrays;

public class GetClosedOrdersOutput {
    /**
     * Created by Meghan Boyce on 11/29/17
     */

    String[] error;
    // Array of order info.  See Get open orders.  Additional fields:
    String[] closed;
    // Unix timestamp of when order was closed
    String closetm;
    // Additional info on status (if any)
    String reason;
    // Amount of available order info matching criteria
    String count;

    public String[] getError() {
        return error;
    }

    public void setError(String[] error) {
        this.error = error;
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

    @Override
    public String toString() {
        return "GetClosedOrdersOutput{" +
                "error=" + Arrays.toString(error) +
                ", closed=" + Arrays.toString(closed) +
                ", closetm='" + closetm + '\'' +
                ", reason='" + reason + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
