package co.codingnomads.kraken.model.trade.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * KrakenTradeHistory is object of result API call GetTradesHistory consisting of count and a mapping of list of trade objects
 * by the Key(txid) and value (KrakenTradeInfo) corresponding to call's output.
 */
public class KrakenTradeHistory {

    private final Map<String, KrakenTradeInfo> trades;
    private final int count;

    /**
     * Constructor
     * Maps the result list of objects to a String ID associated to the txid
     * and corresponding body with associated information to the KrakenTradeInfo POJO
     *
     * @param trades    array of trade info with txid as the key
     * @param count     amount of available trades info matching criteria
     */
    public KrakenTradeHistory(@JsonProperty("trades") Map<String, KrakenTradeInfo> trades, @JsonProperty ("count") int count) {

        this.trades = trades;
        this.count = count;
    }

    // Getters for variables
    public Map<String, KrakenTradeInfo> getTrades() {

        return trades;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "KrakenTradeHistory{" +
                "trades=" + trades +
                ", count=" + count +
                '}';
    }
}