package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenTradeBalance;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 12/7/17
 */

public class GetTradeBalanceOutput extends OutputWrapper<KrakenTradeBalance> {

    public GetTradeBalanceOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenTradeBalance result){
        super(result, error);
    }
}
