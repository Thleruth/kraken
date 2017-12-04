package co.codingnomads.kraken.model.market.output;

/*
created by PopoPenguin on 11/29/17
*/

import co.codingnomads.kraken.model.OutputGeneric;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.AssetPairName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTradableAssetPairsOutput extends OutputWrapper<GetTradableAssetPairsOutput> {

    //Result is an array of String with object for each pair name
    //mapping string an object separately

    Map<String, AssetPairName> assetPairMap;


    public GetTradableAssetPairsOutput(){}

    public GetTradableAssetPairsOutput(String[] errors, GetTradableAssetPairsOutput result, Map<String, AssetPairName> assetPairMap) {
        super(errors, result);
        this.assetPairMap = assetPairMap;
    }

    public GetTradableAssetPairsOutput(Map<String, AssetPairName> assetPairMap) {

        this.assetPairMap = assetPairMap;
    }

    public void setAssetPairMap(Map<String, AssetPairName> assetPairMap) {
        this.assetPairMap = assetPairMap;
    }

    public Map<String, AssetPairName> getAssetPairMap() {

        return assetPairMap;
    }
}
