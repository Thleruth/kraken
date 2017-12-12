package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenOrderDescription {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     * order description info
     */

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


}
