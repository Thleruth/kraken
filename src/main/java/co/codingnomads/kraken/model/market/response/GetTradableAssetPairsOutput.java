package co.codingnomads.kraken.model.market.response;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenAssetPairName;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/*
created by PopoPenguin on 11/29/17
*/

/**
 * Mapping of JSON response from GetTradableAssetPair api call <url>https://api.kraken.com/0/public/AssetPairs</url>
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-tradable-pairs</url>
 *
 * Given the way the Json element displays the values, a Map is being used with a String[] of errors,
 * and a List of values for the result section
 */


public class GetTradableAssetPairsOutput extends OutputWrapper<Map<String, KrakenAssetPairName>> {

    /**
     * Maps the result to String IDPairName and corresponding information body to KrakenAssetPairName POJO
     *
     * @param error     display of error if encountered
     * @param result    array of asset pair names and their info
     */
    public GetTradableAssetPairsOutput(@JsonProperty("error") String[] error,
                                       @JsonProperty("result") Map<String, KrakenAssetPairName> result) {
        super(result, error);
    }
}
