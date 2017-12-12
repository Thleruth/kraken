package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KrakenLedgers {
    /**
     * Created by Meghan Boyce on 12/07/17
     */

    // Reference id
    String refid;
    // Unx timestamp of ledger
    String time;
    // Type of ledger entry
    String type;
    // KrakenAsset class
    String aclass;
    // KrakenAsset
    String asset;
    // Transaction amount
    String amount;
    // Transaction fee
    String fee;
    // Resulting balance
    String balance;

    public KrakenLedgers(@JsonProperty("refid") String refid, @JsonProperty("time")String time,
                         @JsonProperty("type") String type, @JsonProperty("aclass") String aclass,
                         @JsonProperty("asset") String asset, @JsonProperty("amount") String amount,
                         @JsonProperty("fee") String fee, @JsonProperty("balance") String balance) {
        this.refid = refid;
        this.time = time;
        this.type = type;
        this.aclass = aclass;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
