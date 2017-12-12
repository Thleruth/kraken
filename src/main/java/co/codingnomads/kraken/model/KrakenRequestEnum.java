package co.codingnomads.kraken.model;

import co.codingnomads.kraken.model.market.response.GetTradeVolumeOutput;
import co.codingnomads.kraken.model.account.response.*;
import co.codingnomads.kraken.model.market.response.*;
import co.codingnomads.kraken.model.trade.response.*;

import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public enum KrakenRequestEnum {

    GETSERVERTIME("/0/public/Time", HttpMethod.GET, 0, GetServerTimeOutput.class),
//    GETASSETINFO("/0/public/Assets", HttpMethod.GET, 0, GetServerTimeOutput.class,),
    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", HttpMethod.GET, 0, GetTradableAssetPairsOutput.class),
    GETTICKERINFORMATION("/0/public/Ticker", HttpMethod.GET, 0, GetTickerInformationOutput.class),
//    GETOHLCDATA("/0/public/OHLC", HttpMethod.GET, 0),
    GETORDERBOOK("/0/public/Depth", HttpMethod.GET, 0, GetOrderBookOutput.class),
    GETRECENTTRADES("/0/public/Trades?pair=XBTUSD", HttpMethod.GET, 0, GetRecentTradesOutput.class),
//    GETRECENTSPREADDATA("/0/public/Spread", HttpMethod.GET, 0,),
    GETACCOUNTBALANCE("/0/private/Balance", HttpMethod.POST, 1, GetAccountBalanceOutput.class),
    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST, 1, GetTradeBalanceOutput.class),
    GETOPENORDERS("/0/private/OpenOrders", HttpMethod.POST, 1, GetOpenOrdersOutput.class),
    GETCLOSEDORDERS("/0/private/ClosedOrders", HttpMethod.POST, 1, GetClosedOrdersOutput.class),
//    QUERYORDERINFO("/0/private/QueryOrders", HttpMethod.POST, 1),
//    GETTRADESHISTORY("/0/private/TradesHistory", HttpMethod.POST, 2),
    QUERYTRADESINFO("/0/private/QueryTrades", HttpMethod.POST, 1, QueryTradesInfoOutput.class),
    GETOPENPOSITIONS("/0/private/OpenPositions",HttpMethod.POST, 1,GetOpenPositionsOutput.class),
//    GETLEDGERSINFO("/0/private/Ledgers", HttpMethod.POST, 2),
//    QUERYLEDGERS("/0/private/QueryLedgersRequestBody", HttpMethod.POST, 2),
    GETTRADEVOLUME("/0/private/TradeVolume", HttpMethod.POST, 1, GetTradeVolumeOutput.class),
    ADDSTRANDARDORDERS("/0/private/AddOrder", HttpMethod.POST, 0, AddStandardOrderOutput.class),
    CANCELOPENORDERS("/0/private/CancelOrder",HttpMethod.POST, 0,CancelOpenOrderOutput.class);

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


