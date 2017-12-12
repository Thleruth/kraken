package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class QueryOrderInfoRequestBody extends RequestBodyGeneric{

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

    public QueryOrderInfoRequestBody(String txid) {
        this.txid = txid;
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

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if(!getTrades()) {
            postParameters.add("trades", getTrades().toString());
        }
        if(null != getUserref()) {
            postParameters.add("userref", getUserref());
        }
        postParameters.add("txid", getTxid());

        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if(!getTrades()) {
            sb.append("&").append("trades").append("=").append(getTrades().toString());
        }
        if(null!=getUserref()) {
            sb.append("&").append("userref").append("=").append(getUserref());
        }
        sb.append("&").append("txid").append("=").append(getTxid());

        return sb.toString();
    }
}
