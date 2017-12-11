package co.codingnomads.kraken;
import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnkownException;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.model.trade.pojo.KrakenCancelOpenOrder;
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

                "",
                "==",
                3);

        GenericRequestHandler handler = new GenericRequestHandler();
        
        RequestBodyGeneric a = null;

        OutputWrapper result = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, a, exchange.getApiAuthentication());

        System.out.println(result.toString());

        // Meghan testing
//        try {
//            Map<String, KrakenOrderBook> orderBookMap = exchange.getOrderBook("XBTUSD", "0");
//            System.out.println(orderBookMap.size());
//        } catch (KrakenException e){
//            System.out.println(e.toString());
//        }

        try {
            Map<String, KrakenCancelOpenOrder> cancelOrderMap = exchange.cancelOpenOrder("1");
            System.out.println(cancelOrderMap.size());
        } catch (KrakenException e){
            System.out.println(e.toString());
        }
    }
}
