package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.request.GetAccountBalanceRequestBody;
import co.codingnomads.kraken.model.account.request.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.model.market.response.GetOrderBookOutput;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrdersRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        KrakenExchange exchange = new KrakenExchange(
                "Insert KEY",
                "Insert Secret",
                4);

        GenericRequestHandler handler = new GenericRequestHandler();

        RequestBodyGeneric a = new GetTradeBalanceRequestBody(null, "XETH");

        // passing exchange as an argument is temporary (until we have the KrakenExchange class being working fully)
        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, a, exchange);

        if (d.getError().length == 0) {
            System.out.println(d.getResult().toString());
        }
        else {
            System.out.println(d.printError());
        }

       System.out.println("Put a break point HERE and DEBUG me");

    }
}
