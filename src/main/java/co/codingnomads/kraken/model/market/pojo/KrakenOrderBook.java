package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Ricardo Roque - Dec/1/2017
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
