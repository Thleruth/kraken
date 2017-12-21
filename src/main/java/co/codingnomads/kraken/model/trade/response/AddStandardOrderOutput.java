package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenAddStandardOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Neag
 */

public class AddStandardOrderOutput extends OutputWrapper<KrakenAddStandardOrder> {

    public AddStandardOrderOutput(@JsonProperty("error") String[] error,
                                  @JsonProperty("result")KrakenAddStandardOrder result) {
        super(result, error);
    }
}
