package co.codingnomads.kraken.service;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.util.TempConstant;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class GenericRequestHandler {

    // takes in the KrakenRequestEnum and request body and returns a json object
    public OutputWrapper callAPI(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody)
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

        System.out.println(entity);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();

        // let the restTemplate work his magic
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

    public HttpHeaders getHttpHeaders(KrakenRequestEnum krakenRequest, RequestBodyGeneric requestBody) {
        HttpHeaders headers = new HttpHeaders();

        if (krakenRequest.getHttpMethod().matches("POST")) {

            // not sure how the requestBody String should look like could be the source of invalid Key issue
            headers.set("API-Key", TempConstant.ApiKey);
            headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.signPostParam(), TempConstant.ApiSecret, krakenRequest.getEndPoint()));
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