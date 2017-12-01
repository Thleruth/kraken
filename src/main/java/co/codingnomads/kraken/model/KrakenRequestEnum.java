package co.codingnomads.kraken.model;

import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public enum KrakenRequestEnum {
    GETSERVERTIME("/0/public/Time", HttpMethod.GET),
    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST),
    GETACCOUNTBALANCE("/0/private/Balance", HttpMethod.POST),
    GETTRADEHISTORY("/0/private/TradesHistory", HttpMethod.POST);

    private final String domain = "https://api.kraken.com";
    private final String endPoint;
    private final HttpMethod httpMethod;
    private final String fullURL;

    public String getEndPoint() {
        return endPoint;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getDomain() {
        return domain;
    }

    public String getFullURL() {
        return fullURL;
    }

    KrakenRequestEnum(String endPoint, HttpMethod httpMethod) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
        fullURL = domain + endPoint;
    }

}


