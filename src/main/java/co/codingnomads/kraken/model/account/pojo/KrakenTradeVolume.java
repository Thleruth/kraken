package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Kevin Neag
 */
public class KrakenTradeVolume {

    private String currency;

    private long volume;

    private List<KrakenFee> fee; //if requested

    private List<KrakenFee_Maker> fee_maker; // if requested


    //make a constructor with only currency and volume;


    public KrakenTradeVolume(@JsonProperty("currency") String currency,@JsonProperty("volume") long volume) {
        this.currency = currency;
        this.volume = volume;
    }

    public KrakenTradeVolume(@JsonProperty("currency") String currency, @JsonProperty("volume") long volume, @JsonProperty("fee")List<KrakenFee> fee, @JsonProperty("fee_maker")List<KrakenFee_Maker> fee_maker) {

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
