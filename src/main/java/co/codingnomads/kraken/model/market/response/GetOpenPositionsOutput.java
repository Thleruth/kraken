package co.codingnomads.kraken.model.market.response;

/*
created by PopoPenguin on 12/8/17
*/


import co.codingnomads.kraken.model.market.pojos.KrakenOpenPositions;
import co.codingnomads.kraken.model.OutputWrapper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetOpenPositionsOutput extends OutputWrapper<Map<String, KrakenOpenPositions>> {

    public GetOpenPositionsOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenOpenPositions> result) {
        super(result, error);
    }
}
