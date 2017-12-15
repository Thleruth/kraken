package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.trade.pojo.KrakenOpenPosition;
import co.codingnomads.kraken.model.OutputWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * created by Jialor Cheung on 12/8/17
 *
 * Given the JSON format for JSON response from GetOpenPositions api call <url>https://api.kraken.com/0/private/OpenPositions</url>
 * Returns a String array error and a result list of objects, mapping of the result list of objects
 * by the key (position_txid) and the value (KrakenOpenPosition) corresponding to call's output.
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-open-positions</url>
 */

public class GetOpenPositionsOutput extends OutputWrapper<Map<String, KrakenOpenPosition>> {

    /**
     * Constructor
     * Maps the result list of objects to a String ID associated to the position_txid
     * and corresponding body with associated information to the KrakenOpenPosition POJO
     *
     * @param error     display of error(s) if encountered
     * @param result    list of position_txid(s) and corresponding value(s)
     */
    public GetOpenPositionsOutput(@JsonProperty("error") String[] error,
                                  @JsonProperty("result") Map<String, KrakenOpenPosition> result) {
        super(result, error);
    }
}
