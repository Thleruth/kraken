package co.codingnomads.kraken.model;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

public class GetOpenPositions {

    String ordertxid;
    String assetPair;
    Long time;
    String type;
    String ordertype;
    BigDecimal cost;
    BigDecimal fee;
    BigDecimal vol;
    BigDecimal vol_closed;
    BigDecimal margin;
    BigDecimal value;
    BigDecimal net;
    List misc;
    List oflags;
    BigDecimal viqc;

    //TODO getters, constructors, and toString once data type is confirmed for variables

}
