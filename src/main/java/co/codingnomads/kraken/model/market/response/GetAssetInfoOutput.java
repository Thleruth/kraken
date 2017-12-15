package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 *  created by PopoPenguin on 12/12/17
 *
 *  Given the JSON format for JSON response from GetAssetInfo api call <url>https://api.kraken.com/0/public/Assets</url>
 *  returns a String array error and a result list of objects, mapping the result list of objects
 *  by the String ID and the body of the object was the best course to map the JSON response.
 *
 *  Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-asset-info</url>
 *
 *  resource : <url>https://github.com/timmolter/XChange/tree/5174f9e931955dc201fa57e228564d8b884c9f84/xchange-kraken/src/main/java/org/knowm/xchange/kraken</url>
 */


public class GetAssetInfoOutput extends OutputWrapper<Map<String, KrakenAsset>> {

    /**
     * Maps the result list of objects to a String ID associated to the Asset name
     * and corresponding body with associated information to the KrakenAsset POJO
     *
     * @param error     display of error(s) if encountered
     * @param result    list of asset name(s) and information body
     */
    public GetAssetInfoOutput(@JsonProperty("error") String[] error,
                              @JsonProperty("result") Map<String, KrakenAsset> result) {
        super(result, error);
    }
}
