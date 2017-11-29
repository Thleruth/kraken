package model;

import model.RequestBodyGeneric;

public class GetTradeBalanceBodyRequest extends RequestBodyGeneric {

        // asset class (optional)
        String assetClass;

        // base asset used to determine balance (default = ZUSD) (optional)
        String asset;

    public GetTradeBalanceBodyRequest(String assetClass, String asset) {
        super();
        this.assetClass = assetClass;
        this.asset = asset;
    }

}
