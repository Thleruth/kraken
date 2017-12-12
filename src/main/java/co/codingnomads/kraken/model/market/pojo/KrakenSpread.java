package co.codingnomads.kraken.model.market.pojo;

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

@JsonDeserialize(using = KrakenSpread.KrakenSpreadDeserializer.class)
public class KrakenSpread {

    private List<KrakenSpreadData> spreads;
    private long last;

    public KrakenSpread(List<KrakenSpreadData> spreads, long last) {
        this.spreads = spreads;
        this.last = last;
    }

    public List<KrakenSpreadData> getSpreads() {
        return spreads;
    }

    public void setSpreads(List<KrakenSpreadData> spreads) {
        this.spreads = spreads;
    }

    public long getLast() {
        return last;
    }

    public void setLast(long last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "KrakenSpread{" +
                "spreads=" + spreads +
                ", last=" + last +
                '}';
    }

    static class KrakenSpreadDeserializer extends JsonDeserializer<KrakenSpread> {

        @Override
        public KrakenSpread deserialize(JsonParser jsonParser, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            List<KrakenSpreadData> krakenSpreadDataList = new ArrayList<>();
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
                    for (JsonNode jsonSpreadNode : value) {
                        long time = jsonSpreadNode.path(0).asLong();
                        BigDecimal bid = new BigDecimal(jsonSpreadNode.path(1).asText());
                        BigDecimal ask = new BigDecimal(jsonSpreadNode.path(2).asText());

                        krakenSpreadDataList.add(new KrakenSpreadData(time, bid, ask));
                    }
                }
            }
            return new KrakenSpread(krakenSpreadDataList, last);
        }
    }
}
