package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.model.trade.pojo.KrakenCancelOpenOrder;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/30/17
 */

public class KrakenExchange {

    ApiAuthentication authentication;


    GenericRequestHandler handler =  new GenericRequestHandler();

    public KrakenExchange(String apiKey, String apiSecret, int tier) {
        authentication = new ApiAuthentication(apiKey, tier, apiSecret);
    }

    public ApiAuthentication getApiAuthentication() {
        return authentication;
    }

    //todo one method for each potential KrakenRequest enum item (via the CallAPI)


    /**
     *
     * @param pair
     * @return
     * @throws KrakenException
     */

    // pair required, count optional
    public Map<String, KrakenOrderBook> getOrderBook(String pair, String count) throws KrakenException{

        KrakenRequestEnum test = KrakenRequestEnum.GETORDERBOOK;
        // can make a method to get queryParams
        test.updateEndpoint("?pair=" + pair);// + "&count=" + count);

        OutputWrapper orderBook = handler.callAPI(test,null, authentication);

        if (orderBook.getError().length > 0){
            throw new KrakenException(orderBook.getError(), "General exception");
        } else {
            Map<String, KrakenOrderBook> results = (Map<String, KrakenOrderBook>) orderBook.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    public Map<String, KrakenCancelOpenOrder> cancelOpenOrder(String txid) throws KrakenException{

        KrakenRequestEnum cancelOrderTestEnum = KrakenRequestEnum.CANCELOPENORDERS;

        cancelOrderTestEnum.updateEndpoint("txid=" + txid);
        CancelOpenOrderRequestBody cancelOpenOrderRB = new CancelOpenOrderRequestBody("1");

        OutputWrapper cancelOrder = handler.callAPI(cancelOrderTestEnum, cancelOpenOrderRB, authentication);

        if (cancelOrder.getError().length > 0){
            throw new KrakenException(cancelOrder.getError(), "General exception");
        } else {
           Map<String, KrakenCancelOpenOrder> results = (Map<String, KrakenCancelOpenOrder>) cancelOrder.getResult();
           if (results.isEmpty()){
               throw new KrakenException("General exception, results are null");
           } else {
               return results;
           }
        }
    }
}
