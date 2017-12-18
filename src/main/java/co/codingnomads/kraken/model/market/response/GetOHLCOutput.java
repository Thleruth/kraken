package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOHLCResults;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ricardo Roque -  December 12, 2017
 *
 * Given the JSON format for JSON response from GetOHLCOutput api call <url>https://api.kraken.com/0/public/OHLC</url>
 *
 * Kraken API Documentation for this call is located in <url>https://www.kraken.com/help/api#get-ohlc-data</url>
 */

public class GetOHLCOutput extends OutputWrapper<KrakenOHLCResults> {

    /**
     * @param error  as a String array
     * @param result as an object of KrakenOHLCResults
     */

    public GetOHLCOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenOHLCResults result) {

        super(result, error);
    }
}
