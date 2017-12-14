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

/**
 * Created by Ricardo Roque
 */

@JsonDeserialize(using = KrakenRecentTrades.KrakenTradeDeserializer.class)
public class KrakenRecentTrades {

    /**
     * @param trades = array of array entries(<price>, <volume>, <time>, <buy/sell>, <market/limit>, <miscellaneous>)
     * @param last = id to be used as since when polling for new trade data
     */

    private final List<KrakenRecentTrade> trades;
    private final long last;


    //Fully qualified constructor
    public KrakenRecentTrades(List<KrakenRecentTrade> trades, long last) {

        this.trades = trades;
        this.last = last;
    }


    //Getters and setters
    public long getLast() {

        return last;
    }

    public List<KrakenRecentTrade> getTrades() {

        return trades;
    }


    @Override
    public String toString() {

        return "KrakenTrades [trades=" + trades + ", last=" + last + "]";
    }


    /**
     * Customized deserializer based on boiler plate deserializer code by timmolter.
     * Deals with List<KrakenRecentTrade> containing multiple data types.
     */

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

    }
}

