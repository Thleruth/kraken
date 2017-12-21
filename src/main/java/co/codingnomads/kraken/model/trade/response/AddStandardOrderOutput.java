package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenAddOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AddStandardOrderOutput extends OutputWrapper<KrakenAddOrder> {

    public AddStandardOrderOutput(@JsonProperty("error") String[] error,
                                  @JsonProperty("result")KrakenAddOrder result) {
        super(result, error);
    }
}
