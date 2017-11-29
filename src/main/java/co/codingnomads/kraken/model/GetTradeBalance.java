package co.codingnomads.kraken.model;

import org.springframework.http.HttpMethod;

public class GetTradeBalance extends KrakenRequestGeneric {

    final private static String ENDPOINT = "/0/private/TradeBalance";
    final private static HttpMethod REQUESTTYPE = HttpMethod.POST;

    public static String getENDPOINT() {
        return ENDPOINT;
    }

    public static HttpMethod getREQUESTTYPE() {
        return REQUESTTYPE;
    }

    public GetTradeBalance() {
        super(ENDPOINT, REQUESTTYPE);
    }
}
