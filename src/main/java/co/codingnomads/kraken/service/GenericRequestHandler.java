package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetBalanceRequestBody;
import co.codingnomads.kraken.model.account.output.GetBalanceOutput;
import co.codingnomads.kraken.model.market.AssetPairName;
import co.codingnomads.kraken.model.market.output.GetServerTimeOutput;

import co.codingnomads.kraken.model.market.output.GetTradableAssetPairsOutput;
import co.codingnomads.kraken.model.account.output.GetTradeBalanceOutput;
import org.springframework.core.ParameterizedTypeReference;

import co.codingnomads.kraken.util.TempConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class GenericRequestHandler {

    // takes in the KrakenRequestEnum and request body and returns a json object
    public <T extends OutputWrapper> OutputWrapper callAPI(
            KrakenRequestEnum krakenRequest,
            GetBalanceRequestBody requestBody,
            Class<? extends OutputWrapper<T>> responseType)
            throws NullPointerException {

        MultiValueMap<String, String> body;

        if (requestBody != null) {
            body = requestBody.postParam();
        }
        else {
            body = null;
        }

        // Method to set correctly the headers if Post or Get
        HttpHeaders headers = getHttpHeaders(krakenRequest, requestBody);

        //the entity with the body and the headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();

        // get the correct Response Wrapper (with the correct generic result)
        ParameterizedTypeReference pojoClass = outputPojoClassSelector(krakenRequest.name());

        // let the restTemplate work his magic
//        ResponseEntity<GetTradableAssetPairsOutput> response = restTemplate.exchange(
//                krakenRequest.getFullURL(),
//                krakenRequest.getHttpMethod(),
//                entity,
//                GetTradableAssetPairsOutput.class);

        //ParameterizedTypeReference<Map<String, AssetPairName>> typeRef = new ParameterizedTypeReference<Map<String, AssetPairName>>() {};

        ResponseEntity response = restTemplate.exchange(
                krakenRequest.getFullURL(),
                krakenRequest.getHttpMethod(),
                entity,
                responseType);

        // can make a method to check this outside this method
        try {
            if (isSuccessful(response.getStatusCode())) {
                if (krakenRequest.getHttpMethod().matches("GET")) {
                    return (OutputWrapper) response.getBody();
                }
                return new OutputWrapper(mapToWrapper(response, responseType));

            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }
    }
    // I hate that I use Object I would love use pojoClass but I do not know how
    // to initiliaze an object with a variable holding a class
    // or with generic
    public Object mapToWrapper(ResponseEntity response, Class pojoClass) {

        Object map = ((OutputWrapper) response.getBody()).getResult();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(map,pojoClass);
    }

    public HttpHeaders getHttpHeaders(KrakenRequestEnum krakenRequest, GetBalanceRequestBody requestBody) {
        HttpHeaders headers = new HttpHeaders();

        if (krakenRequest.getHttpMethod().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            headers.set("API-Key", TempConstant.ApiKey);
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.toString(), TempConstant.ApiSecret, krakenRequest.getEndPoint()));
        }

        // headers.setContentType(MediaType.APPLICATION_JSON);

        return headers;
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

    public static ParameterizedTypeReference outputPojoClassSelector(String methodName) {
        switch (methodName) {
            case "GETSERVERTIME":
                return new ParameterizedTypeReference<OutputWrapper<GetServerTimeOutput>>(){};
//            case "GETASSETINFO":
//                return new ParameterizedTypeReference<OutputWrapper<GetAssetInfoOutput>>(){};
            case "GETTRADABLEASSETPAIRS":
                return new ParameterizedTypeReference<OutputWrapper<GetTradableAssetPairsOutput>>(){};
//            case "GETTICKERINFORMATION":
//               return new ParameterizedTypeReference<OutputWrapper<GetTickerInformationOutput>>(){};
//            case "GETOHLCDATA":
//                return new ParameterizedTypeReference<OutputWrapper<GetOHLCDataOutput>>(){};
//            case "GETORDERBOOK":
//                return new ParameterizedTypeReference<OutputWrapper<GetOrderBookOutput>>(){};
//            case "GETRECENTTRADES":
//                return new ParameterizedTypeReference<OutputWrapper<GetRecentTradesOutput>>(){};
//            case "GETRECENTSPREADDATA":
//                return new ParameterizedTypeReference<OutputWrapper<GetRecentSpreadDataOutput>>(){};
            case "GETACCOUNTBALANCE":
                return new ParameterizedTypeReference<OutputWrapper<GetBalanceOutput>>(){};
//            case "GETTRADEBALANCE":
//                return new ParameterizedTypeReference<OutputWrapper<GetTradeBalanceOutput>>(){};
//            case "GETOPENORDERS":
//                return new ParameterizedTypeReference<OutputWrapper<GetOpenOrdersOutput>>(){};
//            case "GETCLOSEDORDERS":
//                return new ParameterizedTypeReference<OutputWrapper<GetClosedOrdersOutput>>(){};
//            case "QUERYORDERINFO":
//                return new ParameterizedTypeReference<OutputWrapper<QueryOrderInfoOutput>>(){};
//            case "GETTRADESHISTORY":
//                return new ParameterizedTypeReference<OutputWrapper<GetTradeHistoryOutput>>(){};
//            case "QUERYTRADESINFO":
//                return new ParameterizedTypeReference<OutputWrapper<QueryTradesInfoOutput>>(){};
//            case "GETOPENPOSITIONS":
//                return new ParameterizedTypeReference<OutputWrapper<GetOpenPositionsOutput>>(){};
//            case "GETLEDGERSINFO":
//                return new ParameterizedTypeReference<OutputWrapper<GetLedgersInfoOutput>>(){};
//            case "QUERYLEDGERS":
//                return new ParameterizedTypeReference<OutputWrapper<GetQueryLedgersOutput>>(){};
//            case "GETTRADEVOLUME":
//                return new ParameterizedTypeReference<OutputWrapper<GetGetTradeVolumeOutput>>(){};
//            case "ADDSTRANDARDORDERS":
//               return new ParameterizedTypeReference<OutputWrapper<AddStandardOrdersOutput>>(){};
//            case "CANCELOPENORDERS":
//                return new ParameterizedTypeReference<OutputWrapper<CancelOpenOrdersOutput>>(){};
        }
        return null;
    }

}