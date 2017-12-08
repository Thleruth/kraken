package co.codingnomads.kraken.model.market.pojo;

/*
created by PopoPenguin on 11/29/17
*/


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.math.BigDecimal;

@JsonDeserialize(using = KrakenFees.FeesDeserializer.class)

public class KrakenFees {


    BigDecimal volume;
    BigDecimal percentFee;

    public KrakenFees(BigDecimal volume, BigDecimal percentFee) {
        this.volume = volume;
        this.percentFee = percentFee;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getPercentFee() {
        return percentFee;
    }

    @Override
    public String toString() {
        return "KrakenFees{" +
                "volume=" + volume +
                ", percentFee=" + percentFee +
                '}';
    }

    static class FeesDeserializer extends JsonDeserializer<KrakenFees> {

        @Override
        public KrakenFees deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            if (node.isArray()){
                BigDecimal volume = new BigDecimal(node.path(0).asText());
                BigDecimal percentFee = new BigDecimal(node.path(1).asText());

                return new KrakenFees(volume, percentFee);
            }

            return null;

        }
    }
}
