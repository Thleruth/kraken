package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.*;;
import co.codingnomads.kraken.model.account.request.GetLedgersInfoRequestBody;
import co.codingnomads.kraken.model.account.request.GetTradeVolumeRequestBody;
import co.codingnomads.kraken.model.account.request.QueryLedgersRequestBody;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import co.codingnomads.kraken.model.market.pojo.KrakenAssetPairName;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import co.codingnomads.kraken.model.trade.request.AddStandardOrderRequestBody;
import co.codingnomads.kraken.model.trade.request.GetOpenPositionsRequestBody;
import co.codingnomads.kraken.model.trade.request.GetTradeHistoryRequestBody;
import co.codingnomads.kraken.model.trade.request.QueryTradesInfoRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws KrakenException {


        //so far not used as we call method directly, will later call method on that
        // todo ryan: Correct my thinking but later we could call within the exchange getters of
        // of the apiAuthentication and thus getting the elements no (no need to pass in as Param)?
        // just for security purpose and we could raise the access level of the ApiAuthentication
        KrakenExchange exchange = new KrakenExchange(
                "",
                "",
                2);


        GenericRequestHandler handler = new GenericRequestHandler();

//        RequestBodyGeneric a = new GetTradeVolumeRequestBody();
//        OutputWrapper k = handler.callAPI(KrakenRequestEnum.GETTRADEVOLUME, a, exchange.getApiAuthentication());
//        System.out.println(k.toString());
//

//        RequestBodyGeneric getTradeVolume = new GetTradeVolumeRequestBody("ETHUSD",true);
//        OutputWrapper kevinCallOne = handler.callAPI(KrakenRequestEnum.GETTRADEVOLUME, getTradeVolume, exchange.getApiAuthentication());
//        System.out.println(kevinCallOne.toString());

//        RequestBodyGeneric addStandardOrder = new AddStandardOrderRequestBody("ETHUSD","buy","market",
//                "20.2", "24.3", 1,"none", "nompp","12", "7", "2147483647",
//                true);

        RequestBodyGeneric addStandardOrder = new AddStandardOrderRequestBody("ETHUSD","sell","limit",
                "754.58",0.02,"none","fciq","0","0","2147483647",true);
        OutputWrapper kevinCallThree = handler.callAPI(KrakenRequestEnum.ADDSTRANDARDORDERS,addStandardOrder, exchange.getApiAuthentication());
        System.out.println(kevinCallThree.toString());

//        try {
//            // HashMap needed if API URL requires query parameters. First String is param name, second is param value
//            HashMap<String, String> params = new HashMap<>();
//            params.put("pair", "XBTUSD");
//            // Call to KrakenExchange class, you will need to add KrakenExchange method for each API call
//            // you implemented. Use getRecentSpreadData as a working example.
//            Map<String, KrakenSpread> recentSpreadDataMap = exchange.getRecentSpreadData(params);
//            System.out.println(recentSpreadDataMap.size());
//        } catch (KrakenException e) {
//            System.out.println(e.toString());
//        }


//        KrakenResult[OK: KrakenTradeVolume{currency='ZUSD', volume=277.9371, fee=null, fee_maker=null}]
//        KrakenResult[OK: {descr={order=sell 0.02000000 ETHUSD @ market}, txid=[OEIPIA-O3ZJ2-EJORQ3]}]
        //KrakenResult[OK: KrakenTradeVolume{currency='ZUSD', volume=293.6015, fee={XETHZUSD=KrakenFee{fee=0.2600, minFee=0.1000, maxFee=0.2600, nextFee=0.2400, nextVolume=50000.0000, tiervolume=0.0000}}, fee_maker={XETHZUSD=KrakenFee{fee=0.1600, minFee=0.0000, maxFee=0.1600, nextFee=0.1400, nextVolume=50000.0000, tiervolume=0.0000}}}]


    }
}
