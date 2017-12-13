package co.codingnomads.kraken.model.trade.request;

/*
created by PopoPenguin on 12/11/17
*/


import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class QueryTradesInfoRequestBody extends RequestBodyGeneric {

    // Transaction id
    String txid;
    // To include trades or not, false by default
    boolean trades;

    public QueryTradesInfoRequestBody (String txid) {
        this.txid = txid;
        this.trades = false;
    }

    public QueryTradesInfoRequestBody(String txid, boolean trades) {
        this.txid = txid;
        this.trades = trades;
    }

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
