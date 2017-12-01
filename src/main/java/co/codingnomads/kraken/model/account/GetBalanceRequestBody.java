package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.RequestBodyGeneric;

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
