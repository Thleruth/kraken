package co.codingnomads.kraken.model;

import co.codingnomads.kraken.model.market.response.GetOpenPositionsOutput;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.model.market.response.GetServerTimeOutput;
import co.codingnomads.kraken.model.market.response.GetTradableAssetPairsOutput;
import co.codingnomads.kraken.model.trade.response.QueryTradesInfoOutput;
import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public enum KrakenRequestEnum {

    GETSERVERTIME("/0/public/Time", HttpMethod.GET, 1, GetServerTimeOutput.class),
//    GETASSETINFO("/0/public/Assets", HttpMethod.GET, 1, GetServerTimeOutput.class,),
    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", HttpMethod.GET, 1, GetTradableAssetPairsOutput.class),
//    GETTICKERINFORMATION("/0/public/Ticker?pair=XBTEUR", HttpMethod.GET, 1,),
//    GETOHLCDATA("/0/public/OHLC", HttpMethod.GET, 1),
    GETORDERBOOK("/0/public/Depth?pair=XBTUSD", HttpMethod.GET, 1, GetOrderBookOutput.class),
//    GETRECENTTRADES("/0/public/Trades?pair=XBTUSD", HttpMethod.GET, 1,),
//    GETRECENTSPREADDATA("/0/public/Spread", HttpMethod.GET, 1,),
//    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST, 1),
//    GETACCOUNTBALANCE("/0/private/Balance", HttpMethod.POST, 1),
//    GETOPENORDERS("/0/private/OpenOrders", HttpMethod.POST, 1),
//    GETCLOSEDORDERS("/0/private/ClosedOrders", HttpMethod.POST, 1),
//    QUERYORDERINFO("/0/private/QueryOrders", HttpMethod.POST, 1),
//    GETTRADESHISTORY("/0/private/TradesHistory", HttpMethod.POST, 2),
    QUERYTRADESINFO("/0/private/QueryTrades", HttpMethod.POST, 1, QueryTradesInfoOutput.class),
    GETOPENPOSITIONS("/0/private/OpenPositions",HttpMethod.POST, 1,GetOpenPositionsOutput.class);
//    GETLEDGERSINFO("/0/private/Ledgers", HttpMethod.POST, 2),
//    QUERYLEDGERS("/0/private/QueryLedgersRequestBody", HttpMethod.POST, 2),
//    GETTRADEVOLUME("/0/private/TradesVolume", HttpMethod.POST, 1),
//    ADDSTRANDARDORDERS("/0/private/AddOrder", HttpMethod.POST, 0),
//    CANCELOPENORDERS("/0/private/CancelOrder", HttpMethod.POST, 0);

    private final String endPoint;
    private final HttpMethod httpMethod;
    private final Class outputClass;
    private final int callAmount;
    private final String fullURL;
    private final String domain = "https://api.kraken.com";

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

    public Class getOutputClass() {
        return outputClass;
    }

    KrakenRequestEnum(String endPoint, HttpMethod httpMethod, int callAmount, Class outputClass) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
        this.callAmount = callAmount;
        this.outputClass = outputClass;
        this.fullURL = domain + endPoint;
    }

    public int getCallAmount() {
        return callAmount;
    }

}


