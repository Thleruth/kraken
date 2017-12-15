package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenAssetPairName;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * created by Jialor Cheung on 11/29/17
 *
 * Given the JSON format for JSON response from GetTradableAssetPairs api call <url>https://api.kraken.com/0/public/AssetPairs</url>
 * Returns a String array error and a result list of objects, mapping of the result list of objects
 * by the key (AssetPair) and the value (KrakenAssetPairName) corresponding to call's output.
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-tradable-pairs</url>
 */


public class GetTradableAssetPairsOutput extends OutputWrapper<Map<String, KrakenAssetPairName>> {

    /**
     * Constructor
     * Maps the result list of objects to a String ID associated to the AssetPair name
     * and corresponding body with associated information to the KrakenAssetPairName POJO
     *
     * @param error     display of error(s) if encountered
     * @param result    list of asset pair name(s) and corresponding value(s)
     */
    public GetTradableAssetPairsOutput(@JsonProperty("error") String[] error,
                                       @JsonProperty("result") Map<String, KrakenAssetPairName> result) {
        super(result, error);
    }
}
