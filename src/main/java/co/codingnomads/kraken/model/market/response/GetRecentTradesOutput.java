package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenRecentTrades;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetRecentTradesOutput extends OutputWrapper<Map<String, KrakenRecentTrades>> {
    public GetRecentTradesOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenRecentTrades> result) {
        super(result, error);

    }
}