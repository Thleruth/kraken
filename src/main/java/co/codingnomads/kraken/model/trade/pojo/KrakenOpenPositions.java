package co.codingnomads.kraken.model.trade.pojo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/*
created by PopoPenguin on 11/29/17
*/

/**
 * KrakenOpenPositions POJO for api call <url>https://api.kraken.com/0/private/OpenPositions</url>
 *
 * Kraken API Documentation for this call<url>https://www.kraken.com/help/api#get-open-positions</url>
 *
 *
 */

public class KrakenOpenPositions {

    String ordertxid;
    String assetPair;
    Long time;
    String type;
    String ordertype;
    BigDecimal cost;
    BigDecimal fee;
    BigDecimal vol;
    BigDecimal vol_closed;
    BigDecimal margin;
    BigDecimal value;
    BigDecimal net;
    List misc;
    List oflags;
    BigDecimal viqc;

    public KrakenOpenPositions(@JsonProperty("ordertxid")String ordertxid, @JsonProperty("assetPair")String assetPair,
                               @JsonProperty("time")Long time, @JsonProperty("type")String type,
                               @JsonProperty("ordertype")String ordertype, @JsonProperty("cost")BigDecimal cost,
                               @JsonProperty("fee")BigDecimal fee, @JsonProperty("vol")BigDecimal vol,
                               @JsonProperty("vol_closed")BigDecimal vol_closed, @JsonProperty("margin")BigDecimal margin,
                               @JsonProperty("value")BigDecimal value, @JsonProperty("net")BigDecimal net,
                               @JsonProperty("misc")List misc, @JsonProperty("oflags")List oflags,
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

    public List getMisc() {
        return misc;
    }

    public List getOflags() {
        return oflags;
    }

    public BigDecimal getViqc() {
        return viqc;
    }

    @Override
    public String toString() {
        return "KrakenOpenPositions{" +
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
