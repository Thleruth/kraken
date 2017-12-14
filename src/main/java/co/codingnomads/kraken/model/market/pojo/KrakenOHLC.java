package co.codingnomads.kraken.model.market.pojo;

import java.math.BigDecimal;

/**
 * created by Ricardo Roque - December 12, 2017
 */

public class KrakenOHLC {

    /**
     * @param time
     * @param open
     * @param high
     * @param low
     * @param close
     * @param vwap
     * @param volume
     * @param count
     */

    private final long time;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final BigDecimal vwap;
    private final BigDecimal volume;
    private final long count;

    //Fully qualified constructor
    public KrakenOHLC(long time, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close,
                      BigDecimal vwap, BigDecimal volume, long count) {
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.vwap = vwap;
        this.volume = volume;
        this.count = count;
    }

    public long getTime() {
        return time;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getVwap() {
        return vwap;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public long getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "KrakenOHLC [time=" + time + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", vwap=" + vwap + ", volume=" + volume + ", count=" + count + "]";
    }
}
