package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetAccountBalanceRequestBody;
import co.codingnomads.kraken.model.account.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.model.trade.CancelOpenOrdersRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        KrakenExchange exchange = new KrakenExchange(
                "Insert Key",
                "Insert Secret",
                4);

        RequestBodyGeneric a = new CancelOpenOrdersRequestBody("OSVBCI-PB55V-M7EWZ2");

        GenericRequestHandler handler = new GenericRequestHandler();

        // passing exchange as an argument is temporary (until we have the KrakenExchange class being working fully)
        OutputWrapper d = handler.callAPI(KrakenRequestEnum.CANCELOPENORDERS, a, exchange);

        if (d.getError().length == 0) {
            System.out.println(d.getResult().toString());
        }
        else {
            System.out.println(d.printError());
        }

    }
}
