package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenRecentTrades;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by Ricardo Roque
 *
 * Given the JSON format for JSON response from GetRecentTradesOutput api call <url>https://api.kraken.com/0/public/Trades</url>
 *
 * Kraken API Documentation for this call is located in <url>https://www.kraken.com/help/api#get-recent-trades</url>
 */

public class GetRecentTradesOutput extends OutputWrapper<KrakenRecentTrades> {

    /**
     * @param error  as a String array
     * @param result as an object from KrakenRecentTrades
     */

    public GetRecentTradesOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenRecentTrades result) {

        super(result, error);
    }
}

