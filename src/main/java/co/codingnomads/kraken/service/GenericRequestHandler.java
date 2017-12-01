package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.output.*;
import co.codingnomads.kraken.model.market.output.GetServerTimeOutput;
import co.codingnomads.kraken.model.account.GetTradeBalanceOutput;
import co.codingnomads.kraken.model.trade.output.AddStandardOrdersOutput;
import co.codingnomads.kraken.util.TempConstant;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GenericRequestHandler {

    // takes in the KrakenRequestEnum and request body and returns a json object
    public OutputWrapper callAPI(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody)
            throws NullPointerException {

        // Method to set correctly the headers if Post or Get
        HttpHeaders headers = getHttpHeaders(krakenRequest, requestBody);

        //the entity with the body and the headers
        HttpEntity entity = new HttpEntity(requestBody, headers);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();
        // Not sure about this, can't simply use JSON one?
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        // get the correct Response Wrapper (with the correct generic result)
        ParameterizedTypeReference parameterizedTypeReference =
                outputPojoClassSelector(krakenRequest.name());

        // let the restTemplate work his magic
        // not working so far with POST method, the result in the wrapper is null, and nothing is added to the OutputWrapper
        // I have a feeling the issue is with the restTemplate
        ResponseEntity response = restTemplate.exchange(krakenRequest.getFullURL(), krakenRequest.getHttpMethod(),
                entity, parameterizedTypeReference);

        // can make a method to check this outside this method
        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputWrapper) response.getBody();
            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }

    }

    public HttpHeaders getHttpHeaders(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        if (krakenRequest.getHttpMethod().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            headers.set("API-Key", TempConstant.ApiKey);
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.toString(), TempConstant.ApiSecret, krakenRequest.getEndPoint()));
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
            case "GETASSETINFO":
                return new ParameterizedTypeReference<OutputWrapper<GetAssetInfoOutput>>(){};
            case "GETTRADABLEASSETPAIRS":
                return new ParameterizedTypeReference<OutputWrapper<GetTradableAssetPairsOutput>>(){};
            case "GETTICKERINFORMATION":
               return new ParameterizedTypeReference<OutputWrapper<GetTickerInformationOutput>>(){};
            case "GETOHLCDATA":
                return new ParameterizedTypeReference<OutputWrapper<GetOHLCDataOutput>>(){};
            case "GETORDERBOOK":
                return new ParameterizedTypeReference<OutputWrapper<GetOrderBookOutput>>(){};
            case "GETRECENTTRADES":
                return new ParameterizedTypeReference<OutputWrapper<GetRecentTradesOutput>>(){};
            case "GETRECENTSPREADDATA":
                return new ParameterizedTypeReference<OutputWrapper<GetRecentSpreadDataOutput>>(){};
            case "GETACCOUNTBALANCE":
                return new ParameterizedTypeReference<OutputWrapper<GetBalanceOutput>>(){};
            case "GETTRADEBALANCE":
                return new ParameterizedTypeReference<OutputWrapper<GetTradeBalanceOutput>>(){};
            case "GETOPENORDERS":
                return new ParameterizedTypeReference<OutputWrapper<GetOpenOrdersOutput>>(){};
            case "GETCLOSEDORDERS":
                return new ParameterizedTypeReference<OutputWrapper<GetClosedOrdersOutput>>(){};
            case "QUERYORDERINFO":
                return new ParameterizedTypeReference<OutputWrapper<QueryOrderInfoOutput>>(){};
            case "GETTRADESHISTORY":
                return new ParameterizedTypeReference<OutputWrapper<GetTradeHistoryOutput>>(){};
            case "QUERYTRADESINFO":
                return new ParameterizedTypeReference<OutputWrapper<QueryTradesInfoOutput>>(){};
            case "GETOPENPOSITIONS":
                return new ParameterizedTypeReference<OutputWrapper<GetOpenPositionsOutput>>(){};
            case "GETLEDGERSINFO":
                return new ParameterizedTypeReference<OutputWrapper<GetLedgersInfoOutput>>(){};
            case "QUERYLEDGERS":
                return new ParameterizedTypeReference<OutputWrapper<GetQueryLedgersOutput>>(){};
            case "GETTRADEVOLUME":
                return new ParameterizedTypeReference<OutputWrapper<GetGetTradeVolumeOutput>>(){};
            case "ADDSTRANDARDORDERS":
               return new ParameterizedTypeReference<OutputWrapper<AddStandardOrdersOutput>>(){};
            case "CANCELOPENORDERS":
                return new ParameterizedTypeReference<OutputWrapper<CancelOpenOrdersOutput>>(){};
        }
        return null;
    }

}