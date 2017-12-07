package co.codingnomads.kraken.service;

import co.codingnomads.kraken.KrakenExchange;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.util.TempConstant;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class GenericRequestHandler {

    // for now passing in KrakenExchange but later will be removed as KrakenExchange will call this method parametized
    public OutputWrapper callAPI(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody, KrakenExchange exchange)
            throws NullPointerException {

        MultiValueMap<String, String> body;

        if (requestBody != null) {
            body = requestBody.postParam();
        }
        else {
            body = null;
        }

        // Method to set correctly the headers if Post or Get
        HttpHeaders headers = getHttpHeaders(krakenRequest, requestBody, exchange.getApiKey(), exchange.getApiSecret());

        //the entity with the body and the headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        System.out.println(entity);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();

        // let the restTemplate work his magic
        ResponseEntity response = restTemplate.exchange(
                krakenRequest.getFullURL(),
                krakenRequest.getHttpMethod(),
                entity,
                krakenRequest.getOutputClass());

        System.out.println(response);

        // can make a method to check this outside this method
        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputWrapper) response.getBody();
            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }
    }

    // for now passing
    public HttpHeaders getHttpHeaders(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody, String apiKey, String apiSecret) {
        HttpHeaders headers = new HttpHeaders();

        if (krakenRequest.getHttpMethod().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            headers.set("API-Key", apiKey);
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.signPostParam(), apiSecret, krakenRequest.getEndPoint()));
            System.out.println(requestBody.signPostParam());
            System.out.println(apiKey);
            System.out.println(apiSecret);
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

}