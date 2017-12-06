package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;

public class GetClosedOrdersRequestBody extends RequestBodyGeneric {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     * All instance vars defined as Strings until we know better
     */

    // Whether or not to include trades in output (optional - default = false)
    String trades;
    // Restrict results to given user reference id (optional)
    String userref;
    // Starting unix timestamp or GetOpenOrdersOutput tx id of results (optional, exclusive)
    String start;
    // Ending unix timestamp or GetOpenOrdersOutput tx id of results (optional, inclusive)
    String end;
    // Result offset
    String ofs;
    // Which GetOpenOrdersOutput to use (optional - open, close, both (default))
    String closetime;

    // Fully qualified Constructor
    public GetClosedOrdersRequestBody(String trades, String userref, String start, String end, String ofs, String closetime) {
        this.trades = trades;
        this.userref = userref;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
        this.closetime = closetime;
    }

    // Empty Constructor


    public GetClosedOrdersRequestBody() {
    }

    public String getTrades() {
        return trades;
    }

    public void setTrades(String trades) {
        this.trades = trades;
    }

    public String getUserref() {
        return userref;
    }

    public void setUserref(String userref) {
        this.userref = userref;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getOfs() {
        return ofs;
    }

    public void setOfs(String ofs) {
        this.ofs = ofs;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    @Override
    public String toString() {
        return "GetClosedOrdersRequestBody{" +
                "trades='" + trades + '\'' +
                ", userref='" + userref + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", ofs='" + ofs + '\'' +
                ", closetime='" + closetime + '\'' +
                '}';
    }
}
