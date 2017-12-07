package co.codingnomads.kraken.model.account;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class GetAccountBalanceRequestBody extends RequestBodyGeneric {

    public GetAccountBalanceRequestBody() {
        super();
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        // for more: postParameters.add("InstanceVariableXName", "InstanceVariableXValueInString");
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        // for more: sb.append("&").append("InstanceVariableXName").append("InstanceVariableXValueInString")
        return sb.toString();
    }
}
