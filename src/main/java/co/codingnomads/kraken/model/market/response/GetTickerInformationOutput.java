package co.codingnomads.kraken.model.market.response;


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenTickerInformation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


/**
 * Created by Ricardo Roque 1/Dec/2017
 */
public class GetTickerInformationOutput extends OutputWrapper<Map<String, KrakenTickerInformation>> {

    public GetTickerInformationOutput(@JsonProperty("error") String[] error, @JsonProperty("results") Map<String, KrakenTickerInformation> result) {
        super(result, error);

    }

}