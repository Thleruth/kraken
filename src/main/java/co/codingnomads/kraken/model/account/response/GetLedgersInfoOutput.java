package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenLedgersInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetLedgersInfoOutput extends OutputWrapper<Map<String, KrakenLedgersInfo>> {
    /**
     * Created by Meghan Boyce on 11/29/17
     */

    public GetLedgersInfoOutput(@JsonProperty("result") Map<String, KrakenLedgersInfo> result,
                                @JsonProperty("error")String[] error) {
        super(result, error);
    }
}
