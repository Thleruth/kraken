package co.codingnomads.kraken.model.account.pojos;

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
    // Asset class
    String aclass;
    // Asset
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
}
