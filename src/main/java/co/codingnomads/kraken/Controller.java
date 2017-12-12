package co.codingnomads.kraken;
import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnkownException;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.util.MultiValueMap;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException, RateLimitException, UnkownException {



        //so far not used as we call method directly, will later call method on that
        // todo ryan: Correct my thinking but later we could call within the exchange getters of
        // of the apiAuthentication and thus getting the elements no (no need to pass in as Param)?
        // just for security purpose and we could raise the access level of the ApiAuthentication
        KrakenExchange exchange = new KrakenExchange(
                "RHjkEcaWRSEOYmOvfQSfXrzYeB1ZFJoX/B9ewO0cpkMPnI74uMx8AGF4",
                "qjcKcR6o37vv56BPUEw3FPPpiOvBvjVO0JQpC0bfEUV/bNkYFNGDya9VtFuKDJwrQ4PBAgMSQkKVC+QHxiJ/PA==",
                4);

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

//        OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, a, exchange.getApiAuthentication());

//        System.out.println(result.toString());

        OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETTRADEVOLUME, a, exchange.getApiAuthentication());
        System.out.println(result.toString());
    }

}
