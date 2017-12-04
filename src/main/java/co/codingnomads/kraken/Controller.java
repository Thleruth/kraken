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

//        GetBalanceRequestBody a = new GetBalanceRequestBody();
//        GetTradeBalanceRequestBody b = new GetTradeBalanceRequestBody();
        GenericRequestHandler handler = new GenericRequestHandler();

//        OutputWrapper<GetServerTimeOutput> e = (GetServerTimeOutput) handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null, GetServerTimeOutput.class);
//        String[] errors = e.getErrors();
//        GetServerTimeOutput obj = e.getResult();

        OutputWrapper<GetTradableAssetPairsOutput> d = (GetTradableAssetPairsOutput) handler.callAPI(KrakenRequestEnum.GETTRADABLEASSETPAIRS,null, GetTradableAssetPairsOutput.class);
        String[] errors = d.getErrors();
        GetTradableAssetPairsOutput obj = d.getResult();

        System.out.println(obj.toString());
    }
}
