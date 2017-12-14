package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ricardo Roque - Dec/1/2017
 * Given the way the Json element displays the values, a Map is being used for results with a String[] of errors.
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

