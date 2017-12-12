package co.codingnomads.kraken.model.market.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import co.codingnomads.kraken.model.market.pojo.KrakenSpreadData;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class GetSpreadDataOutput extends OutputWrapper<KrakenSpread> {

    public GetSpreadDataOutput(@JsonProperty("error") String[] error,
                               @JsonProperty("result") KrakenSpread result) {

        super(result, error);
    }


//    public static class KrakenSpreadList {
//
//        private final Map<String, KrakenSpreadData> orders;
//
//        public KrakenSpreadList(@JsonProperty("") Map<String, List<KrakenSpreadData>> orders) {
//
//            this.orders = orders;
//        }
//
//        public Map<String, KrakenSpreadData> getOrders() {
//
//            return orders;
//        }
//    }


}
