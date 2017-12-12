package co.codingnomads.kraken;
import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnknownException;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.util.MultiValueMap;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException, RateLimitException, UnknownException {



        //so far not used as we call method directly, will later call method on that
        // todo ryan: Correct my thinking but later we could call within the exchange getters of
        // of the apiAuthentication and thus getting the elements no (no need to pass in as Param)?
        // just for security purpose and we could raise the access level of the ApiAuthentication
        KrakenExchange exchange = new KrakenExchange(
                "key",
                "your-secret",
                56);

        GenericRequestHandler handler = new GenericRequestHandler();
        
        RequestBodyGeneric a = new RequestBodyGeneric() {
            @Override
            public String signPostParam() {
                return null;
            }

            @Override
            public MultiValueMap<String, String> postParam() {
                return null;
            }
        };

       OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETTRADEVOLUME, a, exchange.getApiAuthentication());

        System.out.println(result.getResult());

        System.out.println("callAPI ending - " + Thread.currentThread().getName());

    }

}
