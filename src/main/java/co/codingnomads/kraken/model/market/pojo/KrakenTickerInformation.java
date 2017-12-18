package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Ricardo Roque- Dec/1/2017
 *
 *This section is the body, the POJO, for the result list of objects in the api call GetTickerInformationOutput
 *<url>https://api.kraken.com/0/public/Ticker?pair=XBTUSD</url>
 *This, in direct correlation to the mapping of said call on <url>https://www.kraken.com/help/api#get-ticker-info</url>
 */


public class KrakenTickerInformation {


    //ask array contains three values(price, whole lot volume, and lot volume). Letter "a"
    private final String[] ask;
    //bid array asking for three values(price, whole lot volume, lot volume). Letter "b"
    private final String[] bid;
    //last Trade closed array asking for two values(price, lot volume). Letter "c"
    private final String[] lastTradeClosed;
    //volume array asking for two values(today, last 24 hours). Letter "v"
    private final String[] volume;
    //volume weighted average price array requesting two values(today, last 24 hours). Letter "p"
    private final String[] vwaPrice;
    //number of trades array with two values(today, last 24 hours). Letter "t"
    private final int[] trades;
    //low array with two values(today, last 24 hours). Letter "l"
    private final String[] low;
    //high array with two values(today, last 24 hours). Letter "h"
    private final String[] high;
    //today's opening price
    private final String opening;


    /**
     * @param ask             = "a"
     * @param bid             = "b
     * @param lastTradeClosed = "c"
     * @param volume          = "v"
     * @param vwaPrice        = "p"
     * @param trades          = "t"
     * @param low             = "l"
     * @param high            = "h"
     * @param opening         = "o"
     */

    //Fully functional constructor
    public KrakenTickerInformation(@JsonProperty("a") String[] ask, @JsonProperty("b") String[] bid, @JsonProperty("c") String[] lastTradeClosed, @JsonProperty("v") String[] volume,
                                   @JsonProperty("p") String[] vwaPrice, @JsonProperty("t") int[] trades, @JsonProperty("l") String[] low, @JsonProperty("h") String[] high, @JsonProperty("o") String opening) {
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


    public String[] getAsk() {
        return ask;
    }

    public String[] getBid() {
        return bid;
    }

    public String[] getLastTradeClosed() {
        return lastTradeClosed;
    }

    public String[] getVolume() {
        return volume;
    }

    public String[] getVwaPrice() {
        return vwaPrice;
    }

    public int[] getTrades() {
        return trades;
    }

    public String[] getLow() {
        return low;
    }

    public String[] getHigh() {
        return high;
    }

    public String getOpening() {
        return opening;
    }


    @Override
    public String toString() {
        return "KrakenTickerInformation{" +
                "ask=" + Arrays.toString(ask) +
                ", bid=" + Arrays.toString(bid) +
                ", lastTradeClosed=" + Arrays.toString(lastTradeClosed) +
                ", volume=" + Arrays.toString(volume) +
                ", vwaPrice=" + Arrays.toString(vwaPrice) +
                ", trades=" + Arrays.toString(trades) +
                ", low=" + Arrays.toString(low) +
                ", high=" + Arrays.toString(high) +
                ", opening='" + opening + '\'' +
                '}';
    }
}
