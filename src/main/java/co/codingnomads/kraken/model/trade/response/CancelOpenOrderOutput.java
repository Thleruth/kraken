package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenCancelOpenOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 12/7/17
 */

public class CancelOpenOrderOutput extends OutputWrapper<KrakenCancelOpenOrder> {

    public CancelOpenOrderOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenCancelOpenOrder result){
        super(result, error);
    }
}
