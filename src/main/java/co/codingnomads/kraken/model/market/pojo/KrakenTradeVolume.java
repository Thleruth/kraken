package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Kevin Neag
 */
public class KrakenTradeVolume {

    private final String currency;

    private final long volume;

    private List<KrakenFee> fee; //if requested

    private List<KrakenFee_Maker> fee_maker; // if requested

    public KrakenTradeVolume(String currency, long volume, @JsonProperty("fee")List<KrakenFee> fee, @JsonProperty("fee_maker")List<KrakenFee_Maker> fee_maker) {

        this.currency = currency;
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

    public long getVolume() {
        return volume;
    }

    public List<KrakenFee> getFee() {
        return fee;
    }

    public void setFee(List<KrakenFee> fee) {
        this.fee = fee;
    }

    public List<KrakenFee_Maker> getFee_maker() {
        return fee_maker;
    }

    public void setFee_maker(List<KrakenFee_Maker> fee_maker) {
        this.fee_maker = fee_maker;
    }
}
