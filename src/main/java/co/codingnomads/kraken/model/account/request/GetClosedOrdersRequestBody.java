package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetClosedOrdersRequestBody extends RequestBodyGeneric {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
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
    // Which time to use (optional - open, close, both (default))
    String closetime;

    // Fully qualified Constructor
    public GetClosedOrdersRequestBody(String trades, String userref, String start, String end,
                                      String ofs, String closetime) {
        this.trades = trades;
        this.userref = userref;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
        this.closetime = closetime;
    }

    // do we need a variety of constructors that cover all the options of variables that could be entered?
    public GetClosedOrdersRequestBody(String ofs) {
        this.ofs = ofs;
    }

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

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        if (null != trades){
            postParameters.add("trades", getTrades());
        }
        if (null != userref){
            postParameters.add("userref", getUserref());
        }
        if (null != start){
            postParameters.add("start", getStart());
        }
        if (null != end){
            postParameters.add("end", getEnd());
        }
        if (null != ofs){
            postParameters.add("ofs", getOfs());
        }
        if (null != closetime){
            postParameters.add("closetime", getClosetime());
        }
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != trades){
            sb.append("&").append("trades").append("=").append(getTrades());
        }
        if (null != userref) {
            sb.append("&").append("userref").append("=").append(getUserref());
        }
        if (null != start) {
            sb.append("&").append("start").append("=").append(getStart());
        }
        if (null != end){
            sb.append("&").append("end").append("=").append(getEnd());
        }
        if (null != ofs) {
            sb.append("&").append("ofs").append("=").append(getOfs());
        }
        if (null != closetime){
            sb.append("&").append("closetime").append("=").append(getClosetime());
        }
        return sb.toString();
    }
}
