package co.codingnomads.kraken.model;

public abstract class RequestBodyGeneric {

    protected String nonce;

    public RequestBodyGeneric() {
        this.nonce = String.valueOf(System.currentTimeMillis());
    }

    public String getNonce() {
        return nonce;
    }
}
