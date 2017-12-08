package co.codingnomads.kraken.model;

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
}
