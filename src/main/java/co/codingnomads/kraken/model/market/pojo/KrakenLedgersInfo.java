package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Kevin Neag
 */
public class KrakenLedgersInfo {


    int refid;
    Timestamp time;
    String type;
    String assetClass;
    String asset;
    BigDecimal amount;
    BigDecimal fee;
    BigDecimal balance;

    public KrakenLedgersInfo(@JsonProperty("refid") int refid, @JsonProperty("time") Timestamp time,
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

    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
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
    }
}
