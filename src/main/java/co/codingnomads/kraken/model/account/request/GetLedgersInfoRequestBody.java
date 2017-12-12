//todo fix this one
package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class GetLedgersInfoRequestBody extends RequestBodyGeneric {

    //asset class (optional), currency (default)
    String aclass;
    //comma delimited list of assets to restrict output to (optional.  default = all)
    String asset;
    //type is optional, by default all
    String type;
    //start time is optional, exclusive by default
    Long start;
    //end time is optional, inclusive by default
    Long end;
    //String ofs is a required field
    String ofs;

    public GetLedgersInfoRequestBody(String ofs) {
        this.ofs = ofs;
    }

    public GetLedgersInfoRequestBody(@JsonProperty("aclass")String aclass, @JsonProperty("asset")String asset,
                                     @JsonProperty("type")String type, @JsonProperty("start")Long start,
                                     @JsonProperty("end")Long end, @JsonProperty("ofs")String ofs) {
        this.aclass = aclass;
        this.asset = asset;
        this.type = type;
        this.start = start;
        this.end = end;
        this.ofs = ofs;
    }

    public String getAclass() {
        return aclass;
    }

    public void setAclass(String aclass) {
        this.aclass = aclass;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getOfs() {
        return ofs;
    }

    public void setOfs(String ofs) {
        this.ofs = ofs;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != getAclass()) {
            sb.append("&").append("type").append("=").append(getAclass());
        }
        if (null != getAsset()) {
            sb.append("&").append("type").append("=").append(getAsset());
        }
        if (null != getType()) {
            sb.append("&").append("type").append("=").append(getType());
        }
        if (null != getStart()){
            sb.append("&").append("start").append("=").append(getStart());
        }
        if (null != getEnd()) {
            sb.append("&").append("end").append("=").append(getEnd());
        }
        sb.append("&").append("ofs").append("=").append(getOfs());
        return sb.toString();
    }

    @Override
    public MultiValueMap<String, String> postParam() {
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        if (null != getAclass()){
            postParameters.add("type", getAclass());
        }
        if (null != getAsset()){
            postParameters.add("type", getAsset());
        }
        if (null != getType()){
            postParameters.add("type", getType());
        }
        if (null != getStart()) {
            postParameters.add("start", String.valueOf(getStart()));
        }
        if (null != getEnd()) {
            postParameters.add("end", String.valueOf(getEnd()));
        }
        postParameters.add("ofs", getOfs());
        return postParameters;
    }


}
