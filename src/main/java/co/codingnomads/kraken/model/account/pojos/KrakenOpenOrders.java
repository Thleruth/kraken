package co.codingnomads.kraken.model.account.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class KrakenOpenOrders {
    /**
     * Created by Meghan Boyce on 12/07/17
     *
     */

    // Referral order transaction id for order
    String refid;
    // User reference id
    String userref;
    // Status of order (pending, open, closed, canceled, expired)
    // Xchange made status an enum.
    String status;
    // Unix timestamp of when order was placed
    double opentm;
    // Unix timestamp of order start time (or 0 if not set)
    double starttm;
    // Unix timestamp of order end time (or 0 if not set)
    double expiretm;
    // Order description info
    KrakenOrderDescription descr;
    // Volume of order (base currency unless viqc set in oflags)
    BigDecimal vol;
    // Volume executed (base currency unless viqc set in oflags)
    BigDecimal vol_exec;
    // Total cost (quote currency unless unless viqc set in oflags)
    BigDecimal cost;
    // Total fee (quote currency)
    BigDecimal fee;
    // Average price (quote currency unless viqc set in oflags)
    BigDecimal price;
    // Stop price (quote currency, for trailing stops)
    BigDecimal stopprice;
    // Triggered limit price (quote currency, when limit based order type triggered)
    BigDecimal limitprice;
    // Comma delimited list of miscellaneous info:
    // stopped (triggered by stop price), touched (triggered by touch price),
    // liquidated, partial(partial fill)
    String misc;
    // Order flags, comma delimited list:
    // viqc = volume in quote currency,
    // fcib = prefer fee in base currency (default if selling)
    // fciq = prefer fee in quote currency (default if buying)
    // nompp = no market price protection
    //Xchange does Set<KrakenOrderFlags> oflags - KrakenOrderFlags is enum
    String oflags;
    // Array of trade ids related to order (if trades info requested and data available)
    //Xchange does List<String> trades
    String[]trades;

    public KrakenOpenOrders(@JsonProperty("refid")String refid, @JsonProperty("userref")String userref,
                            @JsonProperty("status")String status, @JsonProperty("opentm")double opentm,
                            @JsonProperty("starttm")double starttm, @JsonProperty("expiretm")double expiretm,
                            @JsonProperty("descr")KrakenOrderDescription descr,
                            @JsonProperty("vol")BigDecimal vol, @JsonProperty("vol_exec")BigDecimal vol_exec,
                            @JsonProperty("cost")BigDecimal cost, @JsonProperty("fee")BigDecimal fee,
                            @JsonProperty("price")BigDecimal price, @JsonProperty("stopprice")BigDecimal stopprice,
                            @JsonProperty("limitprice")BigDecimal limitprice, @JsonProperty("misc")String misc,
                            @JsonProperty("oflags")String oflags, @JsonProperty("trades")String[] trades) {
        this.refid = refid;
        this.userref = userref;
        this.status = status;
        this.opentm = opentm;
        this.starttm = starttm;
        this.expiretm = expiretm;
        this.descr = descr;
        this.vol = vol;
        this.vol_exec = vol_exec;
        this.cost = cost;
        this.fee = fee;
        this.price = price;
        this.stopprice = stopprice;
        this.limitprice = limitprice;
        this.misc = misc;
        this.oflags = oflags;
        this.trades = trades;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getUserref() {
        return userref;
    }

    public void setUserref(String userref) {
        this.userref = userref;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getOpentm() {
        return opentm;
    }

    public void setOpentm(double opentm) {
        this.opentm = opentm;
    }

    public double getStarttm() {
        return starttm;
    }

    public void setStarttm(double starttm) {
        this.starttm = starttm;
    }

    public double getExpiretm() {
        return expiretm;
    }

    public void setExpiretm(double expiretm) {
        this.expiretm = expiretm;
    }

    public KrakenOrderDescription getDescr() {
        return descr;
    }

    public void setDescr(KrakenOrderDescription descr) {
        this.descr = descr;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public BigDecimal getVol_exec() {
        return vol_exec;
    }

    public void setVol_exec(BigDecimal vol_exec) {
        this.vol_exec = vol_exec;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStopprice() {
        return stopprice;
    }

    public void setStopprice(BigDecimal stopprice) {
        this.stopprice = stopprice;
    }

    public BigDecimal getLimitprice() {
        return limitprice;
    }

    public void setLimitprice(BigDecimal limitprice) {
        this.limitprice = limitprice;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public String getOflags() {
        return oflags;
    }

    public void setOflags(String oflags) {
        this.oflags = oflags;
    }

    public String[] getTrades() {
        return trades;
    }

    public void setTrades(String[] trades) {
        this.trades = trades;
    }
}
