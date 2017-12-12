package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenLedgersInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author Kevin Neag
 */
public class GetLedgersInfoOutput extends OutputWrapper<Map<String, KrakenLedgersInfo>> {


    public GetLedgersInfoOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenLedgersInfo> result){

        super(result, error);

    }
}
