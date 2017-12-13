package co.codingnomads.kraken.model.account.response;

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenClosedOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetClosedOrdersOutput extends OutputWrapper<GetClosedOrdersOutput.KrakenClosedOrders> {

    /**
     *
     * @param error
     * @param result
     */
    public GetClosedOrdersOutput(@JsonProperty("error") String[] error,
                                 @JsonProperty("result") KrakenClosedOrders result) {
        super(result, error);
    }

    public static class KrakenClosedOrders {

        private final Map<String, KrakenClosedOrder> orders;
        private final int count;

        public KrakenClosedOrders(@JsonProperty("closed") Map<String, KrakenClosedOrder> orders, int count) {

            this.orders = orders;
            this.count = count;
        }

        public Map<String, KrakenClosedOrder> getOrders() {

            return orders;
        }

        public int getCount() {
            return count;
        }
    }
}
