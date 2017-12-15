package co.codingnomads.kraken.service;

import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnknownException;
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

    /**
     * A generic Request Handler being able to call all end points
     * @param krakenRequest An Enum containing the endpoint, http request type, the API allowance utilization, and
     *                     the response output call,
     * @param requestBody What is based into the call (for GET will be used to adapt the URL,
     *                    for POST will be the request body)
     * @param apiAuthentication The parameters to authenticate the call
     * @return An OutputWrapper With an error field and a result firled
     * @throws NullPointerException
     * @throws UnknownException
     * @throws RateLimitException
     */

    public OutputWrapper callAPI(KrakenRequestEnum krakenRequest,
                                 RequestBodyGeneric requestBody,
                                 ApiAuthentication apiAuthentication)
            throws NullPointerException, UnknownException, RateLimitException {

        MultiValueMap<String, String> body = null;
        HttpHeaders headers = null;

        // For post only do multiple things
        // 1) run the API rate limiter
        // 2) set the body
        // 3) set the headers
        if (krakenRequest.getHttpMethod().matches("POST")) {
            try {
                if (!CallCounter.isUnderRateLimit(apiAuthentication, krakenRequest)) {

                    throw new UnknownException("RateLimit Exception - callApi");

                }
            } catch (RateLimitException e) {
                e.printStackTrace();
                throw e;
            }
            body = requestBody.postParam();
            headers = getHttpPostHeaders(krakenRequest, requestBody, apiAuthentication);
        }

        // Set the full http entity using the body and headers
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // need an Autowired version of it but I am getting a null pointer issue
        RestTemplate restTemplate = new RestTemplate();

        // Map the response of the call to the getOutputClass
        ResponseEntity response = restTemplate.exchange(
                krakenRequest.getFullURL(),
                krakenRequest.getHttpMethod(),
                entity,
              krakenRequest.getOutputClass());
//              OutputWrapper.class);

        // check if it was a success and return the item if so
        try {
            if (isSuccessful(response.getStatusCode())) {
                return (OutputWrapper) response.getBody();
            } else throw new RestClientException(response.getStatusCode().getReasonPhrase());
        } catch (RestClientException e) {
            throw e;
        }
    }

    /**
     * Set the post headers
     * @param krakenRequest Needed for finding the endpoint
     * @param requestBody Needed as part of the API-Sign
     * @param apiAuthentication Needed for authentication
     * @return the valid headers
     */
    public HttpHeaders getHttpPostHeaders(KrakenRequestEnum krakenRequest,
                                          RequestBodyGeneric requestBody,
                                          ApiAuthentication apiAuthentication) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("API-Key", apiAuthentication.getApiKey());
        headers.set("API-Sign", KrakenSignature.ApiSignCreator(requestBody.getNonce(),
                    requestBody.signPostParam(), apiAuthentication.getSecret(), krakenRequest.getEndPoint()));

        return headers;
    }

    /**
     * Method made to check if the call was successful
     * @param status the returned status of the Http call
     * @return true if success
     * @throws RestClientException
     */
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