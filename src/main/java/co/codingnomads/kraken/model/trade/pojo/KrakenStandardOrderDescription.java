package co.codingnomads.kraken.model.trade.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Neag
 */

public class KrakenStandardOrderDescription {

  String orderDescription;
  String closeDescription;

    public KrakenStandardOrderDescription(@JsonProperty("order") String orderDescription, @JsonProperty("close") String closeDescription) {

        this.orderDescription = orderDescription;
        this.closeDescription = closeDescription;
    }

    public String getOrderDescription() {

        return orderDescription;
    }

    public String getCloseDescription() {

        return closeDescription;
    }

    @Override
    public String toString() {

        return "KrakenOrderResponseDescription [orderDescription=" + orderDescription + ", closeDescription=" + closeDescription + "]";
    }

}

