package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by Ricardo Roque on Dec/10/2017
 *
 * This is the request body for api call QueryOrderInfo <url>https://api.kraken.com/0/private/QueryOrders</url>

 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#query-orders-info</url>
 */



public class QueryOrderInfoRequestBody extends RequestBodyGeneric{

    /**
     * Constructor that maps the content of QueryOrdersInfo api call
     *
     * @param trades "optional"
     * @param userref "optional"
     * @param txid "required"
     */

    // Whether or not to include trades in output (optional, default = false)
    private Boolean trades;
    // Restrict results to given user reference id (optional)
    private String userref;

    private String txid;

    // Fully qualified constructor
    public QueryOrderInfoRequestBody(Boolean trades, String userref, String txid) {
        this.trades = trades;
        this.userref = userref;
        this.txid = txid;
    }

    //Overloaded method for calling only txid since the other two are optional
    public QueryOrderInfoRequestBody(String txid) {
        this.txid = txid;
    }


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


    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }



    @Override
    public String toString() {
        return "QueryOrderInfoRequestBody{" +
                "trades=" + trades +
                ", userref='" + userref + '\'' +
                ", txid='" + txid + '\'' +
                '}';
    }


    /**
     * Method to build String required for POST call signature
     * Will yield results based on the input for "trades"
     */

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if(null != getTrades() && getTrades()) {
            postParameters.add("trades", getTrades().toString());
        }
        if(null != getUserref()) {
            postParameters.add("userref", getUserref());
        }
        postParameters.add("txid", getTxid());

        return postParameters;
    }

    /**
     * Method to set parameters for POST calls.
     * Will yield results based on the input for "userref"
     */

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if(null != getTrades() && getTrades()) {
            sb.append("&").append("trades").append("=").append(getTrades().toString());
        }
        if(null!=getUserref()) {
            sb.append("&").append("userref").append("=").append(getUserref());
        }
        sb.append("&").append("txid").append("=").append(getTxid());

        return sb.toString();
    }
}
