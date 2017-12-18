package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenTickerInformation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


/**
 * Created by Ricardo Roque - Dec/1/2017
 *
 * Mapped accordingly from the Kraken API documentation found in <url>https://www.kraken.com/help/api#get-ticker-info</url>
 * Based on the JSON format accessible on <url>https://api.kraken.com/0/public/Ticker</url>
 */
public class GetTickerInformationOutput extends OutputWrapper<Map<String, KrakenTickerInformation>> {

    /**
     * @param error  will be displayed as a String array
     * @param result will return a Map<String, KrakenTickerInformation> objects
     */

    public GetTickerInformationOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenTickerInformation> result) {

        super(result, error);
    }
}