package co.codingnomads.kraken.model.trade.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class KrakenAddOrder {


    KrakenStandardOrderDescription descr;
    List<String> txid;// Array of transaction ids for order (if order was added successfully)

    public KrakenAddOrder (@JsonProperty("descr") KrakenStandardOrderDescription descr,
                           @JsonProperty("txid") List<String> txid) {
        this.descr = descr;
        this.txid = txid;
    }

    public KrakenStandardOrderDescription getDescr() {
        return descr;
    }

    public void setDescr(KrakenStandardOrderDescription descr) {
        this.descr = descr;
    }

    public List<String> getTxid() {
        return txid;
    }

    public void setTxid(List<String> txid) {
        this.txid = txid;
    }

    @Override
    public String toString() {
        return "KrakenAddOrder{" +
                "descr=" + descr +
                ", txid=" + txid +
                '}';
    }
}
