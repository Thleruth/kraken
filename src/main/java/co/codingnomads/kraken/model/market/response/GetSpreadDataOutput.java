package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSpreadDataOutput extends OutputWrapper<KrakenSpread> {

    /**
     *
     * @param error
     * @param result
     */
    public GetSpreadDataOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") KrakenSpread result) {

        super(result, error);
    }
}
