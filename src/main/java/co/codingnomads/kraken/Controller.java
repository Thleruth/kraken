package co.codingnomads.kraken;
import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnkownException;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws KrakenException {

        //so far not used as we call method directly, will later call method on that
        // todo ryan: Correct my thinking but later we could call within the exchange getters of
        // of the apiAuthentication and thus getting the elements no (no need to pass in as Param)?
        // just for security purpose and we could raise the access level of the ApiAuthentication
        KrakenExchange exchange = new KrakenExchange(

                //"Insert API-Key",
                "DF5FK19pKy7kROX0VCTNEtlOM0cECxfjOukobPyds6wV84mpth8XCkzP",
                //"Insert API-Secret",
                "WDSFe2oivvzxBvvyHSrOLbLjL6Vous0wBkEfgGOf8CCQAmZZfERqNoDZ9NZUGbpada1X9wt5e3yyIxpvRieb5A==",
                3);

        GenericRequestHandler handler = new GenericRequestHandler();
        
        RequestBodyGeneric a = null;

        OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, a, exchange.getApiAuthentication());

        System.out.println(result.toString());

        // Meghan testing
        try {
            Map<String, KrakenOrderBook> orderBookMap = exchange.getOrderBook("XBTUSD", "0");
            System.out.println(orderBookMap.size());
        } catch (KrakenException e){
            System.out.println(e.toString());
        }
    }
}
