package co.codingnomads.kraken.model.market;

/*
created by PopoPenguin on 12/2/17
*/


import java.util.Map;

public class AssetPairNames {

    Map<String, AssetPairName> assetPairMap;

    public AssetPairNames(){}


    public AssetPairNames(Map<String, AssetPairName> assetPairMap) {

        this.assetPairMap = assetPairMap;
    }

    public Map<String, AssetPairName> getAssetPairMap() {

        return assetPairMap;
    }

}
