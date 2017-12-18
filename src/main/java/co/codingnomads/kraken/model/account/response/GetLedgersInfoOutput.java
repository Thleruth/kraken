package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenLedgersInfoResult;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Kevin Neag
 */

public class GetLedgersInfoOutput extends OutputWrapper<KrakenLedgersInfoResult> {

    public GetLedgersInfoOutput(@JsonProperty("result") KrakenLedgersInfoResult result,
                                @JsonProperty("error")String[] error) {
        super(result, error);
    }
}
