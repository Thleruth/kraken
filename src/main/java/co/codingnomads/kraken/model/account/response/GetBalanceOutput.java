package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.GetBalance;
import com.fasterxml.jackson.annotation.*;

/**
 * Created by Thomas Leruth on 11/29/17
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBalanceOutput extends OutputWrapper<GetBalance> {

    public GetBalanceOutput(@JsonProperty("error") String[] error, @JsonProperty("result") GetBalance result){
        super(result, error);

    }
}
