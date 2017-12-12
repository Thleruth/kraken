package co.codingnomads.kraken.model.market.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import co.codingnomads.kraken.model.market.pojo.KrakenLedgerType;
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
    private KrakenLedgerType type; //optional, default all, deposit, withdrawal, trade, margin
    private Timestamp start; //starting unix timestamp or ledger id of results (optional.  exclusive)
    private Timestamp end; //ending unix timestamp or ledger id of results (optional.  inclusive)
    private long ofs; //im guessing this is the time difference

    public GetLedgersInfoRequestBody(@JsonProperty("aclass") String assetclass, @JsonProperty("currency") String currency,
                                     @JsonProperty("asset") String asset, @JsonProperty("type") KrakenLedgerType type,
                                     @JsonProperty("start") Timestamp start, @JsonProperty("end") Timestamp end,
                                     @JsonProperty("ofs") long ofs) {
        if (null != assetclass) {
            this.assetclass = assetclass;
        }

        this.currency = currency;
        this.asset = asset;

        if (null != type) {
            this.type = type;
        }
        if (null != start) {
            this.start = start;
            this.end = end;
            this.ofs = ofs;
        }
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

    public KrakenLedgerType getType() {
        return type;
    }

    public void setType(KrakenLedgerType type) {
        this.type = type;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public long getOfs() {
        return ofs;
    }

    public void setOfs(long ofs) {
        this.ofs = ofs;
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        if( null != assetclass ){
            postParameters.add("aclass", getAssetclass());
        }
        postParameters.add("currency", getCurrency());
        postParameters.add("asset", getAsset());
        if (null != type){
            postParameters.add("type", getType());
        }
        if (null != start){
            postParameters.add("start", getStart());
            postParameters.add("end", getEnd());
            postParameters.add("ofs", getOfs());
        }
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != assetclass){

            sb.append("aclass").append("=").append(getAssetclass());
        }
        sb.append("currency").append("=").append(getCurrency());
        sb.append("asset").append("=").append(getAsset());
        if (null != type) {

            sb.append("type").append("=").append(getType());
        }
        if (null != start){
            sb.append("start").append("=").append(getStart());
            sb.append("end").append("=").append(getEnd());
            sb.append("ofs").append("=").append(getOfs());
        }
        return sb.toString();
    }
}



