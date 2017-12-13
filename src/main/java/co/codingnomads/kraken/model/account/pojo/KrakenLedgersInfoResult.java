package co.codingnomads.kraken.model.account.pojo;

import co.codingnomads.kraken.model.account.pojo.KrakenLedgersInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author Kevin Neag
 */

public  class KrakenLedgersInfoResult {

    private Map<String, KrakenLedgersInfo> map;
    private int count;


    public KrakenLedgersInfoResult(Map<String, KrakenLedgersInfo> map) {

        this.map = map;
        this.count = map.size();
    }


    public KrakenLedgersInfoResult(@JsonProperty("ledger") Map<String, KrakenLedgersInfo> map, @JsonProperty("count") int count) {

        this.map = map;
        this.count = count;
    }

    public Map<String, KrakenLedgersInfo> getLedgerMap() {

        return map;
    }

    public int getCount() {

        return count;
    }
}