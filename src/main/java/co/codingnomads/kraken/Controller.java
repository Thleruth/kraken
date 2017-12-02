package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetBalanceRequestBody;
import co.codingnomads.kraken.model.account.output.GetBalanceOutput;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETACCOUNTBALANCE, a);

        System.out.println(d.toString());

    }
}
