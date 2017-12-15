package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Neag
 */

public class KrakenTradeVolume {

    private String currency;

    private BigDecimal volume;

    private Map<String, KrakenFee> fee; //if requested

    private Map<String,KrakenFee_Maker> fee_maker; //if requested


    public KrakenTradeVolume(@JsonProperty("currency") String currency, @JsonProperty("volume") BigDecimal volume,
                             @JsonProperty("fees")Map<String, KrakenFee> fee, @JsonProperty("fees_maker")
                                     Map<String,KrakenFee_Maker> fee_maker) {

        if(currency != null) {
            this.currency = currency;
        }
        this.volume = volume;
        if(fee != null) {
            this.fee = fee;
        }
        if(fee_maker != null) {
            this.fee_maker = fee_maker;
        }
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Map<String, KrakenFee> getFee() {
        return fee;
    }

    public void setFee(Map<String, KrakenFee> fee) {
        this.fee = fee;
    }

    public Map<String, KrakenFee_Maker> getFee_maker() {
        return fee_maker;
    }

    public void setFee_maker(Map<String, KrakenFee_Maker> fee_maker) {
        this.fee_maker = fee_maker;
    }

    @Override
    public String toString() {
        return "KrakenTradeVolume{" +
                "currency='" + currency + '\'' +
                ", volume=" + volume +
                ", fee=" + fee +
                ", fee_maker=" + fee_maker +
                '}';
    }
}
