package co.codingnomads.kraken.model;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class RequestBodyGeneric {

    public String nonce;

    public RequestBodyGeneric() {
        this.nonce = String.valueOf(System.currentTimeMillis());
    }

    public String getNonce() {
        return nonce;
    }

    public abstract String signPostParam();

    public abstract MultiValueMap<String, String> postParam();

}
