package co.codingnomads.kraken.model.account.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class GetBalanceRequestBody extends RequestBodyGeneric {

    public GetBalanceRequestBody() {
        super();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        return postParameters;
    }

}
