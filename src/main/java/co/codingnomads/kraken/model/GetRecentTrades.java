package co.codingnomads.kraken.model;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRecentTrades {

    String pairName;
    Integer[][] entries;
    Long lastID;

    //todo no clue what this is supposed to look like , needs a lot of work

    /*
    pair_name> = pair name

    array of array entries(<price>, <volume>, <time>, <buy/sell>, <market/limit>, <miscellaneous>)
last = id to be used as since when polling for new trade data

 */




}
