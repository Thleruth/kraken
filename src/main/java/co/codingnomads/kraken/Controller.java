package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetAccountBalanceRequestBody;
import co.codingnomads.kraken.model.account.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        RequestBodyGeneric a = new GetTradeBalanceRequestBody("XBTC", "ZEUR");

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETTRADEBALANCE, a);

        if (d.getError().length == 0) {
            System.out.println(d.getResult().toString());
        }
        else {
            System.out.println(d.printError());
        }

    }
}
