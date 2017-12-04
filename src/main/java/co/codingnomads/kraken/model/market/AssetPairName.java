package co.codingnomads.kraken.model.market;

/*
created by PopoPenguin on 11/29/17
*/

import co.codingnomads.kraken.model.market.Fees;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AssetPairName {

    //Pojo of AssetPairName output

    String altname;
    String aclass_base;
    String base;
    String aclass_quote;
    String quote;
    String lot;
    int pair_decimals;
    int lot_decimals;
    int lot_multiplier;
    List<Integer> leverage_buy;
    List<Integer> leverage_sell;
    List<Fees> fees;
    List<Fees> fees_maker;
    String fee_volume_currency;
    int margin_call;
    int margin_stop;

    public AssetPairName(String altname, String aclass_base, String base, String aclass_quote, String quote, String lot,
                         int pair_decimals, int lot_decimals, int lot_multiplier, List<Integer> leverage_buy,
                         List<Integer> leverage_sell, List<Fees> fees, List<Fees> fees_maker, String fee_volume_currency,
                         int margin_call, int margin_stop) {
        this.altname = altname;
        this.aclass_base = aclass_base;
        this.base = base;
        this.aclass_quote = aclass_quote;
        this.quote = quote;
        this.lot = lot;
        this.pair_decimals = pair_decimals;
        this.lot_decimals = lot_decimals;
        this.lot_multiplier = lot_multiplier;
        this.leverage_buy = leverage_buy;
        this.leverage_sell = leverage_sell;
        this.fees = fees;
        this.fees_maker = fees_maker;
        this.fee_volume_currency = fee_volume_currency;
        this.margin_call = margin_call;
        this.margin_stop = margin_stop;
    }

    public String getAltname() {
        return altname;
    }

    public String getAclass_base() {
        return aclass_base;
    }

    public String getBase() {
        return base;
    }

    public String getAclass_quote() {
        return aclass_quote;
    }

    public String getQuote() {
        return quote;
    }

    public String getLot() {
        return lot;
    }

    public int getPair_decimals() {
        return pair_decimals;
    }

    public int getLot_decimals() {
        return lot_decimals;
    }

    public int getLot_multiplier() {
        return lot_multiplier;
    }

    public List<Integer> getLeverage_buy() {
        return leverage_buy;
    }

    public List<Integer> getLeverage_sell() {
        return leverage_sell;
    }

    public List<Fees> getFees() {
        return fees;
    }

    public List<Fees> getFees_maker() {
        return fees_maker;
    }

    public String getFee_volume_currency() {
        return fee_volume_currency;
    }

    public int getMargin_call() {
        return margin_call;
    }

    public int getMargin_stop() {
        return margin_stop;
    }

    @Override
    public String toString() {
        return "AssetPairName{" +
                "altname='" + altname + '\'' +
                ", aclass_base='" + aclass_base + '\'' +
                ", base='" + base + '\'' +
                ", aclass_quote='" + aclass_quote + '\'' +
                ", quote='" + quote + '\'' +
                ", lot='" + lot + '\'' +
                ", pair_decimals=" + pair_decimals +
                ", lot_decimals=" + lot_decimals +
                ", lot_multiplier=" + lot_multiplier +
                ", leverage_buy=" + leverage_buy +
                ", leverage_sell=" + leverage_sell +
                ", fees=" + fees +
                ", fees_maker=" + fees_maker +
                ", fee_volume_currency='" + fee_volume_currency + '\'' +
                ", margin_call=" + margin_call +
                ", margin_stop=" + margin_stop +
                '}';
    }
}
