//package co.codingnomads.kraken.model.trade.response;
//
//import co.codingnomads.kraken.model.OutputWrapper;
//import co.codingnomads.kraken.model.account.pojos.KrakenOrderDescription;
//
//public class AddStandardOrdersOutput extends OutputWrapper {
//
//    // Order description info
//    KrakenOrderDescription descr;
//    // Array of transaction ids for order (if order was added successfully)
//    // -- Is this actually an array?
//    String txid;
//
//    public AddStandardOrdersOutput(KrakenOrderDescription descr, String txid) {
//        this.descr = descr;
//        this.txid = txid;
//    }
//
//    public KrakenOrderDescription getDescr() {
//        return descr;
//    }
//
//    public void setDescr(KrakenOrderDescription descr) {
//        this.descr = descr;
//    }
//
//    public String getTxid() {
//        return txid;
//    }
//
//    public void setTxid(String txid) {
//        this.txid = txid;
//    }
//}
