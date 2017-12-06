package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.CancelOpenOrderRequestBody;
import co.codingnomads.kraken.model.account.GetBalanceRequestBody;
import co.codingnomads.kraken.model.account.output.GetBalanceOutput;
import co.codingnomads.kraken.service.GenericRequestHandler;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETACCOUNTBALANCE, a);

        System.out.println(d.toString());

        // Cancel open order testing
//        CancelOpenOrderRequestBody coorb = new CancelOpenOrderRequestBody(1);
//        GenericRequestHandler handler1 = new GenericRequestHandler();
        //this doesn't work because callAPI 2nd param is GetBalanceRequestBody object.
        //Don't know if this is intentional or just how Thomas was testing if it works.
//        OutputWrapper ow = handler1.callAPI(KrakenRequestEnum.CANCELOPENORDER, coorb);

    }
}
