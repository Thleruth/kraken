package co.codingnomads.kraken.model.market.pojos;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Ricardo Roque
 * 1/Dec/2017
 */

public class KrakenTickerInformation {

    //ask array contains three values(price, whole lot volume, and lot volume). Letter "a"
    private final String ask;
    //bid array asking for three values(price, whole lot volume, lot volume). Letter "b"
    private final String bid;
    //last Trade closed array asking for two values(price, lot volume). Letter "c"
    private final String lastTradeClosed;
    //volume array asking for two values(today, last 24 hours). Letter "v"
    private final BigDecimal[] volume;
    //volume weighted average price array requesting tw values(today, last 24 hours). Letter "p"
    private final BigDecimal[] vwaPrice;
    //number of trades array with two values(today, last 24 hours). Letter "t"
    private final int trades;
    //low array with two values(today, last 24 hours). Letter "l"
    private final BigDecimal[] low;
    //high array with two values(today, last 24 hours). Letter "h"
    private final BigDecimal[] high;
    //today's opening price
    private final BigDecimal opening;


    public KrakenTickerInformation(@JsonProperty("a") String ask, @JsonProperty("b") String bid, @JsonProperty("c") String lastTradeClosed, @JsonProperty("v") BigDecimal[] volume,
                                   @JsonProperty("p") BigDecimal[] vwaPrice, @JsonProperty("t") int trades, @JsonProperty("l") BigDecimal[] low, @JsonProperty("h") BigDecimal[] high, @JsonProperty("o") BigDecimal opening) {
        this.ask = ask;
        this.bid = bid;
        this.lastTradeClosed = lastTradeClosed;
        this.volume = volume;
        this.vwaPrice = vwaPrice;
        this.trades = trades;
        this.low = low;
        this.high = high;
        this.opening = opening;
    }

    public String getAsk() {
        return ask;
    }

    public String getBid() {
        return bid;
    }

    public String getLastTradeClosed() {
        return lastTradeClosed;
    }

    public BigDecimal[] getVolume() {
        return volume;
    }

    public BigDecimal[] getVwaPrice() {
        return vwaPrice;
    }

    public int getTrades() {
        return trades;
    }

    public BigDecimal[] getLow() {
        return low;
    }

    public BigDecimal[] getHigh() {
        return high;
    }

    public BigDecimal getOpening() {
        return opening;
    }

    @Override
    public String toString() {
        return "KrakenTickerInformation{" +
                "ask='" + ask + '\'' +
                ", bid='" + bid + '\'' +
                ", lastTradeClosed='" + lastTradeClosed + '\'' +
                ", volume=" + Arrays.toString(volume) +
                ", vwaPrice=" + Arrays.toString(vwaPrice) +
                ", trades=" + trades +
                ", low=" + Arrays.toString(low) +
                ", high=" + Arrays.toString(high) +
                ", opening=" + opening +
                '}';
    }
}
