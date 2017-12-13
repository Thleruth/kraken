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
 * Contains methods for all Kraken Exchange API calls and to set call query parameters.
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
     * Method for the Get Recent Spread Data API call. See <a href="https://www.kraken.com/help/api#get-recent-spread-data">https://www.kraken.com/help/api#get-recent-spread-data</a>
     * Returns a Map containing key(pair_name), value(KrakenSpread) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - URL query parameters
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
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }


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

    /**
     * Method for the Get Closed Orders API call. See <a href="https://www.kraken.com/help/api#get-closed-orders">https://www.kraken.com/help/api#get-closed-orders</a>
     * Returns a Map containing key(pair_name), value(KrakenClosedOrder) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - URL query parameters
     * @return Map<String, KrakenClosedOrder> - URL query parameters
     * @throws KrakenException
     */
    public Map<String, KrakenClosedOrder> getClosedOrder(HashMap<String, String> params) throws KrakenException{
        // Assign specific call enum.
        KrakenRequestEnum closedOrderEnum = KrakenRequestEnum.GETCLOSEDORDERS;
        // Update endpoint to add query parameters
        closedOrderEnum.updateEndpoint(createQueryParams(params));
        // Create instance of GetOpenOrdersRequestBody for the handler
        GetClosedOrdersRequestBody getclosedOrdersRequestBody = new GetClosedOrdersRequestBody();
        // Call the callAPI method, pass in enum type, request body (required for private calls), authentication.
        OutputWrapper getClosedOrder = handler.callAPI(closedOrderEnum, getclosedOrdersRequestBody, authentication);
        // If an error is received throw exception
        if (getClosedOrder.getError().length > 0){
            throw new KrakenException(getClosedOrder.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenSpread("result") Map
            Map<String, KrakenClosedOrder> results = (Map<String, KrakenClosedOrder>) getClosedOrder.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method for the Get Open Orders API call. See <a href="https://www.kraken.com/help/api#get-open-orders">https://www.kraken.com/help/api#get-open-orders</a>
     * Returns a Map containing key(pair_name), value(KrakenOpenOrder) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - URL query parameters
     * @return Map<String, KrakenOpenOrder>
     * @throws KrakenException
     */
    public Map<String, KrakenOpenOrder> getOpenOrder(HashMap<String, String> params) throws KrakenException{
        // Assign specific call enum.
        KrakenRequestEnum openOrderEnum = KrakenRequestEnum.GETOPENORDERS;
        // Update endpoint to add query parameters
        openOrderEnum.updateEndpoint(createQueryParams(params));
        // Create instance of GetOpenOrdersRequestBody for the handler
        GetOpenOrdersRequestBody getOpenOrdersRequestBody = new GetOpenOrdersRequestBody();
        // Call the callAPI method, pass in enum type, request body (required for private calls), authentication.
        OutputWrapper getOpenOrder = handler.callAPI(openOrderEnum, getOpenOrdersRequestBody, authentication);
        // If an error is received throw exception
        if (getOpenOrder.getError().length > 0){
            throw new KrakenException(getOpenOrder.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenSpread("result") Map
            Map<String, KrakenOpenOrder> results = (Map<String, KrakenOpenOrder>) getOpenOrder.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * For calls that include query parameters. Takes a String key - String value HashMap parameter.
     * Builds a string beginning with "?" followed by the key + value for all params passed in.
     * String is returned and added to the end of the URL endpoint in API call methods above that use
     * query params.
     * @param params - map of query parameter names and values
     * @return String - formatted url query parameters
     */
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