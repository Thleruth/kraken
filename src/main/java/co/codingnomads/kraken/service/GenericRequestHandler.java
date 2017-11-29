package com.kraken_api.kraken.service;

import model.GetTradeBalanceOutput;
import model.KrakenRequestGeneric;
import model.OutputGeneric;
import model.RequestBodyGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GenericRequestHandler {

    @Autowired
    private RestTemplate restTemplate;
    private HttpStatus status;

//    //empty body
//    public V callAPI(KrakenRequestGeneric krakenRequestGeneric) throws RestClientException {
//        ResponseEntity<V> obj = new ResponseEntity<V>(null);
//        return obj.getBody();
//    }

    //takes in the KrakenRequestGeneric and request body and returns a json object
    public OutputGeneric callAPI(KrakenRequestGeneric krakenRequestGeneric, RequestBodyGeneric requestBody) {

        //creates a new header for the api
        Header header = new Header();

        //checks to see if the api-key is a post method
        if (krakenRequestGeneric.getRequestType().toString() == "POST") {
        }

        Class output = outputPojoClassSelector(krakenRequestGeneric.getClass().getName());

        HttpEntity entity = new HttpEntity(requestBody, headers);

        // Not sure about this, can't simply use JSON one?
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = krakenRequestGeneric.getDOMAIN().concat(krakenRequestGeneric.getEndPoint());
        ResponseEntity response = restTemplate.exchange(url, krakenRequestGeneric.getRequestType(),
                entity, output);

        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputGeneric) response.getBody();
            } else throw new RestClientException(status.getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }
    }

    public boolean isSuccessful(HttpStatus status)
            throws RestClientException {
        if (status.is2xxSuccessful())
            return true;
        else if (status.is4xxClientError())
            throw new HttpClientErrorException(status);
        else if (status.is5xxServerError())
            throw new HttpServerErrorException(status);
        else throw new RestClientException(status.getReasonPhrase());
    }

    public static Class outputPojoClassSelector(String methodName) {
        switch (methodName) {
//            case "GetServerTime":
//                return new GetServerTimePojo();
//                break;
//            case "GetAssetInfo":
//                return new GetAssetInfoPojo();
//                break;
//            case "GetTradableAssetPairs":
//                return new GetTradableAssetPairsPojo();
//                break;
//            case "GetTickerInformation":
//                return new GetTickerInformationPojo();
//                break;
//            case "GetOHLCData":
//                return new GetOHLCDatapojo();
//                break;
//            case "GetOrderBook":
//                return new GetOrderBookPojo();
//                break;
//            case "GetRecentTrades":
//                return new GetRecentTradesPojo();
//                break;
//            case "GetRecentSpreadData":
//                return new GetRecentSpreadDataPojo();
//                break;
//            case "GetAccountBalance":
//                return new GetAccountBalancePojo();
//                break;

            //doing this one
            case "GetTradeBalance":
                return GetTradeBalanceOutput.class;
//            case "GetOpenOrders":
//                return new GetOpenOrdersPojo();
//                break;
//            case "GetClosedOrders":
//                return new GetClosedOrdersPojo();
//                break;
//            case "QueryOrdersInfo":
//                return new QueryOrdersInfoPojo();
//                break;
//            case "GetTradesHistory":
//                return new GetTradesHistroyPojo();
//                break;
//            case "QueryTradesInfo":
//                return new QueryTradesInfoPojo();
//                break;
//            case "GetOpenPositions":
//                return new GetOpenPositionsPojo();
//                break;
//            case "GetLedgersInfo":
//                return new GetLedgersInfoPojo();
//                break;
//            case "QueryLedgers":
//                return new QueryLedgersPojo();
//                break;
//            case "GetTradeVolume":
//                return new GetTradeVolume();
//                break;
//            case "AddStandardOrder":
//                return new AddStandardOrder();
//                break;
//            case "CancelOpenOrder":
//                return new CancelOpenOrder();
//                break;
        }
        return null;
    }

//    public RestTemplate getRestTemplate() {
//        return restTemplate;
//    }
//
//    public HttpStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(HttpStatus status) {
//        this.status = status;
//    }
}