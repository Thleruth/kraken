package co.codingnomads.kraken.model.account.pojo;

import co.codingnomads.kraken.model.ApiAuthentication;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Kevin Neag
 */
public class KrakenFee {


    BigDecimal fee;
    BigDecimal minFee; //fee for pair (if not fixed fee)
    BigDecimal maxFee; //fee for pair (if not fixed fee)
    BigDecimal nextFee; //next tier's fee for pair (if not fixed fee.  nil if at lowest fee tier)
    long nextVolume; //volume level of next tier (if not fixed fee.  nil if at lowest fee tier)
    long tiervolume; //volume level of current tier (if not fixed fee.  nil if at lowest fee tier)

    public KrakenFee(@JsonProperty("fee") BigDecimal fee,@JsonProperty("minfee") BigDecimal minFee,@JsonProperty("maxfee") BigDecimal maxFee, @JsonProperty("nextfee") BigDecimal nextFee, @JsonProperty("nextvolume") long nextVolume, @JsonProperty("tiervolume") long tiervolume) {

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

        if(nextVolume != 0) {
            this.nextVolume = nextVolume;
        }

        if (tiervolume != 0) {
            this.tiervolume = tiervolume;
        }
    }
}
