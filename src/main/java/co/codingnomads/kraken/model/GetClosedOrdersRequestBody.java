package co.codingnomads.kraken.model;

public class GetClosedOrdersRequestBody {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     * All instance vars defined as Strings until we know better
     * Edit constructors if this changes to include all possible options
     */

    // Whether or not to include trades in output (optional - default = false)
    String trades;
    // Restrict results to given user reference id (optional)
    String userref;
    // Starting unix timestamp or order tx id of results (optional, exclusive)
    String start;
    // Ending unix timestamp or order tx id of results (optional, inclusive)
    String end;
    // Result offset
    String ofs;
    // Which time to use (optional - open, close, both (default))
    String closetime;

    // Fully qualified constructor
    public GetClosedOrdersRequestBody(String trades, String userref, String start, String end, String ofs, String closetime) {
        this.trades = trades;
        this.userref = userref;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
        this.closetime = closetime;
    }

    // Constructor minus all optional params with no specified default - userref, start, end
    public GetClosedOrdersRequestBody(String trades, String ofs, String closetime) {
        this.trades = trades;
        this.ofs = ofs;
        this.closetime = closetime;
    }

    // Constructor with one optional param with no specified default
    public GetClosedOrdersRequestBody(String trades, String userref, String ofs, String closetime) {
        this.trades = trades;
        this.userref = userref;
        this.ofs = ofs;
        this.closetime = closetime;
    }

    // Constructory with two optional params with no specified default - userref, start
    public GetClosedOrdersRequestBody(String trades, String userref, String start, String ofs, String closetime) {
        this.trades = trades;
        this.userref = userref;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
        this.closetime = closetime;
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
