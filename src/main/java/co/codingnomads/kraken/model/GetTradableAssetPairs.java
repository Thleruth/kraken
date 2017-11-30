package co.codingnomads.kraken.model;

/*
created by PopoPenguin on 11/29/17
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.util.Pair;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTradableAssetPairs {

    //Result is an array of Pair Names

    List<PairName> pairNames;


}
