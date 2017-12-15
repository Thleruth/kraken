package co.codingnomads.kraken.model.trade.request;

/*
created by PopoPenguin on 12/11/17
*/


import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;


public class GetOpenPositionsRequestBody extends RequestBodyGeneric {

    // Transaction id
    String txid;
    // To include docalcs or not, false by default
    boolean docalcs;


    public GetOpenPositionsRequestBody(String txid) {
        this.txid = txid;
        this.docalcs = false;
    }

    public GetOpenPositionsRequestBody(String txid, boolean docalcs) {
        this.txid = txid;
        this.docalcs = docalcs;
    }

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
