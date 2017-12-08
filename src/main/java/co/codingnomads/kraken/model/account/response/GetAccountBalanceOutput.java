package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.response.pojo.KrakenAccountBalance;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 12/7/17
 */

public class GetAccountBalanceOutput extends OutputWrapper<KrakenAccountBalance> {

    public GetAccountBalanceOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenAccountBalance result) {
        super(result, error);
    }
}
