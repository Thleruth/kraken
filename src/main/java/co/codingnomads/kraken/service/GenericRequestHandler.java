package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.util.TempConstant;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GenericRequestHandler {

    // takes in the KrakenRequestEnum and request body and returns a json object
    public KrakenBalanceResult callAPI(KrakenRequestEnum krakenRequest, GetBalanceRequestBody requestBody)
            throws NullPointerException {

        // Method to set correctly the headers if Post or Get
        HttpHeaders headers = getHtppHeaders(krakenRequest, requestBody);

        //the entity with the body and the headers
        HttpEntity<KrakenBalanceResult> entity = new HttpEntity(requestBody, headers);


        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();
        // Not sure about this, can't simply use JSON one?
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        // get the correct Response Wrapper (with the correct generic result)
        ParameterizedTypeReference parameterizedTypeReference =
                outputPojoClassSelector(krakenRequest.name());


        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", String.valueOf(requestBody.getNonce()));



        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

        body.add("nonce", requestBody.getNonce());

// Note the body object as first parameter!
        HttpEntity<?> httpEntity = new HttpEntity<Object>(body, headers);

        // let the restTemplate work his magic
        // not working so far with POST method, the result in the wrapper is null, and nothing is added to the OutputWrapper
        // I have a feeling the issue is with the restTemplate
        ResponseEntity response = restTemplate.exchange(
                "https://api.kraken.com/0/private/Balance",
                HttpMethod.POST,
                requestEntity,
                KrakenBalanceResult.class);

//        ResponseEntity response3 = restTemplate.exchange(
//                "https://api.kraken.com/0/private/Balance",
//                HttpMethod.POST,
//                requestEntity,
//                KrakenBalanceResult.class);

//        ResponseEntity response2 = restTemplate.postForEntity(
//                "https://api.kraken.com/0/private/Balance",
//                httpEntity,
//                KrakenBalanceResult.class);

        System.out.println(response);
        // can make a method to check this outside this method
//        try {
//            if (isSuccessful(response.getStatusCode())) {
//                return (KrakenBalanceResult) response;
//            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
//        } catch (RestClientException e) {
//            throw e;
//        }
        return null;
    }

    public HttpHeaders getHtppHeaders(KrakenRequestEnum krakenRequest, GetBalanceRequestBody requestBody) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        if (krakenRequest.getHttpMethod().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            headers.set("API-Key", TempConstant.ApiKey);
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.toString(), TempConstant.ApiSecret, krakenRequest.getEndPoint()));
            //headers.set("User-Agent", "github.nyg");
        }
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
            case "GETACCOUNTBALANCE":
                return new ParameterizedTypeReference<GetBalanceOutput>(){};
            case "GETTRADEBALANCE":
                return new ParameterizedTypeReference<OutputWrapper<GetTradeBalanceOutput>>(){};
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