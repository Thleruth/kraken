package co.codingnomads.kraken.model.trade.response;

/*
created by PopoPenguin on 12/8/17
*/


import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.trade.pojos.QueryTradesInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class QueryTradesInfoOutput extends OutputWrapper<Map<String, QueryTradesInfo>> {

    public QueryTradesInfoOutput(@JsonProperty("error") String[] error, @JsonProperty("result") Map<String, QueryTradesInfo> result) {
        super(result, error);
    }

}
