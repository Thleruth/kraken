package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * created by PopoPenguin on 12/11/17
 *
 * This is the request body for api call GetTradeHistory <url>https://api.kraken.com/0/private/TradesHistory</url>

 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#get-trades-history</url>
 */

public class GetTradeHistoryRequestBody extends RequestBodyGeneric{

    private String type;
    private boolean trades;
    private Long start;
    private Long end;
    private int ofs;

    /**
     * Constructor with required offset
     * @param ofs   result offset
     */
    public GetTradeHistoryRequestBody(int ofs) {
        this.ofs = ofs;
    }

    /**
     * Fully Qualified Constructor
     *
     * @param type      type is optional, by default all; includes the following options
     *                  all = all types (default)
     *                  any position = any position (open or closed)
     *                  closed position = positions that have been closed
     *                  closing position = any trade closing all or part of a position
     *                  no position = non-positional trades
     * @param trades    whether or not to include trades related to position in output (optional.  default = false)
     * @param start     starting unix timestamp or trade tx id of results (optional.  exclusive)
     * @param end       ending unix timestamp or trade tx id of results (optional.  inclusive)
     * @param ofs       result offset
     */
    public GetTradeHistoryRequestBody(String type, boolean trades, Long start, Long end, int ofs) {
        this.type = type;
        this.trades = trades;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
    }

    // Getters and Setters for variables
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getTrades() {
        return trades;
    }

    public void setTrades(boolean trades) {
        this.trades = trades;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public int getOfs() {
        return ofs;
    }

    public void setOfs(int ofs) {
        this.ofs = ofs;
    }

    /**
     * Method to set parameters for POST calls.
     *
     * @return MultiValueMap<String, String> String key - String value map
     */
    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != getType()) {
            sb.append("&").append("type").append("=").append(getType());
        }
        if (false != getTrades()){
            sb.append("&").append("trades").append("=").append(getTrades());
        }
        if (null != getStart()){
            sb.append("&").append("start").append("=").append(getStart());
        }
        if (null != getEnd()) {
            sb.append("&").append("end").append("=").append(getEnd());
        }
        sb.append("&").append("ofs").append("=").append(getOfs());
        return sb.toString();
    }

    /**
     * Method to build String required for POST call signature
     *
     * @return String
     */
    @Override
    public MultiValueMap<String, String> postParam() {
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        if (null != getType()){
            postParameters.add("type", getType());
        }
        if (false != getTrades()) {
            postParameters.add("trades", String.valueOf(getTrades()));
        }
        if (null != getStart()) {
            postParameters.add("start", String.valueOf(getStart()));
        }
        if (null != getEnd()) {
            postParameters.add("end", String.valueOf(getEnd()));
        }
        postParameters.add("ofs", String.valueOf(getOfs()));
        return postParameters;
    }

}
