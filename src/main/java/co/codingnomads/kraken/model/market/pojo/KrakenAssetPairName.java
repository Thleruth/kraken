package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * created by Jialor Cheung on 11/29/17
 *
 * This is the information body, KrakenAssetPairName POJO, for the result list of objects in
 * api call GetTradableAssetPair <url>https://api.kraken.com/0/public/AssetPairs</url>
 *
 * Kraken API Documentation for this call <url>https://www.kraken.com/help/api#get-tradable-pairs</url>
 */

public class KrakenAssetPairName {

    private final String altname;
    private final String aclass_base;
    private final String base;
    private final String aclass_quote;
    private final String quote;
    private final String lot;
    private final String fee_volume_currency;

    //using BigDecimal format for most accurate data type associated to monetary values
    private final BigDecimal pair_decimals;
    private final BigDecimal lot_decimals;
    private final BigDecimal lot_multiplier;
    private final BigDecimal margin_call;
    private final BigDecimal margin_stop;

    private final List<Integer> leverage_buy;
    private final List<Integer> leverage_sell;

    //created a KrakenFees class associated to the array of fees used in both fees and fees_maker variables;
    private final List<KrakenFees> fees;
    private final List<KrakenFees> fees_maker;

    /**
     * Fully Qualified Constructor
     *
     * @param altname                 alternate pair name
     * @param aclass_base             asset class of base component
     * @param base                    asset id of base component
     * @param aclass_quote            asset class of quote component
     * @param quote                   asset id of quote component
     * @param lot                     volume lot size
     * @param pair_decimals           scaling decimal places for pair
     * @param lot_decimals            scaling decimal places for volume
     * @param lot_multiplier          amount to multiply lot volume by to get currency volume
     * @param leverage_buy            array of leverage amounts available when buying
     * @param leverage_sell           array of leverage amounts available when selling
     * @param fees                    fee schedule array in [volume, percent fee] tuples
     * @param fees_maker              maker fee schedule array in [volume, percent fee] tuples (if on maker/taker)
     * @param fee_volume_currency     volume discount currency
     * @param margin_call             margin call level
     * @param margin_stop             stop-out/liquidation margin level
     *
     *                                Note: If an asset pair is on a maker/taker fee schedule, the taker side is given
     *                                in "fees" and maker side in "fees_maker". For pairs not on maker/taker, they will
     *                                only be given in "fees".
     */

    public KrakenAssetPairName(@JsonProperty("altname")String altname, @JsonProperty("aclass_base")String aclass_base, @JsonProperty("base")String base,
                               @JsonProperty("aclass_quote")String aclass_quote, @JsonProperty("quote")String quote, @JsonProperty("lot")String lot,
                               @JsonProperty("pair_decimals")BigDecimal pair_decimals, @JsonProperty("lot_decimals")BigDecimal lot_decimals, @JsonProperty("lot_multiplier")BigDecimal lot_multiplier,
                               @JsonProperty("leverage_buy")List<Integer> leverage_buy, @JsonProperty("leverage_sell")List<Integer> leverage_sell,
                               @JsonProperty("fees")List<KrakenFees> fees, @JsonProperty("fees_maker")List<KrakenFees> fees_maker, @JsonProperty("fee_volume_currency")String fee_volume_currency,
                               @JsonProperty("margin_call")BigDecimal margin_call, @JsonProperty("margin_stop")BigDecimal margin_stop) {
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

    // Getters for variables
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

    public BigDecimal getPair_decimals() {
        return pair_decimals;
    }

    public BigDecimal getLot_decimals() {
        return lot_decimals;
    }

    public BigDecimal getLot_multiplier() {
        return lot_multiplier;
    }

    public List<Integer> getLeverage_buy() {
        return leverage_buy;
    }

    public List<Integer> getLeverage_sell() {
        return leverage_sell;
    }

    public List<KrakenFees> getFees() {
        return fees;
    }

    public List<KrakenFees> getFees_maker() {
        return fees_maker;
    }

    public String getFee_volume_currency() {
        return fee_volume_currency;
    }

    public BigDecimal getMargin_call() {
        return margin_call;
    }

    public BigDecimal getMargin_stop() {
        return margin_stop;
    }

    @Override
    public String toString() {
        return "KrakenAssetPairName{" +
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
