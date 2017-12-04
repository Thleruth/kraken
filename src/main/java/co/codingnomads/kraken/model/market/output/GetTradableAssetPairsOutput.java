package co.codingnomads.kraken.model.market.output;

/*
created by PopoPenguin on 11/29/17
*/

import co.codingnomads.kraken.model.OutputGeneric;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.AssetPairName;
import co.codingnomads.kraken.util.ArrayMapDeserializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(using = ArrayMapDeserializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTradableAssetPairsOutput extends OutputWrapper<GetTradableAssetPairsOutput> {


    HashMap<String, AssetPairName> mapData = new HashMap<String, AssetPairName>();

    public HashMap<String, AssetPairName> getMapData() {
        return mapData;
    }

    public void setMapData(HashMap<String, AssetPairName> mapData) {
        this.mapData = mapData;
    }

    @Override
    public String toString() {
        return "GetTradableAssetPairsOutput{" +
                "mapData=" + mapData +
                '}';
    }
}
