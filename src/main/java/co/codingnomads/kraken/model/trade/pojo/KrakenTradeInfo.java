package co.codingnomads.kraken.model.trade.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by Jialor Cheung on 11/29/17
 *
 * This is the information body, KrakenTradeInfo POJO, for the result list of objects in
 * api call GetTradeHistory <url>https://api.kraken.com/0/private/TradesHistory</url>
 * and api call QueryTradesInfo <url>https://api.kraken.com/0/private/QueryTrades</url>
 *
 *
 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#get-trades-history</url>
 * and <url>https://www.kraken.com/help/api#query-trades-info</url>
 */

@JsonIgnoreProperties (ignoreUnknown = true)
public class KrakenTradeInfo {

    private final String ordertxid;
    private final String assetPair;
    private final String type;
    private final String ordertype;
    private final String misc;
    private final String closing;
    private final String posstatus;
    private final List<String> trades;

    private final long time;

    //using BigDecimal format for most accurate data type associated to monetary values
    private final BigDecimal price;
    private final BigDecimal cost;
    private final BigDecimal fee;
    private final BigDecimal vol;
    private final BigDecimal margin;
    private final BigDecimal cprice;
    private final BigDecimal ccost;
    private final BigDecimal cfee;
    private final BigDecimal cvol;
    private final BigDecimal cmargin;
    private final BigDecimal net;

    /**
     * Fully Qualified Constructor
     *
     * @param ordertxid     order responsible for execution of trade
     * @param assetPair     asset pair
     * @param time          unix timestamp of trade
     * @param type          type of order (buy/sell)
     * @param ordertype     order type
     * @param price         average price order was executed at (quote currency)
     * @param cost          total cost of order (quote currency)
     * @param fee           total fee (quote currency)
     * @param vol           volume (base currency)
     * @param margin        initial margin (quote currency)
     * @param misc          comma delimited list of miscellaneous info
     * @param closing       trade closes all or part of a position
     * @param posstatus     position status (open/closed)
     * @param cprice        average price of closed portion of position (quote currency)
     * @param ccost         total cost of closed portion of position (quote currency)
     * @param cfee          total fee of closed portion of position (quote currency)
     * @param cvol          total fee of closed portion of position (quote currency)
     * @param cmargin       total margin freed in closed portion of position (quote currency)
     * @param net           net profit/loss of closed portion of position (quote currency, quote currency scale)
     * @param trades        list of closing trades for position (if available)
     *
     *                      Note: Unless otherwise stated, costs, fees, prices, and volumes are in the asset pair's
     *                      scale, not the currency's scale.
     *                      Times given by trade tx ids are more accurate than unix timestamps.
     */

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

    // Getters for variables
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
