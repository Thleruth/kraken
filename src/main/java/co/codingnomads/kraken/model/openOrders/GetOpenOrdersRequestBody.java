package co.codingnomads.kraken.model;

public class GetOpenOrdersRequestBody extends RequestBodyGeneric{

    // Whether or not to include trades in output (optional, default = false)
    Boolean trades;
    // Restrict results to given user reference id (optional)
    String userref;

    // Fully qualified constructor
    public GetOpenOrdersRequestBody(Boolean trades, String userref) {
        this.trades = trades;
        this.userref = userref;
    }

    // Constructor minus optional-no-default userref
    public GetOpenOrdersRequestBody(Boolean trades) {
        this.trades = trades;
    }

    // getters and setters
    public Boolean getTrades() {
        return trades;
    }

    public void setTrades(Boolean trades) {
        this.trades = trades;
    }

    public String getUserref() {
        return userref;
    }

    public void setUserref(String userref) {
        this.userref = userref;
    }

    // Should nonce be included in toString?
    @Override
    public String toString() {
        return "GetOpenOrdersRequestBody{" +
                "trades=" + trades +
                ", userref='" + userref + '\'' +
                '}';
    }

}
