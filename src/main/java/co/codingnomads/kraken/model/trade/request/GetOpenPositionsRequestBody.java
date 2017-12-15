package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * created by Jialor Cheung on 12/11/17
 *
 * This is the request body for api call GetOpenPositions <url>https://api.kraken.com/0/private/OpenPositions</url>
 *
 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#get-open-positions</url>
 */

public class GetOpenPositionsRequestBody extends RequestBodyGeneric {

    // comma delimited list of transaction ids to restrict output to
    private String txid;
    // whether or not to include profit/loss calculations (optional.  default = false)
    private boolean docalcs;

    /**
     * Constructor with required txid, default docalcs to false
     *
     * @param txid      comma delimited list of transaction ids to restrict output to
     */
    public GetOpenPositionsRequestBody(String txid) {
        this.txid = txid;
        this.docalcs = false;
    }

    /**
     * Fully Qualified Constructor
     *
     * @param txid      comma delimited list of transaction ids to restrict output to
     * @param docalcs   whether or not to include profit/loss calculations (optional.  default = false)
     */
    public GetOpenPositionsRequestBody(String txid, boolean docalcs) {
        this.txid = txid;
        this.docalcs = docalcs;
    }

    // Getters and Setters for variables
    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public boolean isDocalcs() {
        return docalcs;
    }

    public void setDocalcs(boolean docalcs) {
        this.docalcs = docalcs;
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
        if (false != isDocalcs()) {
            postParameters.add("trades", String.valueOf(isDocalcs()));
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
        if (false != isDocalcs()){
            sb.append("&").append("trades").append("=").append(isDocalcs());
        }
        return sb.toString();
    }

}
