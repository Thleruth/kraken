package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenTradeVolume;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Map;

/**
 * @author Kevin Neag
 */

public class GetTradeVolumeOutput extends OutputWrapper<KrakenTradeVolume> {


    public GetTradeVolumeOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenTradeVolume result){
        super(result, error);
    }
}

