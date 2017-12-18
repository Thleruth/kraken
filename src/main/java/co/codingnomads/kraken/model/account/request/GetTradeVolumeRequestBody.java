package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Kevin Neag
 */

public class GetTradeVolumeRequestBody extends RequestBodyGeneric {

    private String pair; //pair = comma delimited list of asset pairs to get fee info on (optional)
    private Boolean feeInfo = false; //fee-info = whether or not to include fee info in results (optional)

    public GetTradeVolumeRequestBody(String pair, Boolean feeInfo) {
        super();
        this.pair = pair;
        this.feeInfo = feeInfo;
    }

    public GetTradeVolumeRequestBody(String pair) {
        super();
        this.pair = pair;
    }

    public GetTradeVolumeRequestBody() {
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public Boolean getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(Boolean feeInfo) {
        this.feeInfo = feeInfo;
    }

    @Override
    public String toString() {
        return "GetTradeVolumeRequestBody{" +
                "pair='" + pair + '\'' +
                ", feeInfo='" + feeInfo + '\'' +
                '}';
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if(null != pair){
            postParameters.add("pair", getPair());
        }
        if (feeInfo == true){
            postParameters.add("fee-info", String.valueOf(getFeeInfo()));
        }
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != pair){
            sb.append("&").append("pair").append("=").append(getPair());
        }
        if (feeInfo == true){
            sb.append("&").append("fee-info").append("=").append(getFeeInfo());
        }
        return sb.toString();
    }

}
