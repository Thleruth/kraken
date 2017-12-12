package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetOpenOrdersRequestBody extends RequestBodyGeneric {

    // Whether or not to include trades in output (optional, default = false)
    String trades;
    // Restrict results to given user reference id (optional)
    String userref;

    // Fully qualified constructor
    public GetOpenOrdersRequestBody(String trades, String userref) {
        this.trades = trades;
        this.userref = userref;
    }

    public GetOpenOrdersRequestBody() {
    }

    // getters and setters
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

    @Override
    public String toString() {
        return "GetOpenOrdersRequestBody{" +
                "trades=" + trades +
                ", userref='" + userref + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if (null != getTrades()) {
            postParameters.add("trades", getTrades());
        }
        if (null != getUserref()) {
            postParameters.add("userref", getUserref());
        }
        return postParameters;
    }

    @Override
    public String signPostParam() {

        // need a way to adjust this string to accomodate different variable options
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != getTrades()) {
            sb.append("&").append("trades").append("=").append(getTrades());
        }

        if (null != getUserref()) {
           sb.append("&").append("userref").append("=").append(getUserref());
        }
        return sb.toString();
    }
}
