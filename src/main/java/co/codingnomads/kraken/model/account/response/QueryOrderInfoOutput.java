package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrders;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class QueryOrderInfoOutput extends OutputWrapper<Map<String, KrakenOpenOrders>> {

    public QueryOrderInfoOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") Map<String, KrakenOpenOrders> result) {
        super(result, error);
    }
}
