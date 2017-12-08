package co.codingnomads.kraken.model.trade.pojos;

import co.codingnomads.kraken.model.account.pojos.KrakenOrderDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenAddOrder {
    /**
     * Created by Meghan Boyce on 12/07/17
     *
     */

    // Order description info
    KrakenOrderDescription descr;       // Same as descr in GetOpenOrders?
    // Array of transaction ids for order (if order was added successfully)
    String txid;

    public KrakenAddOrder (@JsonProperty("descr") KrakenOrderDescription descr,
                           @JsonProperty("txid") String txid) {
        this.descr = descr;
        this.txid = txid;
    }

    public KrakenOrderDescription getDescr() {
        return descr;
    }

    public void setDescr(KrakenOrderDescription descr) {
        this.descr = descr;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

}
