package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.*;
import co.codingnomads.kraken.model.account.request.*;
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

    /**
     * Method for Get Ledger Info API call. Returns the highest level POJO
     * corresponding to call's output (KrakenLedgersInfoResult).
     * Method requires a result offset in the GetLedgersInfoRequestBody to run.
     * This method is called in the controller.
     * @params int offset.
     * @return Map<String, KrakenLedgersInfo>
     * @throws KrakenException
     */

    public KrakenLedgersInfoResult getLedgersInfo(int ofs) throws KrakenException {

        KrakenRequestEnum ledgersInfoEnum = KrakenRequestEnum.GETLEDGERSINFO;

        GetLedgersInfoRequestBody getLedgersInfoRequestBody = new GetLedgersInfoRequestBody(ofs);

        OutputWrapper getLedgersInfo = handler.callAPI(ledgersInfoEnum, getLedgersInfoRequestBody, authentication);

        if (getLedgersInfo.getError().length > 0){
            throw new KrakenException(getLedgersInfo.getError(), "General exception");
        } else {
            KrakenLedgersInfoResult result = (KrakenLedgersInfoResult) getLedgersInfo.getResult();
            if (result.getLedgerMap().isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return result;
            }
        }
    }

    /**
     * Method for Query Ledgers API call. Returns a map containing a String and the POJO
     * corresponding to the call's output (KrakenLedgersInfo).
     * This method requires a Ledger ID in the QueryLEdgersRequestBody to run.
     * This method is called in the controller.
     * @params  String ledger Id (comma delimited list of ids)
     * @return Map<String, KrakenLedgersInfo>
     * @throws KrakenException
     */

    public Map<String, KrakenLedgersInfo> queryLedgers(String ledgerId) throws KrakenException {

        KrakenRequestEnum queryLedgersEnum = KrakenRequestEnum.QUERYLEDGERS;

        QueryLedgersRequestBody queryLedgersRequestBody = new QueryLedgersRequestBody(ledgerId);

        OutputWrapper queryLedgers = handler.callAPI(queryLedgersEnum, queryLedgersRequestBody, authentication);

        if (queryLedgers.getError().length > 0){
            throw new KrakenException(queryLedgers.getError(), "General exception");
        } else {
            Map<String, KrakenLedgersInfo> results = (Map<String, KrakenLedgersInfo>) queryLedgers.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method for Get Trade Volume API call. returns the POJO
     * corresponding to the call's output (KrakenTradeVolume).
     * This method has the option to take in a list of specific asset pairs and a boolean for fee-info
     * in order to return the fee or fee_maker information.
     * This method is called in the controller.
     * @params String pairs, comma delimited list (optional), boolean fee-info (optional)
     * @return KrakenTradeVolume
     * @throws KrakenException
     */

    public KrakenTradeVolume getTradeVolume(String pairs, boolean feeInfo) throws KrakenException {

        KrakenRequestEnum getTradeVolumeEnum = KrakenRequestEnum.GETTRADEVOLUME;

        GetTradeVolumeRequestBody getTradeVolumeRequestBody = new GetTradeVolumeRequestBody(pairs,feeInfo);

        OutputWrapper getTradeVolume = handler.callAPI(getTradeVolumeEnum, getTradeVolumeRequestBody, authentication);

        if (getTradeVolume.getError().length > 0){
            throw new KrakenException(getTradeVolume.getError(), "General exception");
        } else {
            KrakenTradeVolume results = (KrakenTradeVolume) getTradeVolume.getResult();
            if (results.getCurrency().isEmpty()){
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
