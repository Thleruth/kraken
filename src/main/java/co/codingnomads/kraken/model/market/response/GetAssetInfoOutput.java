package co.codingnomads.kraken.model.market.response;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/*
created by PopoPenguin on 12/12/17
*/

/**
 *  Mapping of JSON response from GetAssetInfo api call <url>https://api.kraken.com/0/public/Assets</url>
 *
 *  Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-asset-info</url>
 *
 * resource : <url>https://github.com/timmolter/XChange/tree/5174f9e931955dc201fa57e228564d8b884c9f84/xchange-kraken/src/main/java/org/knowm/xchange/kraken</url>
 */


public class GetAssetInfoOutput extends OutputWrapper<Map<String, KrakenAsset>> {

    /**
     * Maps the result to String IDAsset and corresponding information body to KrakenAsset POJO
     *
     * @param error     display of error if encountered
     * @param result    array of asset names and their info
     */
    public GetAssetInfoOutput(@JsonProperty("error") String[] error,
                              @JsonProperty("result") Map<String, KrakenAsset> result) {
        super(result, error);
    }
}
