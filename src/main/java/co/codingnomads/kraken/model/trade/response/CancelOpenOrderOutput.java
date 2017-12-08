package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojos.KrakenCancelOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class CancelOpenOrderOutput extends OutputWrapper<Map<String, KrakenCancelOrder>> {

    public CancelOpenOrderOutput(@JsonProperty("error") String[] error,
                                 @JsonProperty("result") Map<String, KrakenCancelOrder> result) {
        super(result, error);

    }

}
