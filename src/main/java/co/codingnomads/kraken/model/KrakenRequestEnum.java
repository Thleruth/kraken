package co.codingnomads.kraken.model;

import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public enum KrakenRequestEnum {


    GETSERVERTIME("/0/public/Time", HttpMethod.GET,  1),
    GETASSETINFO("/0/public/Assets", HttpMethod.GET, 1),
    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", HttpMethod.GET, 1),
    GETTICKERINFORMATION("/0/public/Ticker?pair=XBTEUR", HttpMethod.GET, 1),
    GETOHLCDATA("/0/public/OHLC", HttpMethod.GET, 1),
    GETORDERBOOK("/0/public/Depth?pair=XBTUSD", HttpMethod.GET, 1),
    GETRECENTRADES("/0/public/Trades?pair=XBTUSD", HttpMethod.GET, 1),
    GETRECENTSPREADDATA("/0/public/Spread", HttpMethod.GET, 1),
    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST, 1),
    GETACCOUNTBALANCE("/0/private/Balance", HttpMethod.POST, 1),
    GETOPENORDERS("/0/private/OpenOrders", HttpMethod.POST, 1),
    GETCLOSEDORDERS("/0/private/ClosedOrders", HttpMethod.POST, 1),
    QUERYORDERINFO("/0/private/QueryOrders", HttpMethod.POST, 1),
    GETTRADESHISTORY("/0/private/TradesHistory", HttpMethod.POST, 2),
    QUERYTRADESINFO("/0/private/QueryTrades", HttpMethod.POST, 1),
    GETOPENPOSITIONS("/0/private/OpenPositions", HttpMethod.POST, 1),
    GETLEDGERSINFO("/0/private/Ledgers", HttpMethod.POST, 2),
    QUERYLEDGERS("/0/private/QueryLedgers", HttpMethod.POST, 2),
    GETTRADEVOLUME("/0/private/TradesVolume", HttpMethod.POST, 1),
    ADDSTRANDARDORDERS("/0/private/AddOrder", HttpMethod.POST, 0),
    CANCELOPENORDERS("/0/private/CancelOrder", HttpMethod.POST, 0);

    private final String domain = "https://api.kraken.com";
    private final String endPoint;
    private final HttpMethod httpMethod;
    private final int callAmount;
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

    public int getCallAmount() {
        return callAmount;
    }

    KrakenRequestEnum(String endPoint, HttpMethod httpMethod, int callAmount) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
        this.callAmount = callAmount;
        fullURL = domain + endPoint;
    }
}


