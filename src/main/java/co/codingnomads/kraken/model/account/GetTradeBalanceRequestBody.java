package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by Thomas Leruth on 12/6/17
 */

public class GetTradeBalanceRequestBody extends RequestBodyGeneric {

    // asset class (optional)
    String aClass;

    // base asset used to determine balance (default = ZUSD) (optional)
    String asset;

    public String getAClass() {
        return aClass;
    }

    public void setAClass(String alass) {
        this.aClass = aClass;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        // for more: postParameters.add("InstanceVariableXName", "InstanceVariableXValueInString");
        if (aClass != null)
            postParameters.add("aClass", getAClass());
        if (asset != null)
            postParameters.add("asset", getAsset());
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        // for more: sb.append("&").append("InstanceVariableXName").append("=").append("InstanceVariableXValueInString")
        if (aClass != null)
            sb.append("&").append("aClass").append("=").append(getAClass());
        if (asset != null)
            sb.append("&").append("asset").append("=").append(getAsset());
        return sb.toString();
    }

    public GetTradeBalanceRequestBody(String aClass, String asset) {
        super();
        if (aClass != null)
            this.aClass = aClass;
        if (asset != null)
            this.asset = asset;
    }

}

