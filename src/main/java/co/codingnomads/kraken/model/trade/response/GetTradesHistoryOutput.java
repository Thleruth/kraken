package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * created by Jialor Cheung on 12/8/17
 *
 * Given the JSON format for JSON response from GetTradesHistory api call <url>https://api.kraken.com/0/private/TradesHistory</url>
 * Returns a String array error and a result list of objects. Within result list of objects, two variables (a list of objects and
 * an int count) required mapping of the object "trades" with key (trades) and the value (KrakenTradeInfo)
 * corresponding to call's output.
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-trades-history</url>
 */

public class GetTradesHistoryOutput extends OutputWrapper<GetTradesHistoryOutput.KrakenTradeHistory> {

    /**
     * Constructor
     * Result list consists of object KrakenTradeHistory
     *
     * @param error     display of error(s) if encountered
     * @param result    list of asset name(s) and corresponding value(s)
     */
    public GetTradesHistoryOutput(@JsonProperty("result") KrakenTradeHistory result, @JsonProperty("error") String[] error) {

        super(result, error);
    }

    /**
     * KrakenTradeHistory is object of result API call consisting of count and a mapping of the trade list of objects
     *  by the Key(txid) and value (KrakenTradeInfo) corresponding to call's output.
     */
    public static class KrakenTradeHistory {

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


}
