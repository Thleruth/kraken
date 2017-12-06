package co.codingnomads.kraken.model.ricky;

import java.math.BigDecimal;

public class KrakenRecentTrade {

    private final BigDecimal price;
    private final BigDecimal volume;
    private final double time;
    private final String buySell;
    private final String marketLimit;
    private final String miscellaneous;

    public KrakenRecentTrade(BigDecimal price, BigDecimal volume, double time, String buySell, String marketLimit, String miscellaneous) {
        this.price = price;
        this.volume = volume;
        this.time = time;
        this.buySell = buySell;
        this.marketLimit = marketLimit;
        this.miscellaneous = miscellaneous;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public double getTime() {
        return time;
    }

    public String getBuySell() {
        return buySell;
    }

    public String getMarketLimit() {
        return marketLimit;
    }

    public String getMiscellaneous() {
        return miscellaneous;
    }

    @Override
    public String toString() {
        return "KrakenRecentTrade{" +
                "price=" + price +
                ", volume=" + volume +
                ", time=" + time +
                ", buySell='" + buySell + '\'' +
                ", marketLimit='" + marketLimit + '\'' +
                ", miscellaneous='" + miscellaneous + '\'' +
                '}';
    }

    /*
    "12580.90000",
"0.00477703",
1512576773.4992,
"b",
"l",
""
     */
}
