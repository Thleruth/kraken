package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
//import co.codingnomads.kraken.model.account.response.GetBalanceOutput;
import co.codingnomads.kraken.model.market.pojos.KrakenServerTime;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.service.GenericRequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller implements Runnable {

    public static void main(String[] args) throws NullPointerException{


        //GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null);
        OutputWrapper serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null);

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



    @Override
    public void run() {

    }
}
