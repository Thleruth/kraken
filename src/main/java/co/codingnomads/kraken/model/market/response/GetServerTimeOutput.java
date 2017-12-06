package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojos.GetServerTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 11/29/17
 */
//working template for GET
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetServerTimeOutput extends OutputWrapper<GetServerTime> {


    public GetServerTimeOutput(@JsonProperty("error") String[] error, @JsonProperty("result") GetServerTime result){
        super(result, error);

    }
}
