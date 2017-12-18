package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ricardo Roque - Dec/1/2017
 *
 * Given the way the Json element displays the values, a Map is being used for the results and, if produced, a String[] of errors.
 *
 * Given the JSON format for JSON response from GetOrderBookOutput api call <url>https://api.kraken.com/0/public/Depth</url>
 *
 * Kraken API Documentation for this call is located in <url>https://api.kraken.com/0/public/Depth</url>
 */

public class GetOrderBookOutput extends OutputWrapper<Map<String, KrakenOrderBook>> {

    /**
     * @param error  as a String array
     * @param result as a Map<String, KrakenOrderBook>
     */

    public GetOrderBookOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenOrderBook> result) {

        super(result, error);
    }
}

