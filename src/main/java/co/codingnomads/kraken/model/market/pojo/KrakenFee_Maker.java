package co.codingnomads.kraken.model.market.pojo;

import java.math.BigDecimal;

/**
 * @author Kevin Neag
 */
public class KrakenFee_Maker {


    BigDecimal fee;
    BigDecimal minFee; //fee for pair (if not fixed fee)
    BigDecimal maxFee; //fee for pair (if not fixed fee)
    BigDecimal nextFee; //next tier's fee for pair (if not fixed fee.  nil if at lowest fee tier)
    long nextVolume; //volume level of next tier (if not fixed fee.  nil if at lowest fee tier)
    long tiervolume; //volume level of current tier (if not fixed fee.  nil if at lowest fee tier)

    public KrakenFee_Maker(BigDecimal fee, BigDecimal minFee, BigDecimal maxFee, BigDecimal nextFee, long nextVolume, long tiervolume) {
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


    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getMinFee() {
        return minFee;
    }

    public void setMinFee(BigDecimal minFee) {
        this.minFee = minFee;
    }

    public BigDecimal getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(BigDecimal maxFee) {
        this.maxFee = maxFee;
    }

    public BigDecimal getNextFee() {
        return nextFee;
    }

    public void setNextFee(BigDecimal nextFee) {
        this.nextFee = nextFee;
    }

    public long getNextVolume() {
        return nextVolume;
    }

    public void setNextVolume(long nextVolume) {
        this.nextVolume = nextVolume;
    }

    public long getTiervolume() {
        return tiervolume;
    }

    public void setTiervolume(long tiervolume) {
        this.tiervolume = tiervolume;
    }

    @Override
    public String toString() {
        return "KrakenFee_Maker{" +
                "fee=" + fee +
                ", minFee=" + minFee +
                ", maxFee=" + maxFee +
                ", nextFee=" + nextFee +
                ", nextVolume=" + nextVolume +
                ", tiervolume=" + tiervolume +
                '}';
    }
}
