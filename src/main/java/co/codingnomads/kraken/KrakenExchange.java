package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.account.pojo.*;
import co.codingnomads.kraken.model.account.request.*;
import co.codingnomads.kraken.model.account.pojo.KrakenClosedOrder;
import co.codingnomads.kraken.model.account.pojo.KrakenOpenOrder;
import co.codingnomads.kraken.model.account.request.GetClosedOrdersRequestBody;
import co.codingnomads.kraken.model.account.request.GetOpenOrdersRequestBody;
import co.codingnomads.kraken.model.market.pojo.KrakenOHLCResults;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import co.codingnomads.kraken.model.market.pojo.KrakenAssetPairName;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import co.codingnomads.kraken.model.trade.pojo.KrakenCancelOpenOrder;
import co.codingnomads.kraken.model.trade.pojo.KrakenOpenPosition;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeHistory;
import co.codingnomads.kraken.model.trade.pojo.KrakenTradeInfo;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.model.trade.request.GetOpenPositionsRequestBody;
import co.codingnomads.kraken.model.trade.request.GetTradeHistoryRequestBody;
import co.codingnomads.kraken.model.trade.request.QueryTradesInfoRequestBody;
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


    /**
     * Method for the Get order book api call <url>https://www.kraken.com/help/api#get-order-book</url>
     * This method is called on the controller and returns a Map of String and KrakenOrderBook
     * This method passes a the String params of "pair" and "count"
     * @param pair
     * @param count
     * @return Map<String, KrakenOrderBook>
     * @throws KrakenException
     */

    public Map<String, KrakenOrderBook> getOrderBook(String pair, String count) throws KrakenException{

        KrakenRequestEnum test = KrakenRequestEnum.GETORDERBOOK;
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

    /**
     * Method for the OHCL data api call <url>https://www.kraken.com/help/api#get-ohlc-data</url>
     * This method is called on the controller and returns the objects on KrakenOHLCResults
     * This method passes a Hashmap of Strings params and throws a KrakenException
     * @param params
     * @return KrakenOHLCResults
     * @throws KrakenException
     */

    public KrakenOHLCResults getOHCLOutput(HashMap<String, String> params) throws KrakenException{
        KrakenRequestEnum test = KrakenRequestEnum.GETOHLCDATA;
        test.updateEndpoint(createQueryParams(params) );

        OutputWrapper ohlcdata = handler.callAPI(test, null, null);

        if (ohlcdata.getError().length > 0){
            throw new KrakenException(ohlcdata.getError(), "General exception");
        } else {
           KrakenOHLCResults results = (KrakenOHLCResults) ohlcdata.getResult();
            if (results.getOHLCs().isEmpty())   {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method for the Cancel Open Orders API call. See <a href="https://www.kraken.com/help/api#cancel-open-order">https://www.kraken.com/help/api#cancel-open-order</a>
     * Returns a Map containing key(txid), value(KrakenClosedOrder) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params
     * @return Map<String, KrakenCancelOpenOrder>
     * @throws KrakenException
     */
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
     * Returns a Map containing key(txid), value(KrakenClosedOrder) corresponding to call's output.
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
        // Create instance of GetClosedOrdersRequestBody for the handler
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
     * Returns a Map containing key(txid), value(KrakenOpenOrder) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - URL query parameters
     * @return Map<String, KrakenOpenOrder>
     * @throws KrakenException
     */
    public Map<String, KrakenOpenOrder> getOpenOrder(HashMap<String, String> params) throws KrakenException{
        // Assign specific call enum.
        KrakenRequestEnum openOrderEnum = KrakenRequestEnum.GETOPENORDERS;
        // If parameters exists
        if (null != params) {
            // Update endpoint to add query parameters
            openOrderEnum.updateEndpoint(createQueryParams(params));
        }
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
     * Method to update query parameters for the GetAssetInfo API call.
     * See <url>https://www.kraken.com/help/api#get-asset-info</url>
     * Returns a Map containing key(asset_name), value(KrakenAsset) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - HashMap<String, String> (URL query parameters)
     * @return Map<String, KrakenAsset>
     * @throws KrakenException
     */

    public Map<String, KrakenAsset> getAssetInfo(HashMap<String, String> params) throws KrakenException {
        // Assign specific call enum.
        KrakenRequestEnum assetInfo = KrakenRequestEnum.GETASSETINFO;
        // If parameters exists
        if (null != params) {
            // Update endpoint to add query parameters
            assetInfo.updateEndpoint(createQueryParams(params));
        }
        // Call the callAPI method, pass in enum type, null request body (no request body for public get calls),
        // and authentication.
        OutputWrapper getAssetInfo = handler.callAPI(assetInfo, null, authentication);
        // If an error is received throw exception
        if (getAssetInfo.getError().length > 0) {
            throw new KrakenException(getAssetInfo.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenAsset("result") Map
            Map<String, KrakenAsset> results = (Map<String, KrakenAsset>) getAssetInfo.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()) {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method to update query parameters for the GetTradableAssetPair API call.
     * See <url>https://www.kraken.com/help/api#get-tradable-pairs</url>
     * Returns a Map containing key(pair_name), value(KrakenAssetPairName) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - HashMap<String, String> (URL query parameters)
     * @return Map<String, KrakenAssetPairName>
     * @throws KrakenException
     */

    public Map<String, KrakenAssetPairName> getTradableAssetPairName(HashMap<String, String> params) throws KrakenException {
        // Assign specific call enum.
        KrakenRequestEnum tradableAssetPairName = KrakenRequestEnum.GETTRADABLEASSETPAIRS;
        // If parameters exists
        if (null != params) {
            // Update endpoint to add query parameters
            tradableAssetPairName.updateEndpoint(createQueryParams(params));
        }
        // Call the callAPI method, pass in enum type, null request body (no request body for public get calls),
        // and authentication.
        OutputWrapper getTradableAssetPairName = handler.callAPI(tradableAssetPairName, null, authentication);
        // If an error is received throw exception
        if (getTradableAssetPairName.getError().length > 0) {
            throw new KrakenException(getTradableAssetPairName.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenAssetPairName("result") Map
            Map<String, KrakenAssetPairName> results = (Map<String, KrakenAssetPairName>) getTradableAssetPairName.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()) {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method to update query parameters for the QueryTradeInfo API call.
     * See <url>https://www.kraken.com/help/api#query-trades-info</url>
     * Returns a Map containing key(trade_txid), value(KrakenTradeInfo) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - HashMap<String, String> (URL query parameters)
     * @return Map<String, KrakenTradeInfo>
     * @throws KrakenException
     */

    public Map<String, KrakenTradeInfo> queryTradeInfo(HashMap<String, String> params) throws KrakenException {
        // Assign specific call enum.
        KrakenRequestEnum tradeInfo = KrakenRequestEnum.QUERYTRADESINFO;
        // Update endpoint to add query parameters
        tradeInfo.updateEndpoint(createQueryParams(params));
        // Create instance of QueryTradesInfoRequestBody for the handler
        QueryTradesInfoRequestBody queryTradesInfoRequestBody = new QueryTradesInfoRequestBody();
        // Call the callAPI method, pass in enum type, request body, and authentication.
        OutputWrapper queryTradeInfo = handler.callAPI(tradeInfo, queryTradesInfoRequestBody, authentication);
        // If an error is received throw exception
        if (queryTradeInfo.getError().length > 0) {
            throw new KrakenException(queryTradeInfo.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenTradeInfo("result") Map
            Map<String, KrakenTradeInfo> results = (Map<String, KrakenTradeInfo>) queryTradeInfo.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()) {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method to update query parameters for the GetOpenPositions API call.
     * See <url>https://www.kraken.com/help/api#get-open-positions</url>
     * Returns a Map containing key(position_txid), value(KrakenOpenPosition) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - HashMap<String, String> (URL query parameters)
     * @return Map<String, KrakenOpenPosition>
     * @throws KrakenException
     */

    public Map<String, KrakenOpenPosition> getOpenPositions(HashMap<String, String> params) throws KrakenException {
        // Assign specific call enum.
        KrakenRequestEnum openPostions = KrakenRequestEnum.GETOPENPOSITIONS;
        // Update endpoint to add query parameters
        openPostions.updateEndpoint(createQueryParams(params));
        // Create instance of GetOpenPositionsRequestBody for the handler
        GetOpenPositionsRequestBody getOpenPositionsRequestBody = new GetOpenPositionsRequestBody();
        // Call the callAPI method, pass in enum type, request body, and authentication.
        OutputWrapper getOpenPositions = handler.callAPI(openPostions, getOpenPositionsRequestBody, authentication);
        // If an error is received throw exception
        if (getOpenPositions.getError().length > 0) {
            throw new KrakenException(getOpenPositions.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenOpenPosition("result") Map
            Map<String, KrakenOpenPosition> results = (Map<String, KrakenOpenPosition>) getOpenPositions.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.isEmpty()) {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

    /**
     * Method to update query parameters for the GetTradeHistory API call.
     * See <url>https://www.kraken.com/help/api#get-trades-history</url>
     * Returns an array of KrakenTradeHistory.  Within KrakenTradeHistory returns a map
     * containing key(txid), value(KrakenTradeInfo) corresponding to call's output.
     * This method is called in the Controller and passed a HashMap of query parameters.
     * @param params - HashMap<String, String> (URL query parameters)
     * @return KrakenTradeHistory
     * @throws KrakenException
     */

    public KrakenTradeHistory getTradeHistory(HashMap<String, String> params) throws KrakenException {
        // Assign specific call enum.
        KrakenRequestEnum tradeHistory = KrakenRequestEnum.GETTRADESHISTORY;
        // Update endpoint to add query parameters
        tradeHistory.updateEndpoint(createQueryParams(params));
        // Create instance of GetClosedOrdersRequestBody for the handler
        GetTradeHistoryRequestBody getTradeHistoryRequestBody = new GetTradeHistoryRequestBody();
        // Call the callAPI method, pass in enum type, request body, and authentication.
        OutputWrapper getTradeHistory = handler.callAPI(tradeHistory, getTradeHistoryRequestBody, authentication);
        // If an error is received throw exception
        if (getTradeHistory.getError().length > 0) {
            throw new KrakenException(getTradeHistory.getError(), "General exception");
        } else {
            // If no initial error, store & return results as String ("error")/KrakenAssetPairName("result") Map
            KrakenTradeHistory results = (KrakenTradeHistory) getTradeHistory.getResult();
            // If no results are retrieved throw exception, otherwise return results.
            if (results.getTrades().isEmpty()) {
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }



    /**
     * Method for Get Ledger Info API call.See <url>https://api.kraken.com/0/private/Ledgers</url>
     * Returns the highest level POJO corresponding to call's output (KrakenLedgersInfoResult).
     * Method requires a result offset in the GetLedgersInfoRequestBody to run.
     * This method is called in the controller.
     * @params int offset.
     * @return Map<String, KrakenLedgersInfo>
     * @throws KrakenException
     */

    public KrakenLedgersInfoResult getLedgersInfo(int ofs) throws KrakenException {

        GetLedgersInfoRequestBody getLedgersInfoRequestBody = new GetLedgersInfoRequestBody(ofs);

        OutputWrapper getLedgersInfo = handler.callAPI(KrakenRequestEnum.GETLEDGERSINFO, getLedgersInfoRequestBody, authentication);

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
     * Method for Query Ledgers API call. See <url> https://api.kraken.com/0/private/QueryLedgers</url>
     * Returns a map containing a String and the POJO
     * corresponding to the call's output (KrakenLedgersInfo).
     * This method requires a Ledger ID in the QueryLEdgersRequestBody to run.
     * This method is called in the controller.
     * @params  String ledger Id (comma delimited list of ids)
     * @return Map<String, KrakenLedgersInfo>
     * @throws KrakenException
     */

    public Map<String, KrakenLedgersInfo> queryLedgers(String ledgerId) throws KrakenException {

        QueryLedgersRequestBody queryLedgersRequestBody = new QueryLedgersRequestBody(ledgerId);

        OutputWrapper queryLedgers = handler.callAPI(KrakenRequestEnum.QUERYLEDGERS, queryLedgersRequestBody, authentication);

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
     * Method for Get Trade Volume API call. See <url> https://api.kraken.com/0/private/TradeVolume</url>
     * returns the POJO corresponding to the call's output (KrakenTradeVolume).
     * This method has the option to take in a list of specific asset pairs and a boolean for fee-info
     * in order to return the fee or fee_maker information.
     * This method is called in the controller.
     * @params String pairs, comma delimited list (optional), boolean fee-info (optional)
     * @return KrakenTradeVolume
     * @throws KrakenException
     */

    public KrakenTradeVolume getTradeVolume(String pairs, boolean feeInfo) throws KrakenException {

        GetTradeVolumeRequestBody getTradeVolumeRequestBody = new GetTradeVolumeRequestBody(pairs,feeInfo);

        OutputWrapper getTradeVolume = handler.callAPI(KrakenRequestEnum.GETTRADEVOLUME, getTradeVolumeRequestBody, authentication);

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
        int count = 0;
        while (it.hasNext()) {
            if (count > 0){
                sb.append("&");
            }
            Map.Entry pair = (Map.Entry)it.next();
            sb.append(pair.getKey() + "=" + pair.getValue());
            count++;
        }
        return sb.toString();
    }


    /**
     * For calls that include query parameters. Takes a String key - String value HashMap parameter.
     * Builds a string beginning with "?" followed by the key + value for all params passed in.
     * String is returned and added to the end of the URL endpoint in API call methods above that use
     * query params.
     * @param params - map of query parameter names and values
     * @return String - formatted url query parameters
     * @param params - URL set params
     * @return Map<String, KrakenOpenOrder>
     * @throws KrakenException
     */

    public Map<String, KrakenOpenOrder> getQueryTrades(HashMap<String, String> params) throws KrakenException{
        KrakenRequestEnum queryTradesInfoEnum = KrakenRequestEnum.QUERYORDERINFO;
        queryTradesInfoEnum.updateEndpoint(createQueryParams(params));

        OutputWrapper getQueryTradesInfo = handler.callAPI(queryTradesInfoEnum,null, authentication);

        if (getQueryTradesInfo.getError().length > 0){
            throw new KrakenException(getQueryTradesInfo.getError(), "General exception");
        } else {
            Map<String, KrakenOpenOrder> results = (Map<String, KrakenOpenOrder>) getQueryTradesInfo.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }

}
