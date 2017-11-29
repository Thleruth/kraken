package co.codingnomads.kraken;

import co.codingnomads.kraken.model.GetTradeBalance;
import co.codingnomads.kraken.model.GetTradeBalanceOutput;
import co.codingnomads.kraken.model.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GetTradeBalance a = new GetTradeBalance();
        GetTradeBalanceRequestBody b = new GetTradeBalanceRequestBody(null, null);
        GenericRequestHandler handler = new GenericRequestHandler();
        GetTradeBalanceOutput c = (GetTradeBalanceOutput) handler.callAPI(a,b);
        System.out.println(c.getError()[0]);
        System.out.println(c.getEb());
    }
}
