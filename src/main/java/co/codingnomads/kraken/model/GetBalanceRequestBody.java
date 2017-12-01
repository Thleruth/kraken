package co.codingnomads.kraken.model;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class GetBalanceRequestBody extends RequestBodyGeneric {

    String nonce = System.currentTimeMillis() + "00000";

    public GetBalanceRequestBody() {
        super();
    }

    @Override
    public String toString() {
        return "nonce=" + nonce;
    }

//    @Override
    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}
