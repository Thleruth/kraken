package co.codingnomads.kraken.model;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class GetBalanceRequestBody extends RequestBodyGeneric {

    public GetBalanceRequestBody() {
        super();
    }

    @Override
    public String toString() {
        return "nonce=" + nonce;
    }
}
