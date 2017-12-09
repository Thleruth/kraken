package co.codingnomads.kraken.model.trade.response;

/*
created by PopoPenguin on 12/8/17
*/

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetTradesHistoryOutput extends OutputWrapper<Map<String, KrakenTradeInfo>> {

    public GetTradesHistoryOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenTradeInfo> result) {
        super(result, error);
    }

}
