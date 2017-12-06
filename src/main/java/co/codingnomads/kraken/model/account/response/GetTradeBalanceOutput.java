package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.GetTradeBalance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//need to be reworked for JSON property (see GetBalanceOutput)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTradeBalanceOutput extends OutputWrapper<GetTradeBalance> {

    public GetTradeBalanceOutput(@JsonProperty("error") String[] error, @JsonProperty("result") GetTradeBalance result){
        super(result, error);

    }
}
