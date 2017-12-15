package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * created by PopoPenguin on 12/11/17
 *
 * This is the request body for api call QueryTradesInfo <url>https://api.kraken.com/0/private/QueryTrades</url>
 *
 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#query-trades-info</url>
 */

public class QueryTradesInfoRequestBody extends RequestBodyGeneric {

    private String txid;
    private boolean trades;

    public QueryTradesInfoRequestBody() {
    }

    /**
     * Constructor
     *
     * @param txid      comma delimited list of transaction ids to query info about (20 maximum)
     */
    public QueryTradesInfoRequestBody (String txid) {
        this.txid = txid;
        this.trades = false;
    }

    /**
     * Fully Qualified Constructor
     * @param txid      comma delimited list of transaction ids to query info about (20 maximum)
     * @param trades    whether or not to include trades related to position in output (optional.  default = false)
     */
    public QueryTradesInfoRequestBody(String txid, boolean trades) {
        this.txid = txid;
        this.trades = trades;
    }

    // Getters and Setters for variables
    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public boolean isTrades() {
        return trades;
    }

    public void setTrades(boolean trades) {
        this.trades = trades;
    }

    /**
     * Method to set parameters for POST calls.
     *
     * @return MultiValueMap<String, String> String key - String value map
     */
    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        postParameters.add("txid", getTxid());
        if (false != isTrades()) {
            postParameters.add("trades", String.valueOf(isTrades()));
        }
        return postParameters;
    }

    /**
     * Method to build String required for POST call signature
     *
     * @return String
     */
    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        sb.append("&").append("txid").append("=").append(getTxid());
        if (false != isTrades()){
            sb.append("&").append("trades").append("=").append(isTrades());
        }
        return sb.toString();
    }
}
