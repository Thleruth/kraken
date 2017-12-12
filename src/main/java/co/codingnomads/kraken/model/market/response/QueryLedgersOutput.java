package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenLedgersInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * @author Kevin Neag
 */

public class QueryLedgersOutput extends OutputWrapper <Map<String, KrakenLedgersInfo>>{


    public QueryLedgersOutput(@JsonProperty("error") String[] error,@JsonProperty("result") Map<String, KrakenLedgersInfo> result){

        super(result, error);

    }

}




