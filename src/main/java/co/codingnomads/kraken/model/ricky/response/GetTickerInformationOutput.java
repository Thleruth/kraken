package co.codingnomads.kraken.model.ricky.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.ricky.GetTickerInformation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


/**
 * Created by Ricardo Roque
 * 1/Dec/2017
 */
public class GetTickerInformationOutput extends OutputWrapper<Map<String, GetTickerInformation>> {

    public GetTickerInformationOutput(@JsonProperty("error") String[] error, @JsonProperty("results") Map<String, GetTickerInformation> result){
        super(result, error);

    }

}
