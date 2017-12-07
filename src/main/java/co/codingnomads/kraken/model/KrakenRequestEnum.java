package co.codingnomads.kraken.model;

import co.codingnomads.kraken.model.account.output.GetAccountBalanceOutput;
import co.codingnomads.kraken.model.market.output.GetServerTimeOutput;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

/**
 * Created by Thomas Leruth on 11/29/17
 */


public enum KrakenRequestEnum {
    GETSERVERTIME("/0/public/Time", HttpMethod.GET, new ParameterizedTypeReference<OutputWrapper<GetServerTimeOutput>>(){}),
//    GETASSETINFO("/0/public/Assets", HttpMethod.GET),
//    GETTRADABLEASSETPAIRS("/0/public/AssetPairs", HttpMethod.GET),
//    GETTICKERINFORMATION("/0/public/Ticker", HttpMethod.GET),
//    GETOHLCDATA("/0/public/OHLC", HttpMethod.GET),
//    GETORDERBOOK("/0/public/Depth", HttpMethod.GET),
//    GETRECENTRADES("/0/public/Trades", HttpMethod.GET),
//    GETRECENTSPREADDATA("/0/public/Spread", HttpMethod.GET),
//    GETTRADEBALANCE("/0/private/TradeBalance", HttpMethod.POST),
    GETACCOUNTBALANCE("/0/private/Balance", HttpMethod.POST, new ParameterizedTypeReference<OutputWrapper<GetAccountBalanceOutput>>(){});
//    GETTRADEHISTORY("/0/private/TradesHistory", HttpMethod.POST);


    private final String endPoint;
    private final HttpMethod httpMethod;
    private final ParameterizedTypeReference outputClass;
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

    public ParameterizedTypeReference getOutputClass() {
        return outputClass;
    }

    KrakenRequestEnum(String endPoint, HttpMethod httpMethod, ParameterizedTypeReference outputClass) {
        this.endPoint = endPoint;
        this.httpMethod = httpMethod;
        this.outputClass = outputClass;
        fullURL = domain + endPoint;
    }

}


