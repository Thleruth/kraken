package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojos.KrakenOrderDescription;
import co.codingnomads.kraken.model.trade.pojos.KrakenAddOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AddStandardOrdersOutput extends OutputWrapper<Map<String, KrakenAddOrder>> {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     */
    public AddStandardOrdersOutput(@JsonProperty("error") String[] error,
                                 @JsonProperty("result") Map<String, KrakenAddOrder> result) {
        super(result, error);

    }



}
