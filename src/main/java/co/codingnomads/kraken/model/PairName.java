package co.codingnomads.kraken.model;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PairName {

    //Pojo of PairName output

    String altname;
    String aclass_base;
    String base;
    String aclass_quote;
    String quote;
    String lot;
    Long pair_decimals;
    Long lot_decimals;
    Long lot_multiplier;
    Integer [] leverage_buy;
    Integer [] leverage_sell;
    Fees [] fees;
    FeesMaker [] fees_maker;
    String fee_volume_currency;
    Long margin_call;
    Long margin_stop;


}
