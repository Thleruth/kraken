package co.codingnomads.kraken.model.trade.request;

/*
created by PopoPenguin on 12/11/17
*/


import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetTradeHistoryRequestBody extends RequestBodyGeneric{

    //type is optional, by default all
    String type;
    //trades is optional, false by default
    boolean trades;
    //start time is optional, exclusive by default
    String start;
    //end time is optional, inclusive by default
    String end;
    //String ofs is a required field
    String ofs;

    public GetTradeHistoryRequestBody(String ofs) {
        this.ofs = ofs;
    }

    public GetTradeHistoryRequestBody(String type, boolean trades, String start, String end, String ofs) {
        this.type = type;
        this.trades = trades;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
    }

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
            postParameters.add("start", getStart());
        }
        if (null != getEnd()) {
            postParameters.add("end", getEnd());
        }
        postParameters.add("ofs", getOfs());
        return postParameters;
    }

}
