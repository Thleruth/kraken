package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.RequestBodyGeneric;

public class CancelOpenOrderRequestBody extends RequestBodyGeneric {
    /**
     * Created by Meghan Boyce on 11/30/17
     *
     */

    // Transaction id
    String txid;

    public CancelOpenOrderRequestBody(String txid) {
        this.txid = txid;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }


}
