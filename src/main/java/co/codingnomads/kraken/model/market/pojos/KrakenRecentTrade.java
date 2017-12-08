package co.codingnomads.kraken.model.market.pojos;

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

@JsonDeserialize(using = KrakenRecentTrade.KrakenTradeDeserializer.class)

public class KrakenRecentTrade {

    private final BigDecimal price;
    private final BigDecimal volume;
    private final double time;
    private final String buySell;
    private final String marketLimit;
    private final String miscellaneous;

    public KrakenRecentTrade(@JsonProperty("price") BigDecimal price, @JsonProperty("volume") BigDecimal volume,
                             @JsonProperty("time") double time, @JsonProperty("buySell") String buySell, @JsonProperty("marketLimit") String marketLimit,
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
        return "KrakenRecentTrade [price=" + price + ", volume=" + volume + ", time=" + time + ", buySell=" + buySell +
                ", marketLimit=" + marketLimit + ", miscellaneous=" + miscellaneous + "]";
    }

    static class KrakenTradeDeserializer extends JsonDeserializer<KrakenRecentTrades> {

        @Override
        public KrakenRecentTrades deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

            List<KrakenRecentTrade> krakenTrades = new ArrayList<>();
            long last = 0;
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            Iterator<Map.Entry<String, JsonNode>> tradesResultIterator = node.fields();
            while (tradesResultIterator.hasNext()) {
                Map.Entry<String, JsonNode> entry = tradesResultIterator.next();
                String key = entry.getKey();
                JsonNode value = entry.getValue();
                if (key == "last") {
                    last = value.asLong();
                } else if (value.isArray()) {
                    for (JsonNode tradeJsonNode : value) {
                        BigDecimal price = new BigDecimal(tradeJsonNode.path(0).asText());
                        BigDecimal volume = new BigDecimal(tradeJsonNode.path(1).asText());
                        double time = tradeJsonNode.path(2).asDouble();
                        String buySell = tradeJsonNode.path(3).asText();
                        String marketLimit = tradeJsonNode.path(4).asText();
                        String miscellaneous = tradeJsonNode.path(5).asText();

                        krakenTrades.add(new KrakenRecentTrade(price, volume, time, buySell, marketLimit, miscellaneous));

                    }
                }
            }
            return new KrakenRecentTrades(krakenTrades, last);
        }
        /*
    private final BigDecimal price;
    private final BigDecimal volume;
    private final double time;
    private final String buySell;
    private final String marketLimit;
    private final String miscellaneous;
         */

    }
}
