package co.codingnomads.kraken.model.market;

/*
created by PopoPenguin on 11/29/17
*/


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigDecimal;

public class Fees {


    BigDecimal volume;
    BigDecimal percentFee;

    public Fees(BigDecimal volume, BigDecimal percentFee) {
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
        return "Fees{" +
                "volume=" + volume +
                ", percentFee=" + percentFee +
                '}';
    }

    static class FeesDeserializer extends JsonDeserializer<Fees> {

        @Override
        public Fees deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            BigDecimal volume = new BigDecimal(node.path(0).asText());
            BigDecimal percentFee = new BigDecimal(node.path(1).asText());

            return new Fees(volume, percentFee);
        }
    }
}
