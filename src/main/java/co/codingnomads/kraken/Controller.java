package co.codingnomads.kraken;


import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.exception.UnkownException;
import co.codingnomads.kraken.model.*;
//import co.codingnomads.kraken.model.account.response.GetBalanceOutput;
import co.codingnomads.kraken.model.account.request.GetBalanceRequestBody;
import co.codingnomads.kraken.model.market.pojos.KrakenServerTime;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.service.CallCounter;
import co.codingnomads.kraken.service.GenericRequestHandler;
import co.codingnomads.kraken.util.RateLimitThreadTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        //Kevin testing
        ApiKey key = new ApiKey("Enter Api key", 2,
        "Enter API secret");


        //Kevin testing rate limit
        //testRateLimit(key);


        GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper orderBook = null;
        try {
            orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null, key);
        } catch (UnkownException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }


        OutputWrapper serverTime = null;
        try {
            serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null, key);
        } catch (UnkownException e) {
            e.printStackTrace();
        } catch (RateLimitException e) {
            e.printStackTrace();
        }

        //ricky currnetly working gettickerinfo and getrecenttrades


        ObjectMapper mapper = new ObjectMapper();
        //get results from OutputWrapper "orderBook"
        Map<String, GetOrderBookOutput> results = (Map<String, GetOrderBookOutput>) orderBook.getResult();
        //If there are any errors, they will be in orderBook.getErrors()
        String[] errors = orderBook.getError();


        //Another exmaple:
        KrakenServerTime time = (KrakenServerTime) serverTime.getResult();
        String[] serverTimeErrors = serverTime.getError();


        System.out.println("Put a break point HERE and DEBUG me");


    }


    public static void testRateLimit(ApiKey key) {

        System.out.println("Testing rate limit");

        for(int i =0; i < 20; i++){

            RateLimitThreadTest threadOne = new RateLimitThreadTest("thread" + i, key);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("All done");

    }

}
