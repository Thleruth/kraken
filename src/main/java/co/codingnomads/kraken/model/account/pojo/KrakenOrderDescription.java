package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenOrderDescription {

    //KrakenResult[OK: {descr={order=sell 0.02000000 ETHUSD @ market}, txid=[OEIPIA-O3ZJ2-EJORQ3]}]
    // KrakenAsset pair
    String pair;
    // Type of order (buy/sell)
    String type;
    // See add standard order
    String ordertype;
    // Primary price
    String price;
    // Secondary price
    String price2;
    // Amount of leverage
    String leverage;
    // Order description
    String order;
    // Conditional close order description (if conditional close set)
    String close;

    /**
     *
     * @param pair
     * @param type
     * @param ordertype
     * @param price
     * @param price2
     * @param leverage
     * @param order
     * @param close
     */
    public KrakenOrderDescription(@JsonProperty("pair")String pair,
                                  @JsonProperty("type")String type,
                                  @JsonProperty("ordertype")String ordertype,
                                  @JsonProperty("price")String price,
                                  @JsonProperty("price2")String price2,
                                  @JsonProperty("leverage")String leverage,
                                  @JsonProperty("order")String order,
                                  @JsonProperty("close")String close) {
        this.pair = pair;
        this.type = type;
        this.ordertype = ordertype;
        this.price = price;
        this.price2 = price2;
        this.leverage = leverage;
        this.order = order;
        this.close = close;
    }

    /**
     *
     * @return String
     */
    public String getPair() {
        return pair;
    }

    /**
     *
     * @param pair
     */
    public void setPair(String pair) {
        this.pair = pair;
    }

    /**
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return String
     */
    public String getOrdertype() {
        return ordertype;
    }

    /**
     *
     * @param ordertype
     */
    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    /**
     *
     * @return String
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return String
     */
    public String getPrice2() {
        return price2;
    }

    /**
     *
     * @param price2
     */
    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    /**
     *
     * @return String
     */
    public String getLeverage() {
        return leverage;
    }

    /**
     *
     * @param leverage
     */
    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    /**
     *
     * @return String
     */
    public String getOrder() {
        return order;
    }

    /**
     *
     * @param order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     *
     * @return String
     */
    public String getClose() {
        return close;
    }

    /**
     *
     * @param close
     */
    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "KrakenOrderDescription{" +
                "pair='" + pair + '\'' +
                ", type='" + type + '\'' +
                ", ordertype='" + ordertype + '\'' +
                ", price='" + price + '\'' +
                ", price2='" + price2 + '\'' +
                ", leverage='" + leverage + '\'' +
                ", order='" + order + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
