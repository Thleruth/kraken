package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class CancelOpenOrderRequestBody extends RequestBodyGeneric {
    /**
     * Created by Meghan Boyce on 11/30/17
     *
     */

    // Transaction id
    int txid;

    public CancelOpenOrderRequestBody(int txid) {
        super();
        this.txid = txid;
    }

    public int getTxid() {
        return txid;
    }

    public void setTxid(int txid) {
        this.txid = txid;
    }

    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        postParameters.add("txid", String.valueOf(getTxid()));
        return postParameters;
    }

    @Override
    public String toString() {
        return "CancelOpenOrderRequestBody{" +
                "txid=" + txid +
                ", nonce='" + nonce + '\'' +
                '}';
    }
}
