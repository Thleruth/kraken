package co.codingnomads.kraken.model;
import org.springframework.util.MultiValueMap;

public abstract class RequestBodyGeneric {

    public String nonce;

    public RequestBodyGeneric() {
        this.nonce = String.valueOf(System.currentTimeMillis());
    }

    public String getNonce() {
        return nonce;
    }

    @Override
    public String toString() {
        return "nonce=" + nonce;
    }

    public abstract String signPostParam();
    public abstract MultiValueMap<String, String> postParam();
}

