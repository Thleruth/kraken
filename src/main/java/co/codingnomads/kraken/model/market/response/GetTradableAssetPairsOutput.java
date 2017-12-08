package co.codingnomads.kraken.model.market.response;

/*
created by PopoPenguin on 11/29/17
*/

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojos.KrakenAssetPairName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetTradableAssetPairsOutput extends OutputWrapper<Map<String, KrakenAssetPairName>> {

    public GetTradableAssetPairsOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenAssetPairName> result) {
        super(result, error);
    }
}
