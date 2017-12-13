package co.codingnomads.kraken.model.account.pojo;

import co.codingnomads.kraken.model.market.pojo.KrakenFees;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Kevin Neag
 */


public class KrakenLedgersInfo {


    String refid;
    float time;
    String type;
    String assetClass;
    String asset;
    BigDecimal amount;
    BigDecimal fee;
    BigDecimal balance;

    public KrakenLedgersInfo(@JsonProperty("refid") String refid, @JsonProperty("time") float time,
                             @JsonProperty("type") String type, @JsonProperty("aclass") String assetClass,
                             @JsonProperty("asset") String asset, @JsonProperty("amount") BigDecimal amount,
                             @JsonProperty("fee") BigDecimal fee, @JsonProperty("balance") BigDecimal balance) {
        this.refid = refid;
        this.time = time;
        this.type = type;
        this.assetClass = assetClass;
        this.asset = asset;
        this.amount = amount;
        this.fee = fee;
        this.balance = balance;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "KrakenLedgersInfo{" +
                "refid=" + refid +
                ", time=" + time +
                ", type='" + type + '\'' +
                ", assetClass='" + assetClass + '\'' +
                ", asset='" + asset + '\'' +
                ", amount=" + amount +
                ", fee=" + fee +
                ", balance=" + balance +
                '}';



//        static class LedgersInfoDeserializer extends JsonDeserializer<KrakenFees> {
//
//            @Override
//            public KrakenLedgersInfo deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
//
//                ObjectCodec oc = jsonParser.getCodec();
//                JsonNode node = oc.readTree(jsonParser);
//                if (node.isArray()){
//                    BigDecimal volume = new BigDecimal(node.path(0).asText());
//                    BigDecimal percentFee = new BigDecimal(node.path(1).asText());
//
//                    return new KrakenFees(volume, percentFee);
//                }
//
//                return null;

//            }
//        }
    }
}
