package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeHistory;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * created by Jialor Cheung on 12/8/17
 *
 * Given the JSON format for JSON response from GetTradesHistory api call <url>https://api.kraken.com/0/private/TradesHistory</url>
 * Returns a String array error and an object KrakenTradeHistory.
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-trades-history</url>
 */

public class GetTradesHistoryOutput extends OutputWrapper<KrakenTradeHistory> {

    /**
     * Constructor
     * Result list consists of object KrakenTradeHistory
     *
     * @param error     display of error(s) if encountered
     * @param result    list of KrakenTradeHistory object(s)
     */
    public GetTradesHistoryOutput(@JsonProperty("result") KrakenTradeHistory result, @JsonProperty("error") String[] error) {

        super(result, error);
    }
}
