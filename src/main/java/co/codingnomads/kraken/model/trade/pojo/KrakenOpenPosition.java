package co.codingnomads.kraken.model.trade.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by Jialor Cheung on 11/29/17
 *
 * This is the information body, KrakenOpenPosition POJO, for the result list of objects in
 * api call GetOpenPositions <url>https://api.kraken.com/0/private/OpenPositions</url>
 *
 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#get-open-positions</url>
 */

public class KrakenOpenPosition {

    private final String ordertxid;
    private final String assetPair;
    private final String type;
    private final String ordertype;
    private final List<String> misc;
    private final List<String> oflags;

    private final Long time;

    //using BigDecimal format for most accurate data type associated to monetary values
    private final BigDecimal cost;
    private final BigDecimal fee;
    private final BigDecimal vol;
    private final BigDecimal vol_closed;
    private final BigDecimal margin;
    private final BigDecimal value;
    private final BigDecimal net;
    private final BigDecimal viqc;

    /**
     * Fully Qualified Constructor
     *
     * @param ordertxid     order responsible for execution of trade
     * @param assetPair     asset pair
     * @param time          unix timestamp of trade
     * @param type          type of order used to open position (buy/sell)
     * @param ordertype     order type used to open position
     * @param cost          opening cost of position (quote currency unless viqc set in oflags)
     * @param fee           opening fee of position (quote currency)
     * @param vol           position volume (base currency unless viqc set in oflags)
     * @param vol_closed    position volume closed (base currency unless viqc set in oflags)
     * @param margin        initial margin (quote currency)
     * @param value         current value of remaining position (if docalcs requested.  quote currency)
     * @param net           unrealized profit/loss of remaining position (if docalcs requested.  quote currency, quote currency scale)
     * @param misc          comma delimited list of miscellaneous info
     * @param oflags        comma delimited list of order flags
     * @param viqc          volume in quote currency
     *                      Note: Unless otherwise stated, costs, fees, prices, and volumes are in the asset pair's scale,
     *                      not the currency's scale.
     */

    public KrakenOpenPosition(@JsonProperty("ordertxid")String ordertxid, @JsonProperty("pair")String assetPair,
                              @JsonProperty("time")Long time, @JsonProperty("type")String type,
                              @JsonProperty("ordertype")String ordertype, @JsonProperty("cost")BigDecimal cost,
                              @JsonProperty("fee")BigDecimal fee, @JsonProperty("vol")BigDecimal vol,
                              @JsonProperty("vol_closed")BigDecimal vol_closed, @JsonProperty("margin")BigDecimal margin,
                              @JsonProperty("value")BigDecimal value, @JsonProperty("net")BigDecimal net,
                              @JsonProperty("misc")List<String> misc, @JsonProperty("oflags")List<String> oflags,
                              @JsonProperty("viqc")BigDecimal viqc) {

        this.ordertxid = ordertxid;
        this.assetPair = assetPair;
        this.time = time;
        this.type = type;
        this.ordertype = ordertype;
        this.cost = cost;
        this.fee = fee;
        this.vol = vol;
        this.vol_closed = vol_closed;
        this.margin = margin;
        this.value = value;
        this.net = net;
        this.misc = misc;
        this.oflags = oflags;
        this.viqc = viqc;
    }

    // Getters for variables
    public String getOrdertxid() {
        return ordertxid;
    }

    public String getAssetPair() {
        return assetPair;
    }

    public Long getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public BigDecimal getVol_closed() {
        return vol_closed;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getNet() {
        return net;
    }

    public List<String> getMisc() {
        return misc;
    }

    public List<String> getOflags() {
        return oflags;
    }

    public BigDecimal getViqc() {
        return viqc;
    }

    @Override
    public String toString() {
        return "KrakenOpenPosition{" +
                "ordertxid='" + ordertxid + '\'' +
                ", assetPair='" + assetPair + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", ordertype='" + ordertype + '\'' +
                ", cost=" + cost +
                ", fee=" + fee +
                ", vol=" + vol +
                ", vol_closed=" + vol_closed +
                ", margin=" + margin +
                ", value=" + value +
                ", net=" + net +
                ", misc=" + misc +
                ", oflags=" + oflags +
                ", viqc=" + viqc +
                '}';
    }
}
