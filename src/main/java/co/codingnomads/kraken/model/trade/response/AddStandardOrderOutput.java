package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenAddOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AddStandardOrderOutput extends OutputWrapper<Map<String, KrakenAddOrder>> {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     */

    public AddStandardOrderOutput(@JsonProperty("error") String[] error,
                                  @JsonProperty("result") Map<String, KrakenAddOrder> result) {
        super(result, error);
    }



}
