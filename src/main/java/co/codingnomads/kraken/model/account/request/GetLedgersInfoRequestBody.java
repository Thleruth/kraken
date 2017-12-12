<<<<<<< HEAD
package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import co.codingnomads.kraken.model.account.pojo.KrakenLedgerType;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.sql.Timestamp;

/**
 * @author Kevin Neag
 */


public class GetLedgersInfoRequestBody extends RequestBodyGeneric {

    private String assetclass; //optional
    private String currency; //default
    private String asset; //optional, default all
    private String type; //optional, default all, deposit, withdrawal, trade, margin
    private long start; //starting unix timestamp or ledger id of results (optional.  exclusive)
    private long end;//ending unix timestamp or ledger id of results (optional.  inclusive)
    private String ofs;

    public GetLedgersInfoRequestBody(@JsonProperty("aclass") String assetclass, @JsonProperty("currency") String currency,
                                     @JsonProperty("asset") String asset, @JsonProperty("type") String type,
                                     @JsonProperty("start") long start, @JsonProperty("end") long end,
                                     @JsonProperty("ofs") String ofs) {
        this.assetclass = assetclass;
        this.currency = currency;
        this.asset = asset;
        this.type = type;
        this.start = start;
        this.end = end;
        this.ofs = ofs;

    }

    public GetLedgersInfoRequestBody(@JsonProperty("ofs") String ofs) {
        this.ofs = ofs;
    }

    public String getAssetclass() {
        return assetclass;
    }

    public void setAssetclass(String assetclass) {
        this.assetclass = assetclass;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getOfs() {
        return ofs;
    }

    public void setOfs(String ofs) {
        this.ofs = ofs;
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if (null != assetclass ){
            postParameters.add("aclass", getAssetclass());
        }
        if (null != currency){
            postParameters.add("currency", getCurrency());
        }
        if (null != asset){
            postParameters.add("asset", getAsset());
        }
        if (null != type){
            postParameters.add("type", getType());
        }
        if (start > 0){
            postParameters.add("start", String.valueOf(getStart()));
        }
        if (end > 0){
            postParameters.add("end", String.valueOf(getEnd()));
        }
        postParameters.add("ofs", getOfs());

        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != assetclass){
            sb.append("aclass").append("=").append(getAssetclass());
        }
        if (null != currency){
            sb.append("currency").append("=").append(getCurrency());
        }
        if (null != asset) {
            sb.append("asset").append("=").append(getAsset());
        }
        if (null != type) {
            sb.append("type").append("=").append(getType());
        }
        if (start > 0){
            sb.append("start").append("=").append(getStart());
        }
        if (end > 0) {
            sb.append("end").append("=").append(getEnd());
        }
        sb.append("ofs").append("=").append(getOfs());
        return sb.toString();
    }



}



=======

//todo fix this one

//package co.codingnomads.kraken.model.account.request;
//
//import co.codingnomads.kraken.model.RequestBodyGeneric;
//
//public class GetLedgersInfoRequestBody extends RequestBodyGeneric {
//}
>>>>>>> 02d55952d9b5a4ee1f6450287797dbf162629bfc
