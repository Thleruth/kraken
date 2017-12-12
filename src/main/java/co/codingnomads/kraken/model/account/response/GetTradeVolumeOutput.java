package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenTradeVolume;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Map;

/**
 * @author Kevin Neag
 */

public class GetTradeVolumeOutput extends OutputWrapper<Map<String, KrakenTradeVolume>> {


    public GetTradeVolumeOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, KrakenTradeVolume> result){
        super(result, error);
    }
}

