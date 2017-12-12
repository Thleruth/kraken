package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class KrakenRecentTrade {

    private final BigDecimal price;
    private final BigDecimal volume;
    private final double time;
    private final String buySell;
    private final String marketLimit;
    private final String miscellaneous;

    public KrakenRecentTrade(@JsonProperty("price") BigDecimal price, @JsonProperty("volume") BigDecimal volume,
                             @JsonProperty("time") double time, @JsonProperty("buySell") String buySell,
                             @JsonProperty("marketLimit") String marketLimit,
                             @JsonProperty("miscellaneous") String miscellaneous) {
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
                "price='" + price + '\'' +
                ", volume='" + volume + '\'' +
                ", time=" + time +
                ", buySell='" + buySell + '\'' +
                ", marketLimit='" + marketLimit + '\'' +
                ", miscellaneous='" + miscellaneous + '\'' +
                '}';
    }
}
