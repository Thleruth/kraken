//package co.codingnomads.kraken.model.account.request;
//
//import co.codingnomads.kraken.model.RequestBodyGeneric;
//
///**
// * Created by Ricardo Roque
// * 4/Dec/2017
// */
//
//public class QueryOrdersInfoRequestBody extends RequestBodyGeneric {
//
//    //whether or not to include trades in response (optional. default = false)
//    String trades;
//
//    //restrict results to given user reference id (optional)
//    String userref;
//
//    //comma delimited list of transaction ids to query info about (20 maximum)
//    String txid;
//
//    public QueryOrdersInfoRequestBody(String trades, String userref, String txid) {
//        super();
//        this.trades = trades;
//        this.userref = userref;
//        this.txid = txid;
//    }
//
//    public String getTrades() {
//        return trades;
//    }
//
//    public void setTrades(String trades) {
//        this.trades = trades;
//    }
//
//    public String getUserref() {
//        return userref;
//    }
//
//    public void setUserref(String userref) {
//        this.userref = userref;
//    }
//
//    public String getTxid() {
//        return txid;
//    }
//
//    public void setTxid(String txid) {
//        this.txid = txid;
//    }
//
//    @Override
//    public String toString() {
//        return "QueryOrdersInfoRequestBody{" +
//                "trades='" + trades + '\'' +
//                ", userref='" + userref + '\'' +
//                ", txid='" + txid + '\'' +
//                ", nonce='" + nonce + '\'' +
//                '}';
//    }
//}
