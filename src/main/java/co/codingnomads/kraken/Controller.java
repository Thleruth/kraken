package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetBalanceRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GetBalanceRequestBody a = new GetBalanceRequestBody();
        GenericRequestHandler handler = new GenericRequestHandler();
<<<<<<< HEAD
        OutputWrapper c = handler.callAPI(KrakenRequestEnum.GETSERVERTIME,null);
        // System.out.println(c.getErrors()[0]);
        System.out.println(((GetServerTimeOutput) c.getResult()).getUnixtime());
        System.out.println(((GetServerTimeOutput) c.getResult()).getRfc1123());

        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS,null);
        System.out.println( d.getResult());



=======
        OutputWrapper c = handler.callAPI(KrakenRequestEnum.GETACCOUNTBALANCE,a);
        System.out.println(c);
        System.out.println(c.getResult());
>>>>>>> 05a813337b97708d70b97568e5f517a3cf7f7df1
    }
}
