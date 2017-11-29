package co.codingnomads.kraken.model;

import org.springframework.http.HttpMethod;

public class GetClosedOrders extends KrakenRequestGeneric {
    /**
     * Created by Meghan Boyce on 11/29/17
     */

    final private static String ENDPOINT = "/0/private/ClosedOrders";
    final private static HttpMethod REQUESTTYPE = HttpMethod.POST;

    public GetClosedOrders(String endPoint, HttpMethod requestType) {
        super(endPoint, requestType);
    }

    public static String getENDPOINT() {
        return ENDPOINT;
    }

    public static HttpMethod getREQUESTTYPE() {
        return REQUESTTYPE;
    }
}
