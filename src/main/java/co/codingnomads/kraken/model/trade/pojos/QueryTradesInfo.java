package co.codingnomads.kraken.model.trade.pojos;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public class QueryTradesInfo {

    String ordertxid;
    String pair;
    String time;
    String type;
    String ordertype;
    String price;
    String cost;
    String fee;
    String vol;
    String margin;
    String misc;
    String closing;
    String count;
    String posstatus;
    String cprice;
    String ccost;
    String cfee;
    String cvol;
    String cmargin;
    String net;
    String trades;

    //TODO refine data types, include getters, constructors, and toString


}
