package model;

public abstract class RequestBodyGeneric {

    String nonce;

    public RequestBodyGeneric() {
        this.nonce = String.valueOf(System.currentTimeMillis());
    }

}
