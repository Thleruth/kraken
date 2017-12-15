package co.codingnomads.kraken.model.trade.pojo;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties (ignoreUnknown = true)
public class KrakenTradeInfo {

    String ordertxid;
    String assetPair;
    long time;
    String type;
    String ordertype;
    BigDecimal price;
    BigDecimal cost;
    BigDecimal fee;
    BigDecimal vol;
    BigDecimal margin;
    String misc;
    String closing;
    String posstatus;
    BigDecimal cprice;
    BigDecimal ccost;
    BigDecimal cfee;
    BigDecimal cvol;
    BigDecimal cmargin;
    BigDecimal net;
    List<String> trades;

    public KrakenTradeInfo(@JsonProperty("ordertxid")String ordertxid,@JsonProperty("pair") String assetPair,
                           @JsonProperty("time") long time,@JsonProperty("type") String type,
                           @JsonProperty("ordertype") String ordertype,@JsonProperty("price") BigDecimal price,
                           @JsonProperty("cost") BigDecimal cost,@JsonProperty("fee") BigDecimal fee,
                           @JsonProperty("vol") BigDecimal vol,@JsonProperty("margin") BigDecimal margin,
                           @JsonProperty("misc") String misc,@JsonProperty("closing") String closing,
                           @JsonProperty("posstatus") String posstatus,
                           @JsonProperty("cprice") BigDecimal cprice,@JsonProperty("ccost") BigDecimal ccost,
                           @JsonProperty("cfee") BigDecimal cfee,@JsonProperty("cvol") BigDecimal cvol,
                           @JsonProperty("cmargin") BigDecimal cmargin,@JsonProperty("net") BigDecimal net,
                           @JsonProperty("trades") List<String> trades) {
        this.ordertxid = ordertxid;
        this.assetPair = assetPair;
        this.time = time;
        this.type = type;
        this.ordertype = ordertype;
        this.price = price;
        this.cost = cost;
        this.fee = fee;
        this.vol = vol;
        this.margin = margin;
        this.misc = misc;
        this.closing = closing;
        this.posstatus = posstatus;
        this.cprice = cprice;
        this.ccost = ccost;
        this.cfee = cfee;
        this.cvol = cvol;
        this.cmargin = cmargin;
        this.net = net;
        this.trades = trades;
    }

    public String getOrdertxid() {
        return ordertxid;
    }

    public String getAssetPair() {
        return assetPair;
    }

    public long getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public BigDecimal getPrice() {
        return price;
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

    public BigDecimal getMargin() {
        return margin;
    }

    public String getMisc() {
        return misc;
    }

    public String getClosing() {
        return closing;
    }

    public String getPosstatus() {
        return posstatus;
    }

    public BigDecimal getCprice() {
        return cprice;
    }

    public BigDecimal getCcost() {
        return ccost;
    }

    public BigDecimal getCfee() {
        return cfee;
    }

    public BigDecimal getCvol() {
        return cvol;
    }

    public BigDecimal getCmargin() {
        return cmargin;
    }

    public BigDecimal getNet() {
        return net;
    }

    public List<String> getTrades() {
        return trades;
    }

    @Override
    public String toString() {
        return "KrakenTradeInfo{" +
                "ordertxid='" + ordertxid + '\'' +
                ", assetPair='" + assetPair + '\'' +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", ordertype='" + ordertype + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", fee=" + fee +
                ", vol=" + vol +
                ", margin=" + margin +
                ", misc='" + misc + '\'' +
                ", closing='" + closing + '\'' +
                ", posstatus='" + posstatus + '\'' +
                ", cprice=" + cprice +
                ", ccost=" + ccost +
                ", cfee=" + cfee +
                ", cvol=" + cvol +
                ", cmargin=" + cmargin +
                ", net=" + net +
                ", trades=" + trades +
                '}';
    }
}
