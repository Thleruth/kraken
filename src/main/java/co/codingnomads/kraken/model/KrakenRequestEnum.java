package co.codingnomads.kraken.model;

import co.codingnomads.kraken.model.account.response.GetAccountBalanceOutput;
import co.codingnomads.kraken.model.account.response.GetTradeBalanceOutput;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.model.market.response.GetServerTimeOutput;
import co.codingnomads.kraken.model.trade.response.CancelOpenOrdersOutput;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public enum KrakenRequestEnum {

    GETSERVERTIME("/0/public/Time", HttpMethod.GET, GetServerTimeOutput.class),
//    GETASSETINFO("/0/public/Assets", HttpMethod.GET),
//    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", HttpMethod.GET),
//    GETTICKERINFORMATION("/0/public/Ticker?pair=XBTUSD", HttpMethod.GET, new ParameterizedTypeReference<GetTickerInformationOutput>(){}),
//    GETOHLCDATA("/0/public/OHLC", HttpMethod.GET),
    GETORDERBOOK("/0/public/Depth?pair=XBTUSD", HttpMethod.GET, GetOrderBookOutput.class),
//    GETRECENTRADES("/0/public/Trades", HttpMethod.GET),
//    GETRECENTSPREADDATA("/0/public/Spread", HttpMethod.GET),
    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST, GetTradeBalanceOutput.class),
    GETACCOUNTBALANCE("/0/private/Balance",HttpMethod.POST, GetAccountBalanceOutput.class),
//    GETOPENORDERS("/0/private/OpenOrders", HttpMethod.POST),
//    GETCLOSEDORDERS("/0/private/ClosedOrders", HttpMethod.POST),
//    QUERYORDERINFO("/0/private/QueryOrders", HttpMethod.POST),
//    GETTRADESHISTORY("/0/private/TradesHistory", HttpMethod.POST),
//    QUERYTRADESINFO("/0/private/QueryTrades", HttpMethod.POST),
//    GETOPENPOSITIONS("/0/private/OpenPositions", HttpMethod.POST),
//    GETLEDGERSINFO("/0/private/Ledgers", HttpMethod.POST),
//    QUERYLEDGERS("/0/private/QueryLedgers", HttpMethod.POST),
//    GETTRADEVOLUME("/0/private/TradesVolume", HttpMethod.POST),
//    ADDSTRANDARDORDERS("/0/private/AddOrder", HttpMethod.POST),
    CANCELOPENORDERS("/0/private/CancelOrder", HttpMethod.POST, CancelOpenOrdersOutput.class);

    private final String endPoint;
    private final HttpMethod httpMethod;
    private final Class outputClass;
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

    KrakenRequestEnum(String endPoint, HttpMethod httpMethod, Class outputClass) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
        this.outputClass = outputClass;
        fullURL = domain + endPoint;
    }

}


