package co.codingnomads.kraken.model.market.pojos;




import co.codingnomads.kraken.model.OutputWrapper;
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

public class KrakenRecentTrades {

    private final List<KrakenRecentTrade> trades;
    private final long last;

    public KrakenRecentTrades(@JsonProperty("trades") List<KrakenRecentTrade> trades, @JsonProperty("last") long last) {

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



}

