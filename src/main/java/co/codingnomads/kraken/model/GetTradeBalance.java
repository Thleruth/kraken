package model;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

public class GetTradeBalance extends KrakenRequestGeneric {

    final private static String ENDPOINT = "/0/private/TradeBalance";
    final private static HttpMethod REQUESTTYPE = HttpMethod.POST;

    public static String getENDPOINT() {
        return ENDPOINT;
    }

    public static HttpMethod getREQUESTTYPE() {
        return REQUESTTYPE;
    }
}
