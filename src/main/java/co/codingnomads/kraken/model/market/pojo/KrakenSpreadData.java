package co.codingnomads.kraken.model.market.pojo;

import java.math.BigDecimal;

public class KrakenSpreadData {

    long time;
    BigDecimal bid;
    BigDecimal ask;

    /**
     *
     * @param time
     * @param bid
     * @param ask
     */
    public KrakenSpreadData(long time, BigDecimal bid, BigDecimal ask) {
        this.time = time;
        this.bid = bid;
        this.ask = ask;
    }

    /**
     *
     * @return long
     */
    public long getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getBid() {
        return bid;
    }

    /**
     *
     * @param bid
     */
    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    /**
     *
     * @return BigDecimal
     */
    public BigDecimal getAsk() {
        return ask;
    }

    /**
     *
     * @param ask
     */
    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return "KrakenSpreadData{" +
                "time=" + time +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
