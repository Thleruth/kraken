package co.codingnomads.kraken.model.market.pojo;




import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KrakenRecentTrades {

    private final List<KrakenRecentTrade> trades;
    private final long last;

    public KrakenRecentTrades(@JsonProperty("trades") List<KrakenRecentTrade> trades, @JsonProperty("last") long last) {

        this.trades = trades;
        this.last = last;
    }

    public long getLast() {

        return last;
    }

    public List<KrakenRecentTrade> getTrades() {

        return trades;
    }

    @Override
    public String toString() {

        return "KrakenTrades [trades=" + trades + ", last=" + last + "]";
    }



}

