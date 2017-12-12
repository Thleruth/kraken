package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetOpenOrdersOutput extends OutputWrapper<Map<String, KrakenOpenOrder>>{
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     */

    public GetOpenOrdersOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") Map<String, KrakenOpenOrder> result) {
        super(result, error);
    }
}
