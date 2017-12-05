package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.RequestBodyGeneric;

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


}
