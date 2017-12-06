package co.codingnomads.kraken;

import co.codingnomads.kraken.model.*;
//import co.codingnomads.kraken.model.account.response.GetBalanceOutput;
import co.codingnomads.kraken.model.ricky.GetOrderBook;
import co.codingnomads.kraken.model.ricky.KrakenRecentTrade;
import co.codingnomads.kraken.service.GenericRequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class Controller {

    public static void main(String[] args) throws NullPointerException{


        //GetBalanceRequestBody a = new GetBalanceRequestBody();

        GenericRequestHandler handler = new GenericRequestHandler();
        //OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETACCOUNTBALANCE, a);
  //      OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETORDERBOOK, null);
//        OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETSERVERTIME, null);
            OutputWrapper d = handler.callAPI(KrakenRequestEnum.GETRECENTRADES, null);


        System.out.println(d.toString());

        ObjectMapper mapper = new ObjectMapper();
        Map<String, KrakenRecentTrade> map = (Map<String, KrakenRecentTrade>) d.getResult();
        //ArrayList<GetOrderBookOutput> pojos = (ArrayList<GetOrderBookOutput>) mapper.convertValue(map, new TypeReference<List<GetOrderBookOutput>>() { });

        //OutputWrapper e = handler.callAPI(KrakenRequestEnum.GETTICKERINFORMATION, null);


        System.out.println(d);
        System.out.println(d.getResult());

    }
}
