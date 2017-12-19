
package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


/**
 * @author Kevin Neag
 */

public class GetLedgersInfoRequestBody extends RequestBodyGeneric {

    private String assetclass; //optional
    private String asset; //optional, default all
    private String type; //optional, default all, deposit, withdrawal, trade, margin
    private long start; //starting unix timestamp or ledger id of results (optional.  exclusive)
    private long end; //ending unix timestamp or ledger id of results (optional.  inclusive)
    private long ofs; //result offset


    public GetLedgersInfoRequestBody(long ofs) {
        this.ofs = ofs;
    }

    public GetLedgersInfoRequestBody(String assetclass, String asset, String type, long start, long end, long ofs) {
        if (null != assetclass)
            this.assetclass = assetclass;
        if (null != asset)
            this.asset = asset;
        if (null != type)
            this.type = type;
        if (start > 0)
            this.start = start;
        if (end > 0)
            this.end = end;
        this.ofs = ofs;
    }

    public String getAssetclass() {
        return assetclass;
    }

    public void setAssetclass(String assetclass) {
        this.assetclass = assetclass;
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

    public long getOfs() {
        return ofs;
    }

    public void setOfs(long ofs) {
        this.ofs = ofs;
    }

    @Override
    public String toString() {
        return "GetLedgersInfoRequestBody{" +
                "assetclass='" + assetclass + '\'' +
                ", asset='" + asset + '\'' +
                ", type='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", ofs=" + ofs +
                '}';
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", super.getNonce());
        if (null != assetclass ){
            postParameters.add("aclass", getAssetclass());
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
        postParameters.add("ofs", String.valueOf(getOfs()));

        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        if (null != assetclass){
            sb.append("&").append("aclass").append("=").append(getAssetclass());
        }
        if (null != asset) {
            sb.append("&").append("asset").append("=").append(getAsset());
        }
        if (null != type) {
            sb.append("&").append("type").append("=").append(getType());
        }
        if (start > 0){
            sb.append("&").append("start").append("=").append(getStart());
        }
        if (end > 0) {
            sb.append("&").append("end").append("=").append(getEnd());
        }
        sb.append("&").append("ofs").append("=").append(getOfs());
        return sb.toString();
    }
}




