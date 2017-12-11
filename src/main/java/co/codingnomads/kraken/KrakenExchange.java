package co.codingnomads.kraken;

import co.codingnomads.kraken.exception.KrakenException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import co.codingnomads.kraken.model.OutputWrapper;
import co.codingnomads.kraken.model.market.pojo.KrakenOrderBook;
import co.codingnomads.kraken.service.GenericRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/30/17
 */

public class KrakenExchange {

    ApiAuthentication authentication;

    @Autowired
    GenericRequestHandler handler;

    public KrakenExchange(String apiKey, String apiSecret, int tier) {
        authentication = new ApiAuthentication(apiKey, tier, apiSecret);
    }

    public ApiAuthentication getApiAuthentication() {
        return authentication;
    }

    //todo one method for each potential KrakenRequest enum item (via the CallAPI)


    /**
     *
     * @param pair
     * @return
     * @throws KrakenException
     */

    // pair required, count optional
    public Map<String, KrakenOrderBook> getOrderBook(String pair, String count) throws KrakenException{

        OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK,
                null, authentication, pair, count, "another query");

        if (orderBook.getError().length > 0){
            throw new KrakenException(orderBook.getError(), "General exception");
        } else {
            Map<String, KrakenOrderBook> results = (Map<String, KrakenOrderBook>) orderBook.getResult();
            if (results.isEmpty()){
                throw new KrakenException("General exception, results are null");
            } else {
                return results;
            }
        }
    }
}
