package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Meghan Boyce on 11/29/17
 *
 */
public class GetOpenOrdersOutput extends OutputWrapper<Map<String, KrakenOpenOrder>>{

    /**
     *
     * @param error
     * @param result
     */
    public GetOpenOrdersOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") Map<String, KrakenOpenOrder> result) {
        super(result, error);
    }
}
