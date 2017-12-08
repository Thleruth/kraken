package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojos.KrakenClosedOrders;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetClosedOrdersOutput extends OutputWrapper<Map<String, KrakenClosedOrders>> {

    public GetClosedOrdersOutput(@JsonProperty("error") String[] error,
                                 @JsonProperty("result") Map<String, KrakenClosedOrders> result) {
        super(result, error);

    }



}
