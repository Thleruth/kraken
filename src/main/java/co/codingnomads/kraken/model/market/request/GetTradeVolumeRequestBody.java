package co.codingnomads.kraken.model.market.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author Kevin Neag
 */
public class GetTradeVolumeRequestBody extends RequestBodyGeneric {

//    pair = comma delimited list of asset pairs to get fee info on (optional)
//    fee-info = whether or not to include fee info in results (optional)

    private String pair;
    private String feeInfo;

    public GetTradeVolumeRequestBody(String pair, String feeInfo) {
        super();
        this.pair = pair;
        this.feeInfo = feeInfo;
    }

    public GetTradeVolumeRequestBody() {
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(String feeInfo) {
        this.feeInfo = feeInfo;
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if( null != pair){
            postParameters.add("pair", getPair());
        }
        if (null != feeInfo){
            postParameters.add("fee-info", getFeeInfo());
        }
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != pair){

            sb.append("pair").append("=").append(getPair());
        }
        if (null != feeInfo){

            sb.append("pair").append("=").append(getFeeInfo());
        }
        return sb.toString();
    }

}
