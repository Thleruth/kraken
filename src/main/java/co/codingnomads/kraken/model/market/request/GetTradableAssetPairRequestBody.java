package co.codingnomads.kraken.model.market.request;

/*
created by PopoPenguin on 12/8/17
*/


import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetTradableAssetPairRequestBody extends RequestBodyGeneric {

    String info;
    String leverage;
    String fees;
    String margin;
    String pair;

    public GetTradableAssetPairRequestBody(@JsonProperty("info")String info, @JsonProperty("leverage")String leverage,
                                           @JsonProperty("fees")String fees, @JsonProperty("margin")String margin,
                                           @JsonProperty("pair")String pair) {
        this.info = info;
        this.leverage = leverage;
        this.fees = fees;
        this.margin = margin;
        this.pair = pair;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    @Override
    public String toString() {
        return "GetTradableAssetPairRequestBody{" +
                "info='" + info + '\'' +
                ", leverage='" + leverage + '\'' +
                ", fees='" + fees + '\'' +
                ", margin='" + margin + '\'' +
                ", pair='" + pair + '\'' +
                '}';
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        sb.append("&").append("info").append("=").append(getInfo());
        sb.append("&").append("leverage").append("=").append(getLeverage());
        sb.append("&").append("fees").append("=").append(getFees());
        sb.append("&").append("margin").append("=").append(getMargin());
        sb.append("&").append("pair").append("=").append(getPair());
        return sb.toString();
    }

    @Override
    public MultiValueMap<String, String> postParam() {
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        postParameters.add("info", getInfo());
        postParameters.add("leverage", getLeverage());
        postParameters.add("fees", getFees());
        postParameters.add("margin", getMargin());
        postParameters.add("pair", getPair());
        return postParameters;
    }

    //TODO need to test if this actually works for requestbody
}
