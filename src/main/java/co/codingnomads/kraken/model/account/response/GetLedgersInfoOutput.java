package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenLedgersInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author Kevin Neag
 */
public class GetLedgersInfoOutput extends OutputWrapper<Map<String, KrakenLedgersInfo>> {


    public GetLedgersInfoOutput(@JsonProperty("result") Map<String, KrakenLedgersInfo> result,
                                @JsonProperty("error")String[] error) {
        super(result, error);
    }
}
