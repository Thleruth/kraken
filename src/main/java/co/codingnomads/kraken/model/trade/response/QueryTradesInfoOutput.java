package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * created by Jialor Cheung on 12/8/17
 *
 * Given the JSON format for JSON response from QueryTradesInfo api call <url>https://api.kraken.com/0/private/QueryTrades</url>
 * Returns a String array error and a result list of objects, mapping of the result list of objects
 * by the key (trade_txid) and the value (KrakenTradeInfo) corresponding to call's output.
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#query-trades-info</url>
 */

public class QueryTradesInfoOutput extends OutputWrapper<Map<String, KrakenTradeInfo>> {

    /**
     * Constructor
     * Maps the result list of objects to a String ID associated to the trade_txid
     * and corresponding body with associated information to the KrakenTradeInfo POJO
     *
     * @param error     display of error(s) if encountered
     * @param result    list of trade_txid(s) and corresponding value(s)
     */
    public QueryTradesInfoOutput(@JsonProperty("error") String[] error,
                                 @JsonProperty("result") Map<String, KrakenTradeInfo> result) {
        super(result, error);
    }

}
