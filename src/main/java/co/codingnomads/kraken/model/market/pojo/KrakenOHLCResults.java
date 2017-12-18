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

/**
 * Created by Ricardo Roque - December 12, 2017
 *
 * This is the information body, KrakenOHLCResults POJO, for the result list of objects from the KrakeOHLC.
 *
 * The results are included in an array of pair name (OHCLs) and OHLC data as seen on the
 *
 * Kraken api call <url>https://www.kraken.com/help/api#get-ohlc-data</url>
 */

@JsonDeserialize(using = KrakenOHLCResults.KrakenOHLCDeserializer.class)
public class KrakenOHLCResults {

    /**
     * @param OHLCs = array of array entries(<time>, <open>, <high>, <low>, <close>, <vwap>, <volume>, <count>
     * @param last = id to be used as since when polling for new, committed OHLC data
     */

    private final List<KrakenOHLC> OHLCs;
    private final long last;


    //Fully qualified constructor
    public KrakenOHLCResults(List<KrakenOHLC> OHLCs, long last) {
        this.OHLCs = OHLCs;
        this.last = last;
    }


    public List<KrakenOHLC> getOHLCs() {
        return OHLCs;
    }

    public long getLast() {
        return last;
    }


    @Override
    public String toString() {
        return "KrakenOHLCResults [OHLCs=" + OHLCs + ", last=" + last + "]";
    }


    /**
     * Customized deserializer based on boiler plate deserializer code by timmolter <url>https://github.com/timmolter/XChange</url>
     * Deals with KrakenOHLC containing multiple data types.
     */

    static class KrakenOHLCDeserializer extends JsonDeserializer<KrakenOHLCResults> {

        @Override
        public KrakenOHLCResults deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

            List<KrakenOHLC> krakenOHLCdata = new ArrayList<>();
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
                        long time = tradeJsonNode.path(0).asLong();
                        BigDecimal open = new BigDecimal(tradeJsonNode.path(1).asText());
                        BigDecimal high = new BigDecimal(tradeJsonNode.path(2).asText());
                        BigDecimal low = new BigDecimal(tradeJsonNode.path(3).asText());
                        BigDecimal close = new BigDecimal(tradeJsonNode.path(4).asText());
                        BigDecimal vwap = new BigDecimal(tradeJsonNode.path(5).asText());
                        BigDecimal volume = new BigDecimal(tradeJsonNode.path(6).asText());
                        long count = tradeJsonNode.path(7).asLong();

                        krakenOHLCdata.add(new KrakenOHLC(time, open, high, low, close, vwap, volume, count));

                    }
                }
            }
            return new KrakenOHLCResults(krakenOHLCdata, last);
        }

    }


}
