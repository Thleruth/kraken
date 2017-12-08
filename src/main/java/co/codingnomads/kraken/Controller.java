package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.request.GetAccountBalanceRequestBody;
import co.codingnomads.kraken.model.account.request.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.model.account.response.GetAccountBalanceOutput;
import co.codingnomads.kraken.model.trade.request.CancelOpenOrdersRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        KrakenExchange exchange = new KrakenExchange(
                "Insert API-Key",
                "Insert API-Secret",
                4);

        GenericRequestHandler handler = new GenericRequestHandler();

        RequestBodyGeneric a = new GetTradeBalanceRequestBody(null, "ZEUR");

        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETTRADEBALANCE, a, exchange.apiAuthentication);

        System.out.println(d.toString());

    }
}
