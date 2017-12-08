package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.response.pojo.KrakenCancelOpenOrders;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Thomas Leruth on 12/7/17
 */

public class CancelOpenOrdersOutput extends OutputWrapper<KrakenCancelOpenOrders> {

    public CancelOpenOrdersOutput(@JsonProperty("error") String[] error, @JsonProperty("result") KrakenCancelOpenOrders result){
        super(result, error);
    }
}
