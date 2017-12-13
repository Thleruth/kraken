package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.KrakenClosedOrder;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrder;
import co.codingnomads.kraken.model.account.request.GetClosedOrdersRequestBody;
import co.codingnomads.kraken.model.account.request.GetOpenOrdersRequestBody;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import co.codingnomads.kraken.model.trade.pojo.KrakenCancelOpenOrder;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

import java.util.HashMap;
import java.util.Iterator;
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
     * Method for the Get Recent Spread Data API call. Returns a Map containing Strings and highest level POJO
     * corresponding to call's output (KrakenSpread).
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params
     * @return Map<String, KrakenSpread>
     * @throws KrakenException
     */
    public Map<String, KrakenSpread> getRecentSpreadData(HashMap<String, String> params) throws KrakenException{
        // Assign specific call enum.
        KrakenRequestEnum recentSpreadDataEnum = KrakenRequestEnum.GETRECENTSPREADDATA;
        // Update endpoint to add query parameters
        recentSpreadDataEnum.updateEndpoint(createQueryParams(params));
        // Call the callAPI method, pass in enum type, null request body (no request body for public get calls),
        // and authentication.
        OutputWrapper getRecentSpreadData = handler.callAPI(recentSpreadDataEnum,null, authentication);
        // If an error is received throw exception
        if (getRecentSpreadData.getError().length > 0){
            throw new KrakenException(getRecentSpreadData.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenSpread("result") Map
            Map<String, KrakenSpread> results = (Map<String, KrakenSpread>) getRecentSpreadData.getResult();
            // If no results are retrieved throw exception.
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

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

    public Map<String, KrakenCancelOpenOrder> cancelOpenOrder(HashMap<String, String> params) throws KrakenException{

        KrakenRequestEnum cancelOrderTestEnum = KrakenRequestEnum.CANCELOPENORDERS;

        cancelOrderTestEnum.updateEndpoint(createQueryParams(params));
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

    // Need to write this so that the method takes parameters which are passed to the RequestBody
    public Map<String, KrakenClosedOrder> getClosedOrder() throws KrakenException{

        KrakenRequestEnum closedOrderEnum = KrakenRequestEnum.GETCLOSEDORDERS;

        GetClosedOrdersRequestBody getclosedOrdersRequestBody = new GetClosedOrdersRequestBody();

        OutputWrapper getClosedOrder = handler.callAPI(closedOrderEnum, getclosedOrdersRequestBody, authentication);

        if (getClosedOrder.getError().length > 0){
            throw new KrakenException(getClosedOrder.getError(), "General exception");
        } else {
            Map<String, KrakenClosedOrder> results = (Map<String, KrakenClosedOrder>) getClosedOrder.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    public Map<String, KrakenOpenOrder> getOpenOrder() throws KrakenException{

        KrakenRequestEnum openOrderEnum = KrakenRequestEnum.GETOPENORDERS;
        //openOrderEnum.updateEndpoint("?trades=false" );  // this setup returns invalid arguments

        GetOpenOrdersRequestBody getOpenOrdersRequestBody = new GetOpenOrdersRequestBody();

        //openOrderEnum.updateEndpoint(getOpenOrdersRequestBody.signPostParam());

        OutputWrapper getOpenOrder = handler.callAPI(openOrderEnum, getOpenOrdersRequestBody, authentication);

        if (getOpenOrder.getError().length > 0){
            throw new KrakenException(getOpenOrder.getError(), "General exception");
        } else {
            Map<String, KrakenOpenOrder> results = (Map<String, KrakenOpenOrder>) getOpenOrder.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    public String createQueryParams(HashMap<String, String> params){
        StringBuilder sb = new StringBuilder();
        Iterator it = params.entrySet().iterator();
        sb.append("?");
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sb.append(pair.getKey() + "=" + pair.getValue());
        }
        return sb.toString();
    }
}
