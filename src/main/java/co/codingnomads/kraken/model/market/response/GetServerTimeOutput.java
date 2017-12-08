package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenServerTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 12/7/17
 */

public class GetServerTimeOutput extends OutputWrapper<KrakenServerTime> {

    public GetServerTimeOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenServerTime result){
        super(result, error);
    }
}
