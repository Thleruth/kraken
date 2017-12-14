package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenRecentTrades;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

/**
 * Created by Ricardo Roque
 */

public class GetRecentTradesOutput extends OutputWrapper<KrakenRecentTrades> {

    /**
     * @param error  as a String array
     * @param result as an object from KrakenRecentTrades
     */

    public GetRecentTradesOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenRecentTrades result) {

        super(result, error);
    }
}

