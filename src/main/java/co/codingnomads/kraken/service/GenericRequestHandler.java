package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class GenericRequestHandler {

    // for now passing in KrakenExchange but later will be removed as KrakenExchange will call this method parametized
    public OutputWrapper callAPI(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody, ApiAuthentication apiAuthentication)
            throws NullPointerException {

        //callCounter  isunderRateLimit method here
        //only proceed is response is true
        //otherwise throw exception

        MultiValueMap<String, String> body;

        if (requestBody != null) {
            body = requestBody.postParam();
        } else {
            body = null;
        }

        // Method to set correctly the headers if Post or Get
        HttpHeaders headers = getHttpHeaders(krakenRequest, requestBody, apiAuthentication);

        //the entity with the body and the headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity response = restTemplate.exchange(
                krakenRequest.getFullURL(),
                krakenRequest.getHttpMethod(),
                entity,
                krakenRequest.getOutputClass());

        // can make a method to check this outside this method
        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputWrapper) response.getBody();
            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }
    }

    public HttpHeaders getHttpHeaders(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody, ApiAuthentication apiAuthentication){
        HttpHeaders headers = new HttpHeaders();

        if (krakenRequest.getHttpMethod().matches("POST")) {

            headers.set("API-Key", apiAuthentication.getApiKey());
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.signPostParam(), apiAuthentication.getSecret(), krakenRequest.getEndPoint()));
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
        else
            throw new RestClientException(status.getReasonPhrase());
    }
}