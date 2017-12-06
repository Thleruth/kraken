package co.codingnomads.kraken.model.ricky.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.ricky.GetOrderBook;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Ricardo Roque
 * 1/Dec/2017
 */
public class GetOrderBookOutput extends OutputWrapper<Map<String, GetOrderBook>> {

    public GetOrderBookOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, GetOrderBook> result){
        super(result, error);

    }


}
