//package co.codingnomads.kraken.model.trade.response;
//
//import co.codingnomads.kraken.model.OutputWrapper;
//import co.codingnomads.kraken.model.account.pojos.Description;
//
//public class AddStandardOrdersOutput extends OutputWrapper {
//
//    // Order description info
//    Description descr;
//    // Array of transaction ids for order (if order was added successfully)
//    // -- Is this actually an array?
//    String txid;
//
//    public AddStandardOrdersOutput(Description descr, String txid) {
//        this.descr = descr;
//        this.txid = txid;
//    }
//
//    public Description getDescr() {
//        return descr;
//    }
//
//    public void setDescr(Description descr) {
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
