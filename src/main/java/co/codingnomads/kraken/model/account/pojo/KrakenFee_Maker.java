package co.codingnomads.kraken.model.account.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


/**
 * @author Kevin Neag
 */
public class KrakenFee_Maker {

    BigDecimal fee;
    BigDecimal minFee; //fee for pair (if not fixed fee)
    BigDecimal maxFee; //fee for pair (if not fixed fee)
    BigDecimal nextFee; //next tier's fee for pair (if not fixed fee.  nil if at lowest fee tier)
    BigDecimal nextVolume; //volume level of next tier (if not fixed fee.  nil if at lowest fee tier)
    BigDecimal tiervolume; //volume level of current tier (if not fixed fee.  nil if at lowest fee tier)

    public KrakenFee_Maker(@JsonProperty("fee") BigDecimal fee,@JsonProperty("minfee") BigDecimal minFee,
                     @JsonProperty("maxfee") BigDecimal maxFee, @JsonProperty("nextfee") BigDecimal nextFee,
                     @JsonProperty("nextvolume") BigDecimal nextVolume, @JsonProperty("tiervolume") BigDecimal tiervolume) {

        this.fee = fee;

        if(minFee != null) {
            this.minFee = minFee;
        }

        if(maxFee != null) {
            this.maxFee = maxFee;
        }

        if(nextFee != null) {
            this.nextFee = nextFee;
        }

        if(nextVolume != null) {
            this.nextVolume = nextVolume;
        }

        if (tiervolume != null) {
            this.tiervolume = tiervolume;
        }
    }

    @Override
    public String toString() {
        return "KrakenFee{" +
                "fee=" + fee +
                ", minFee=" + minFee +
                ", maxFee=" + maxFee +
                ", nextFee=" + nextFee +
                ", nextVolume=" + nextVolume +
                ", tiervolume=" + tiervolume +
                '}';
    }
}
