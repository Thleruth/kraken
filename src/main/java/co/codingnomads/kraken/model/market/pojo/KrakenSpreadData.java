package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.math.BigDecimal;

public class KrakenSpreadData {

    long time;
    BigDecimal bid;
    BigDecimal ask;

    public KrakenSpreadData(long time, BigDecimal bid, BigDecimal ask) {
        this.time = time;
        this.bid = bid;
        this.ask = ask;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

//    static class SpreadDataDeserializer extends JsonDeserializer<KrakenSpreadData> {
//
//        @Override
//        public KrakenSpreadData deserialize(JsonParser jsonParser, DeserializationContext ctxt)
//                throws IOException, JsonProcessingException {
//
//            ObjectCodec oc = jsonParser.getCodec();
//            JsonNode node = oc.readTree(jsonParser);
//            if (node.isArray()) {
//                long time = node.path(0).asLong();
//                BigDecimal bid = new BigDecimal(node.path(1).asText());
//                BigDecimal ask = new BigDecimal(node.path(2).asText());
//
//                return new KrakenSpreadData(time, bid, ask);
//            }
//
//            return null;
//        }
//    }
}
