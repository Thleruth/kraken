package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.util.TempConstant;
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

    private HttpStatus status;

    // takes in the KrakenRequestGeneric and request body and returns a json object
    // Not a bit fan of the first arg, could use a String somehow bound by the list of action
    public OutputGeneric callAPI(KrakenRequestGeneric krakenRequest, RequestBodyGeneric requestBody)
            throws NullPointerException {

        Class outputClass = outputPojoClassSelector(krakenRequest.getClass().getSimpleName());

        // should put that in a different package to downsize this
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("API-Key", TempConstant.ApiKey);

        if (krakenRequest.getRequestType().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            // To test, implement a GET method and see it works
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.toString() + requestBody.getNonce(), TempConstant.ApiSecret, krakenRequest.getEndPoint()));
        }

        HttpEntity entity = new HttpEntity(requestBody, headers);

        // need an Autowired version of it
        RestTemplate restTemplate = new RestTemplate();

        // Not sure about this, can't simply use JSON one?
        // I guess we could also get that outside
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        String url = krakenRequest.getDOMAIN().concat(krakenRequest.getEndPoint());

        ResponseEntity response = restTemplate.exchange(url, krakenRequest.getRequestType(),
                entity, outputClass);

        // can make a method to check this outside this method
        System.out.println(response);
        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputGeneric) response.getBody();
            } else throw new RestClientException(status.getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }

    }

    // need to go somewhere else
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
//                return new GetServerTimeOutput();
//                break;
//            case "GetAssetInfo":
//                return new GetAssetInfoOutput();
//                break;
//            case "GetTradableAssetPairs":
//                return new GetTradableAssetPairsOutput();
//                break;
//            case "GetTickerInformation":
//                return new GetTickerInformationOutput();
//                break;
//            case "GetOHLCData":
//                return new GetOHLCDataOutput();
//                break;
//            case "GetOrderBook":
//                return new GetOrderBookOutput();
//                break;
//            case "GetRecentTrades":
//                return new GetRecentTradesOutput();
//                break;
//            case "GetRecentSpreadData":
//                return new GetRecentSpreadDataOutput();
//                break;
//            case "GetAccountBalance":
//                return new GetAccountBalanceOutput();
//                break;

            case "GetTradeBalance":
                return GetTradeBalanceOutput.class;
//            case "GetOpenOrders":
//                return new GetOpenOrdersOutput();
//                break;
//            case "GetClosedOrders":
//                return new GetClosedOrdersOutput();
//                break;
//            case "QueryOrdersInfo":
//                return new QueryOrdersInfoOutput();
//                break;
//            case "GetTradesHistory":
//                return new GetTradesHistoryOutput();
//                break;
//            case "QueryTradesInfo":
//                return new QueryTradesInfoOutput();
//                break;
//            case "GetOpenPositions":
//                return new GetOpenPositionsOutput();
//                break;
//            case "GetLedgersInfo":
//                return new GetLedgersInfoOutput();
//                break;
//            case "QueryLedgers":
//                return new QueryLedgersOutput();
//                break;
//            case "GetTradeVolume":
//                return new GetTradeVolumeOutput();
//                break;
//            case "AddStandardOrder":
//                return new AddStandardOrderOutput();
//                break;
//            case "CancelOpenOrder":
//                return new CancelOpenOrderOutput();
//                break;
        }
        return null;
    }

}