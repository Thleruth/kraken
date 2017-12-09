package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ricardo Roque
 * 1/Dec/2017
 */
public class GetOrderBookOutput extends OutputWrapper<Map<String, KrakenOrderBook>> {

    public GetOrderBookOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenOrderBook> result){
        super(result, error);
    }

}
