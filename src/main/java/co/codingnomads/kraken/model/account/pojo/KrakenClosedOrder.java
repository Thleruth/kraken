package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Meghan Boyce on 12/07/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KrakenClosedOrder {

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
    // stopped (triggered by stop price), touched (triggered by touch price), liquidated, partial(partial fill)
    String misc;
    // Order flags, comma delimited list:
    // viqc = volume in quote currency, fcib = prefer fee in base currency (default if selling),
    // fciq = prefer fee in quote currency (default if buying), nompp = no market price protection
    String oflags;
    // Array of trade ids related to order (if trades info requested and data available)
    String[] trades;

    // Additional fields for getClosedOrders:
    // Unix timestamp of when order was closed
    String closetm;
    // Additional info on status (if any)
    String reason;

    /**
     *
     * @param refid
     * @param userref
     * @param status
     * @param opentm
     * @param starttm
     * @param expiretm
     * @param descr
     * @param vol
     * @param vol_exec
     * @param cost
     * @param fee
     * @param price
     * @param stopprice
     * @param limitprice
     * @param misc
     * @param oflags
     * @param trades
     * @param closetm
     * @param reason
     */
    public KrakenClosedOrder(@JsonProperty("refid") String refid, @JsonProperty("userref") String userref,
                             @JsonProperty("status") String status, @JsonProperty("opentm") double opentm,
                             @JsonProperty("starttm") double starttm, @JsonProperty("expiretm") double expiretm,
                             @JsonProperty("descr") KrakenOrderDescription descr,
                             @JsonProperty("vol") BigDecimal vol, @JsonProperty("vol_exec") BigDecimal vol_exec,
                             @JsonProperty("cost") BigDecimal cost, @JsonProperty("fee") BigDecimal fee,
                             @JsonProperty("price") BigDecimal price, @JsonProperty("stopprice") BigDecimal stopprice,
                             @JsonProperty("limitprice") BigDecimal limitprice, @JsonProperty("misc") String misc,
                             @JsonProperty("oflags") String oflags, @JsonProperty("trades") String[] trades,
                             @JsonProperty("closetm") String closetm, @JsonProperty("reason") String reason) {
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
        this.closetm = closetm;
        this.reason = reason;
    }

    /**
     *
     * @return String
     */
    public String getRefid() {
        return refid;
    }

    /**
     *
     * @param refid
     */
    public void setRefid(String refid) {
        this.refid = refid;
    }

    /**
     *
     * @return String
     */
    public String getUserref() {
        return userref;
    }

    /**
     *
     * @param userref
     */
    public void setUserref(String userref) {
        this.userref = userref;
    }

    /**
     *
     * @return String
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return double
     */
    public double getOpentm() {
        return opentm;
    }

    /**
     *
     * @param opentm
     */
    public void setOpentm(double opentm) {
        this.opentm = opentm;
    }

    /**
     *
     * @return double
     */
    public double getStarttm() {
        return starttm;
    }

    /**
     *
     * @param starttm
     */
    public void setStarttm(double starttm) {
        this.starttm = starttm;
    }

    /**
     *
     * @return double
     */
    public double getExpiretm() {
        return expiretm;
    }

    /**
     *
     * @param expiretm
     */
    public void setExpiretm(double expiretm) {
        this.expiretm = expiretm;
    }

    /**
     *
      * @return KrakenOrderDescription
     */
    public KrakenOrderDescription getDescr() {
        return descr;
    }

    /**
     *
     * @param descr
     */
    public void setDescr(KrakenOrderDescription descr) {
        this.descr = descr;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getVol() {
        return vol;
    }

    /**
     *
     * @param vol
     */
    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getVol_exec() {
        return vol_exec;
    }

    /**
     *
     * @param vol_exec
     */
    public void setVol_exec(BigDecimal vol_exec) {
        this.vol_exec = vol_exec;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     *
     * @param cost
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     *
     * @param fee
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getStopprice() {
        return stopprice;
    }

    /**
     *
     * @param stopprice
     */
    public void setStopprice(BigDecimal stopprice) {
        this.stopprice = stopprice;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getLimitprice() {
        return limitprice;
    }

    /**
     *
     * @param limitprice
     */
    public void setLimitprice(BigDecimal limitprice) {
        this.limitprice = limitprice;
    }

    /**
     *
     * @return String
     */
    public String getMisc() {
        return misc;
    }

    /**
     *
     * @param misc
     */
    public void setMisc(String misc) {
        this.misc = misc;
    }

    /**
     *
     * @return String
     */
    public String getOflags() {
        return oflags;
    }

    /**
     *
     * @param oflags
     */
    public void setOflags(String oflags) {
        this.oflags = oflags;
    }

    /**
     *
     * @return String[]
     */
    public String[] getTrades() {
        return trades;
    }

    /**
     *
     * @param trades
     */
    public void setTrades(String[] trades) {
        this.trades = trades;
    }

    /**
     *
     * @return String
     */
    public String getClosetm() {
        return closetm;
    }

    /**
     *
     * @param closetm
     */
    public void setClosetm(String closetm) {
        this.closetm = closetm;
    }

    /**
     *
     * @return String
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "KrakenClosedOrder{" +
                "refid='" + refid + '\'' +
                ", userref='" + userref + '\'' +
                ", status='" + status + '\'' +
                ", opentm=" + opentm +
                ", starttm=" + starttm +
                ", expiretm=" + expiretm +
                ", descr=" + descr +
                ", vol=" + vol +
                ", vol_exec=" + vol_exec +
                ", cost=" + cost +
                ", fee=" + fee +
                ", price=" + price +
                ", stopprice=" + stopprice +
                ", limitprice=" + limitprice +
                ", misc='" + misc + '\'' +
                ", oflags='" + oflags + '\'' +
                ", trades=" + Arrays.toString(trades) +
                ", closetm='" + closetm + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
