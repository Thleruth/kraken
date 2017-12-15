package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 *  created by Jialor Cheung on 12/12/17
 *
 *  Given the JSON format for JSON response from GetAssetInfo api call <url>https://api.kraken.com/0/public/Assets</url>
 *  Returns a String array error and a result list of objects, mapping of the result list of objects
 *  by the Key(Asset) and value (KrakenAsset) corresponding to call's output.
 *
 *  Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-asset-info</url>
 */


public class GetAssetInfoOutput extends OutputWrapper<Map<String, KrakenAsset>> {

    /**
     * Constructor
     * Maps the result list of objects to a String ID associated to the Asset name
     * and corresponding body with associated information to the KrakenAsset POJO
     *
     * @param error     display of error(s) if encountered
     * @param result    list of asset name(s) and corresponding value(s)
     */
    public GetAssetInfoOutput(@JsonProperty("error") String[] error,
                              @JsonProperty("result") Map<String, KrakenAsset> result) {
        super(result, error);
    }
}
