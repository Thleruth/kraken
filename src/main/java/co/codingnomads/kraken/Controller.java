package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.market.response.GetRecentTradesOutput;
import co.codingnomads.kraken.model.market.response.GetTradableAssetPairsOutput;

import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{


        //GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();

        OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null);
        OutputWrapper serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null);
        OutputWrapper recentTrades = handler.callAPI(KrakenRequestEnum.GETRECENTTRADES, null);
        OutputWrapper tradableAssetPairs = handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS, null);
//        OutputWrapper openPositions = handler.callAPI(KrakenRequestEnum.GETOPENPOSITIONS, null);


       // OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null);
       // OutputWrapper serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null);
        // RequestBody shouldn't be null here:



        //ricky currnetly working gettickerinfo and getrecenttrades


        ObjectMapper mapper = new ObjectMapper();
        //get results from OutputWrapper "orderBook"
        //Map<String, GetOrderBookOutput> results = (Map<String, GetOrderBookOutput>) orderBook.getResult();
        //If there are any errors, they will be in orderBook.getErrors()
        //String[] errors = orderBook.getError();

        //test for recentTrades
        Map<String, GetRecentTradesOutput> recentTradesResult = (Map<String, GetRecentTradesOutput>) recentTrades.getResult();
        String[] recentTradesError = recentTrades.getError();

        //test for tradableAssetPairs
        Map<String, GetTradableAssetPairsOutput> tradeableAssetPairsResult = (Map<String, GetTradableAssetPairsOutput>) tradableAssetPairs.getResult();
        String[] tradableAssetPairsError = tradableAssetPairs.getError();

        //test for openpositions
//        Map<String, GetOpenPositionsOutput> openPositionsResult = (Map<String, GetOpenPositionsOutput>) openPositions.getResult();
//        String[] openPositionError = openPositions.getError();


        //Another exmaple:
//        KrakenServerTime time = (KrakenServerTime) serverTime.getResult();
//        String[] serverTimeErrors = serverTime.getError();

//        Map<String, CancelOpenOrderOutput> results2 = (Map<String, CancelOpenOrderOutput>) cancelOrder.getResult();
//        String[] cancelOrderErrors = cancelOrder.getError();


        System.out.println("Put a break point HERE and DEBUG me");


    }
}
