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
    Long start;
    //end time is optional, inclusive by default
    Long end;
    //String ofs is a required field
    int ofs;

    public GetTradeHistoryRequestBody(int ofs) {
        this.ofs = ofs;
    }

    public GetTradeHistoryRequestBody(String type, boolean trades, Long start, Long end, int ofs) {
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
            postParameters.add("start", String.valueOf(getStart()));
        }
        if (null != getEnd()) {
            postParameters.add("end", String.valueOf(getEnd()));
        }
        postParameters.add("ofs", String.valueOf(getOfs()));
        return postParameters;
    }

}
