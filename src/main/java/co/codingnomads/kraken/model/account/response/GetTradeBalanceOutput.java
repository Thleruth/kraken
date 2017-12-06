package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojos.KrakenTradeBalance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//need to be reworked for JSON property (see GetBalanceOutput)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTradeBalanceOutput extends OutputWrapper<KrakenTradeBalance> {

    public GetTradeBalanceOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenTradeBalance result){
        super(result, error);

    }
}
