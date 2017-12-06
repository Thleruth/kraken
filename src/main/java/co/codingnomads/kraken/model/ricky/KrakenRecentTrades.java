package co.codingnomads.kraken.model.ricky;




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

@JsonDeserialize(using = KrakenRecentTrades.KrakenTradesDeserializer.class)
public class KrakenRecentTrades {

    private final List<KrakenRecentTrade> trades;
    private final long last;

    public KrakenRecentTrades(List<KrakenRecentTrade> trades, long last) {

        this.trades = trades;
        this.last = last;
    }

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

    static class KrakenTradesDeserializer extends JsonDeserializer<KrakenRecentTrades> {

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
                        String type = tradeJsonNode.path(3).asText();
                        String orderType = tradeJsonNode.path(4).asText();
                        String miscellaneous = tradeJsonNode.path(5).asText();

                        krakenTrades.add(new KrakenRecentTrade(price, volume, time, type, orderType, miscellaneous));
                    }
                }
            }
            return new KrakenRecentTrades(krakenTrades, last);
        }

    }

}

