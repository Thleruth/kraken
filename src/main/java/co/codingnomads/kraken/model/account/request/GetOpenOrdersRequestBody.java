package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetOpenOrdersRequestBody extends RequestBodyGeneric {

    // Whether or not to include trades in output (optional, default = false)
    String trades;
    // Restrict results to given user reference id (optional)
    String userref;

    /**
     * Fully qualified constructor
     * @param trades
     * @param userref
     */
    public GetOpenOrdersRequestBody(String trades, String userref) {
        this.trades = trades;
        this.userref = userref;
    }

    public GetOpenOrdersRequestBody() {
    }

    /**
     *
     * @return String
     */
    public String getTrades() {
        return trades;
    }

    /**
     *
     * @param trades
     */
    public void setTrades(String trades) {
        this.trades = trades;
    }

    /**
     *
     * @return String
     */
    public String getUserref() {
        return userref;
    }

    /**
     *
     * @param userref
     */
    public void setUserref(String userref) {
        this.userref = userref;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "GetOpenOrdersRequestBody{" +
                "trades=" + trades +
                ", userref='" + userref + '\'' +
                ", nonce='" + nonce + '\'' +
                '}';
    }

    /**
     * Sets parameters for POST calls.
     * @return MultiValueMap<String, String> String key - String value map
     */
    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        // Builds postParameters if parameters are provided.
        if (null != getTrades()) {
            postParameters.add("trades", getTrades());
        }
        if (null != getUserref()) {
            postParameters.add("userref", getUserref());
        }
        return postParameters;
    }

    /**
     * Builds String required for POST call signature
     * @return String
     */
    @Override
    public String signPostParam() {
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
