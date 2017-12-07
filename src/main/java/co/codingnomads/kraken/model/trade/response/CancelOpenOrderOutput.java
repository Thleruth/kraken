package co.codingnomads.kraken.model.trade.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojos.KrakenCancelOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelOpenOrdersOutput extends OutputWrapper<KrakenCancelOrder> {


}
