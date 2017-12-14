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

/**
 * Created by ryandesmond on 12/6/17.
 */

@JsonDeserialize(using = KrakenOrder.OrderDeserializer.class)
public class KrakenOrder {

    /**
     * @param price
     * @param volume
     * @param timestamp
     * Using BigDecimal rather than String since it is the most accurate data type when dealing with monetary values
     */

    private final BigDecimal price;
    private final BigDecimal volume;
    private final long timestamp;

    //Fully qualified constructor
    public KrakenOrder(BigDecimal price, BigDecimal volume, long timestamp) {

        this.price = price;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public BigDecimal getVolume() {

        return volume;
    }

    public long getTimestamp() {

        return timestamp;
    }

    @Override
    public String toString() {

        return "KrakenOpenOrder [price=" + price + ", volume=" + volume + ", timestamp=" + timestamp + "]";
    }


    /**
     * Based on boiler plate deserializer code by timmolter.
     * Deals with List<KrakenOrder> containing multiple data types.
     */

    public static class OrderDeserializer extends JsonDeserializer<KrakenOrder> {

        //Deserializer method which returns a constructor with parameters already matched to the Json format.
        @Override
        public KrakenOrder deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            if (node.isArray()) {
                BigDecimal price = new BigDecimal(node.path(0).asText());
                BigDecimal volume = new BigDecimal(node.path(1).asText());
                long timestamp = node.path(2).asLong();

                return new KrakenOrder(price, volume, timestamp);
            }

            return null;
        }
    }
}
