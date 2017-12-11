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
    String trades;
    //start time is optional, exclusive by default
    String start;
    //end time is optional, inclusive by default
    String end;
    //String ofs is a required field
    String ofs;

    public GetTradeHistoryRequestBody(String ofs) {
        this.ofs = ofs;
    }

    public GetTradeHistoryRequestBody(String type, String trades, String start, String end, String ofs) {
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

    public String getTrades() {
        return trades;
    }

    public void setTrades(String trades) {
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

//    @Override
//    public String toString() {
//        return "GetTradeHistoryRequestBody{" +
//                "type='" + type + '\'' +
//                ", trades='" + trades + '\'' +
//                ", start='" + start + '\'' +
//                ", end='" + end + '\'' +
//                ", ofs='" + ofs + '\'' +
//                '}';
//    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        sb.append("&").append("ofs").append("=").append(getOfs());
        //TODO include if statements for appending data when included
//        sb.append("&").append("type").append("=").append(getType());
//        sb.append("&").append("trades").append("=").append(getTrades());
//        sb.append("&").append("start").append("=").append(getStart());
//        sb.append("&").append("end").append("=").append(getEnd());
        return sb.toString();
    }

    @Override
    public MultiValueMap<String, String> postParam() {
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        postParameters.add("ofs", getOfs());
        //TODO include if statements for appending data when included
//        postParameters.add("type", getType());
//        postParameters.add("trades", getTrades());
//        postParameters.add("start", getStart());
//        postParameters.add("end", getEnd());
        return postParameters;
    }

}
