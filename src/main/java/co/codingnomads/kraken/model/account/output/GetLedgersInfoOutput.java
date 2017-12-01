package co.codingnomads.kraken.model.account.output;

import co.codingnomads.kraken.model.OutputGeneric;

import java.util.Arrays;

public class GetLedgersInfoOutput extends OutputGeneric {
    /**
     * Created by Meghan Boyce on 11/29/17
     */

    // Ledger info
    String[] ledger_id;
    // Reference id
    String refid;
    // Unx timestamp of ledger
    String time;
    // Type of ledger entry
    String type;
    // Asset class
    String aclass;
    String asset;
    // Transaction amount
    String amount;
    // Transaction fee
    String fee;
    // Resulting balance
    String balance;

    // Fully qualified Constructor
    public GetLedgersInfoOutput(String[] ledger_id, String refid, String time, String type,
                                String aclass, String asset, String amount, String fee,
                                String balance) {
        this.ledger_id = ledger_id;
        this.refid = refid;
        this.time = time;
        this.type = type;
        this.aclass = aclass;
        this.asset = asset;
        this.amount = amount;
        this.fee = fee;
        this.balance = balance;
    }

    // Empty Constructor
    public GetLedgersInfoOutput() {
    }

    // Getters and setters
    public String[] getLedger_id() {
        return ledger_id;
    }

    public void setLedger_id(String[] ledger_id) {
        this.ledger_id = ledger_id;
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

    @Override
    public String toString() {
        return "GetLedgersInfoOutput{" +
                "ledger_id=" + Arrays.toString(ledger_id) +
                ", refid='" + refid + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", aclass='" + aclass + '\'' +
                ", asset='" + asset + '\'' +
                ", amount='" + amount + '\'' +
                ", fee='" + fee + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
