package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.*;;
import co.codingnomads.kraken.model.account.request.GetLedgersInfoRequestBody;
import co.codingnomads.kraken.model.account.request.GetTradeVolumeRequestBody;
import co.codingnomads.kraken.model.account.request.QueryLedgersRequestBody;
import co.codingnomads.kraken.model.market.pojo.KrakenAsset;
import co.codingnomads.kraken.model.market.pojo.KrakenAssetPairName;
import co.codingnomads.kraken.model.market.pojo.KrakenSpread;
import co.codingnomads.kraken.model.trade.request.GetOpenPositionsRequestBody;
import co.codingnomads.kraken.model.trade.request.GetTradeHistoryRequestBody;
import co.codingnomads.kraken.model.trade.request.QueryTradesInfoRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.util.MultiValueMap;
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
                "API Key Here",
                "API Secret Here",
                4);

        GenericRequestHandler handler = new GenericRequestHandler();

        try {
            // HashMap needed if API URL requires query parameters. First String is param name, second is param value
            HashMap<String, String> params = new HashMap<>();
            params.put("pair", "XBTUSD");
            // Call to KrakenExchange class, you will need to add KrakenExchange method for each API call
            // you implemented. Use getRecentSpreadData as a working example.
            Map<String, KrakenSpread> recentSpreadDataMap = exchange.getRecentSpreadData(params);
            System.out.println(recentSpreadDataMap.size());
        } catch (KrakenException e) {
            System.out.println(e.toString());
        }
    }
}
