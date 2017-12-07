package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.market.pojos.KrakenServerTime;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.model.trade.response.CancelOpenOrderOutput;
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
        // RequestBody shouldn't be null here:
        CancelOpenOrderRequestBody cancelOpenOrderRequestBody = new CancelOpenOrderRequestBody(0);
        OutputWrapper cancelOrder = handler.callAPI(KrakenRequestEnum.CANCELOPENORDER, cancelOpenOrderRequestBody);

        //ricky currnetly working gettickerinfo and getrecenttrades


        ObjectMapper mapper = new ObjectMapper();
        //get results from OutputWrapper "orderBook"
        Map<String, GetOrderBookOutput> results = (Map<String, GetOrderBookOutput>) orderBook.getResult();
        //If there are any errors, they will be in orderBook.getErrors()
        String[] errors = orderBook.getError();


        //Another exmaple:
        KrakenServerTime time = (KrakenServerTime) serverTime.getResult();
        String[] serverTimeErrors = serverTime.getError();

        Map<String, CancelOpenOrderOutput> results2 = (Map<String, CancelOpenOrderOutput>) cancelOrder.getResult();
        String[] cancelOrderErrors = cancelOrder.getError();


        System.out.println("Put a break point HERE and DEBUG me");

        // @meg - Cancel open order testing
//        CancelOpenOrderRequestBody coorb = new CancelOpenOrderRequestBody(1);
//        GenericRequestHandler handler1 = new GenericRequestHandler();
        //this doesn't work because callAPI 2nd param is GetBalanceRequestBody object.
        //Don't know if this is intentional or just how Thomas was testing if it works.
//        OutputWrapper ow = handler1.callAPI(KrakenRequestEnum.CANCELOPENORDER, coorb);

    }
}
