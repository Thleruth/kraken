//package co.codingnomads.kraken.model.account.response;
//
//import co.codingnomads.kraken.model.OutputWrapper;
//import co.codingnomads.kraken.model.account.pojos.Description;
//
//import java.util.Arrays;
//
//public class GetOpenOrdersOutput extends OutputWrapper{
//    /**
//     * Created by Meghan Boyce on 11/29/17
//     *
//     */
//
//    // Referral order transaction id for order
//    String refid;
//    // User reference id
//    String userref;
//    // Status of order (pending, open, closed, canceled, expired)
//    String status;
//    // Unix timestamp of when order was placed
//    String opentm;
//    // Unix timestamp of order start time (or 0 if not set)
//    String starttm;
//    // Unix timestamp of order end time (or 0 if not set)
//    String expiretm;
//    // Order description info
//    Description descr;
//    // Volume of order (base currency unless viqc set in oflags)
//    String vol;
//    // Volume executed (base currency unless viqc set in oflags)
//    String vol_exec;
//    // Total cost (quote currency unless unless viqc set in oflags)
//    String cost;
//    // Total fee (quote currency)
//    String fee;
//    // Average price (quote currency unless viqc set in oflags)
//    String price;
//    // Stop price (quote currency, for trailing stops)
//    String stopprice;
//    // Triggered limit price (quote currency, when limit based order type triggered)
//    String limitprice;
//    // Comma delimited list of miscellaneous info:
//    // stopped (triggered by stop price), touched (triggered by touch price),
//    // liquidated, partial(partial fill)
//    String misc;
//    // Order flags, comma delimited list:
//    // viqc = volume in quote currency,
//    // fcib = prefer fee in base currency (default if selling)
//    // fciq = prefer fee in quote currency (default if buying)
//    // nompp = no market price protection
//    String oflags;
//    // Array of trade ids related to order (if trades info requested and data available)
//    String[]trades;
//
//    public String getRefid() {
//        return refid;
//    }
//
//    public void setRefid(String refid) {
//        this.refid = refid;
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
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getOpentm() {
//        return opentm;
//    }
//
//    public void setOpentm(String opentm) {
//        this.opentm = opentm;
//    }
//
//    public String getStarttm() {
//        return starttm;
//    }
//
//    public void setStarttm(String starttm) {
//        this.starttm = starttm;
//    }
//
//    public String getExpiretm() {
//        return expiretm;
//    }
//
//    public void setExpiretm(String expiretm) {
//        this.expiretm = expiretm;
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
//    public String getVol() {
//        return vol;
//    }
//
//    public void setVol(String vol) {
//        this.vol = vol;
//    }
//
//    public String getVol_exec() {
//        return vol_exec;
//    }
//
//    public void setVol_exec(String vol_exec) {
//        this.vol_exec = vol_exec;
//    }
//
//    public String getCost() {
//        return cost;
//    }
//
//    public void setCost(String cost) {
//        this.cost = cost;
//    }
//
//    public String getFee() {
//        return fee;
//    }
//
//    public void setFee(String fee) {
//        this.fee = fee;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getStopprice() {
//        return stopprice;
//    }
//
//    public void setStopprice(String stopprice) {
//        this.stopprice = stopprice;
//    }
//
//    public String getLimitprice() {
//        return limitprice;
//    }
//
//    public void setLimitprice(String limitprice) {
//        this.limitprice = limitprice;
//    }
//
//    public String getMisc() {
//        return misc;
//    }
//
//    public void setMisc(String misc) {
//        this.misc = misc;
//    }
//
//    public String getOflags() {
//        return oflags;
//    }
//
//    public void setOflags(String oflags) {
//        this.oflags = oflags;
//    }
//
//    public String[] getTrades() {
//        return trades;
//    }
//
//    public void setTrades(String[] trades) {
//        this.trades = trades;
//    }
//
//    @Override
//    public String toString() {
//        return "GetOpenOrdersOutput{" +
//                "refid='" + refid + '\'' +
//                ", userref='" + userref + '\'' +
//                ", status='" + status + '\'' +
//                ", opentm='" + opentm + '\'' +
//                ", starttm='" + starttm + '\'' +
//                ", expiretm='" + expiretm + '\'' +
//                ", descr=" + descr +
//                ", vol='" + vol + '\'' +
//                ", vol_exec='" + vol_exec + '\'' +
//                ", cost='" + cost + '\'' +
//                ", fee='" + fee + '\'' +
//                ", price='" + price + '\'' +
//                ", stopprice='" + stopprice + '\'' +
//                ", limitprice='" + limitprice + '\'' +
//                ", misc='" + misc + '\'' +
//                ", oflags='" + oflags + '\'' +
//                ", trades=" + Arrays.toString(trades) +
//                '}';
//    }
//}
