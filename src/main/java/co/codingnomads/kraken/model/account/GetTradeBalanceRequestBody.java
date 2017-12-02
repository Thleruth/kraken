package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.RequestBodyGeneric;

//need to be reworked for JSON and have to learn how to post the body correctly when multiple elements
public class GetTradeBalanceRequestBody extends RequestBodyGeneric {

    // asset class (optional)
    String assetClass;

    // base asset used to determine balance (default = ZUSD) (optional)
    String asset;

    public GetTradeBalanceRequestBody(String assetClass, String asset) {
        super();
        this.assetClass = assetClass;
        this.asset = asset;
    }

    public GetTradeBalanceRequestBody(){
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "GetTradeBalanceRequestBody{" +
                "assetClass='" + assetClass + '\'' +
                ", asset='" + asset + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "assetClass='" + assetClass + '\'' +
//                ", asset='" + asset + '\'' +
//                ", nonce='" + nonce + '\'';
//    }
}
