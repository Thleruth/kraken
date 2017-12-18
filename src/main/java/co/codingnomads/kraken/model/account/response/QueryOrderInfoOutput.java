package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ricardo Roque on Dec/10/2017
 *
 * Given the JSON format for JSON response from GetTradesHistory api call <url>https://api.kraken.com/0/private/QueryOrders</url>
 *
 * Returns a String array error and a Map of Strings and the results from KrakenOpenOrders
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#query-orders-info</url>
 */

public class QueryOrderInfoOutput extends OutputWrapper<Map<String, KrakenOpenOrder>> {

    /**
     *
     * @param error produces a String array of errors.
     * @param result produces a Map of Strings and the results from KrakenOpenOrders
     */
    public QueryOrderInfoOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") Map<String, KrakenOpenOrder> result) {

        super(result, error);
    }
}
