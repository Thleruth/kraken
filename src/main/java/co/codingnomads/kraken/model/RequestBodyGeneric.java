package co.codingnomads.kraken.model;
import org.springframework.util.MultiValueMap;

public abstract class RequestBodyGeneric {

    public String nonce;

    /**
     * Constructor setting the nonce (will be called automatically within the child constructor)
     */
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

    /**
     * Abstract method to define in the child which will set the correct String for the the API-Sign method
     * @return String used for the API-Sign
     */
    public abstract String signPostParam();

    /**
     * Abstract method to define in the child which will set the correct parameters for the Request Body of the call
     * @return Map for the HTTP request body
     */
    public abstract MultiValueMap<String, String> postParam();
}

