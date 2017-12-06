package co.codingnomads.kraken.model.account.request;

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

    // Once working, comment this toString out and test if still works
    @Override
    public String toString() {
        return super.toString() + "&txid=" + getTxid();
    }


}
