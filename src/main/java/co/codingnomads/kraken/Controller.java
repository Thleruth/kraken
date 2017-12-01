package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GenericRequestHandler handler = new GenericRequestHandler();
        OutputWrapper c = handler.callAPI(KrakenRequestEnum.GETSERVERTIME,null);
        // System.out.println(c.getErrors()[0]);
        System.out.println(((GetServerTimeOutput) c.getResult()).getUnixtime());
        System.out.println(((GetServerTimeOutput) c.getResult()).getRfc1123());

        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS,null);
        System.out.println( d.getResult());



    }
}
