package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Kevin Neag
 */
public class KrakenLedgerType {

    BigDecimal deposit;
    BigDecimal withdrawal; //deposit
    String trade;
    String margin;

    public KrakenLedgerType(@JsonProperty("deposit") BigDecimal deposit, @JsonProperty("withdrawal") BigDecimal withdrawal,
                            @JsonProperty("trade") String trade, @JsonProperty("margin") String margin) {

        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.trade = trade;
        this.margin = margin;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(BigDecimal withdrawal) {
        this.withdrawal = withdrawal;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }


    @Override
    public String toString() {
        return "KrakenLedgerType{" +
                "deposit=" + deposit +
                ", withdrawal=" + withdrawal +
                ", trade='" + trade + '\'' +
                ", margin='" + margin + '\'' +
                '}';
    }
}
