package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.GetBalanceRequestBody;
import co.codingnomads.kraken.model.account.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.model.account.output.GetBalanceOutput;
import co.codingnomads.kraken.model.account.output.GetTradeBalanceOutput;
import co.codingnomads.kraken.model.market.output.GetServerTimeOutput;
import co.codingnomads.kraken.model.market.output.GetTradableAssetPairsOutput;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        GetBalanceRequestBody a = new GetBalanceRequestBody();
        GetTradeBalanceRequestBody b = new GetTradeBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();

        //OutputWrapper<GetBalanceOutput> d = handler.callAPI(KrakenRequestEnum.GETACCOUNTBALANCE, a, GetBalanceOutput.class);
        //OutputWrapper<GetTradeBalanceOutput> f = handler.callAPI(KrakenRequestEnum.GETTRADEBALANCE, b, GetTradeBalanceOutput.class);

        //GetServerTimeOutput e = (GetServerTimeOutput) handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null, GetServerTimeOutput.class).getResult();


        GetTradableAssetPairsOutput d = (GetTradableAssetPairsOutput) handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS,null, GetTradableAssetPairsOutput.class).getResult();
        System.out.println(d);
        System.out.println( d.getResult());


    }
}
