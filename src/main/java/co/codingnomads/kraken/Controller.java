package co.codingnomads.kraken;
import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnknownException;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

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
                "Insert Key",
                "Insert Secret",
                4);

        GenericRequestHandler handler = new GenericRequestHandler();
        
        RequestBodyGeneric a = null;

        OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, a, exchange.getApiAuthentication());

        System.out.println(result.toString());

        System.out.println("callAPI ending - " + Thread.currentThread().getName());

    }
}
