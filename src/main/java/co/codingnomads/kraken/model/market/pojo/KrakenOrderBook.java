package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Ricardo Roque - Dec/1/2017
 *
 * This is the information body, KrakenOrderBook POJO, for the result list of objects in
 *
 * api call GetOrderBookOutput <url>https://api.kraken.com/0/public/Depth</url>
 *
 * This, mapped according to the body of the Kraken api <url>https://www.kraken.com/help/api#get-order-book</url>
 */

public class KrakenOrderBook {

    /**
     * @param asks
     * @param bids
     */

    //ask side array of array contains three values(price, volume, timestamp).
    private final List<KrakenOrder> asks;

    //ask side array of array contains three values(price, volume, timestamp).
    private final List<KrakenOrder> bids;

    //Fully qualified constructor
    public KrakenOrderBook(@JsonProperty("asks") List<KrakenOrder> asks, @JsonProperty("bids") List<KrakenOrder> bids) {
        this.asks = asks;
        this.bids = bids;
    }

    public List<KrakenOrder> getAsks() {
        return asks;
    }

    public List<KrakenOrder> getBids() {
        return bids;
    }

    @Override
    public String toString() {
        return "KrakenOrderBook{" +
                "asks='" + asks + '\'' +
                ", bids='" + bids + '\'' +
                '}';
    }
}
