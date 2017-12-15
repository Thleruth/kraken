package co.codingnomads.kraken.model.trade.response;

/*
created by PopoPenguin on 12/8/17
*/

import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GetTradesHistoryOutput extends OutputWrapper<GetTradesHistoryOutput.KrakenTradeHistory> {


    public GetTradesHistoryOutput(@JsonProperty("result") KrakenTradeHistory result, @JsonProperty("error") String[] error) {

        super(result, error);
    }

    public static class KrakenTradeHistory {

        private final Map<String, KrakenTradeInfo> trades;
        private final int count;

        public KrakenTradeHistory(@JsonProperty("trades") Map<String, KrakenTradeInfo> trades, @JsonProperty ("count") int count) {

            this.trades = trades;
            this.count = count;
        }

        public Map<String, KrakenTradeInfo> getTrades() {

            return trades;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "KrakenTradeHistory{" +
                    "trades=" + trades +
                    ", count=" + count +
                    '}';
        }
    }


}
