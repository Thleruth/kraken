package co.codingnomads.kraken;
import co.codingnomads.kraken.model.*;
import co.codingnomads.kraken.model.account.request.GetTradeBalanceRequestBody;
import co.codingnomads.kraken.model.market.request.GetOpenPositionsRequestBody;
import co.codingnomads.kraken.model.trade.request.GetTradeHistoryRequestBody;
import co.codingnomads.kraken.model.trade.request.QueryTradesInfoRequestBody;
import co.codingnomads.kraken.service.GenericRequestHandler;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{

        KrakenExchange exchange = new KrakenExchange(
                "ApiKey Goes Here",
                "ApiSecret Goes Here",
                3);

        GenericRequestHandler handler = new GenericRequestHandler();

        RequestBodyGeneric a = new GetTradeBalanceRequestBody(null, "ZEUR");
        RequestBodyGeneric b = new QueryTradesInfoRequestBody(24);
        RequestBodyGeneric c = new GetOpenPositionsRequestBody(24);

//        OutputWrapper orderBook = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null, exchange.getApiAuthentication());
//        OutputWrapper serverTime = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null, exchange.getApiAuthentication());
//        OutputWrapper tradeHistory = handler.callAPI(KrakenRequestEnum.GETTRADESHISTORY, b, exchange.getApiAuthentication());
//        OutputWrapper queryTradeInfo = handler.callAPI(KrakenRequestEnum.QUERYTRADESINFO, b, exchange.getApiAuthentication());
        OutputWrapper openPositions = handler.callAPI(KrakenRequestEnum.GETOPENPOSITIONS, c, exchange.getApiAuthentication());

        //ricky currnetly working gettickerinfo and getrecenttrades


//        ObjectMapper mapper = new ObjectMapper();
        //get results from OutputWrapper "orderBook"
        //Map<String, GetOrderBookOutput> results = (Map<String, GetOrderBookOutput>) orderBook.getResult();
        //If there are any errors, they will be in orderBook.getErrors()
        //String[] errors = orderBook.getError();

        //Another exmaple:
//        KrakenServerTime time = (KrakenServerTime) serverTime.getResult();
//        String[] serverTimeErrors = serverTime.getError();

//        Map<String, CancelOpenOrderOutput> results2 = (Map<String, CancelOpenOrderOutput>) cancelOrder.getResult();
//        String[] cancelOrderErrors = cancelOrder.getError();




    }
}
