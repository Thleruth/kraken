package co.codingnomads.kraken.model.market;

/*
created by PopoPenguin on 11/29/17
*/

import co.codingnomads.kraken.model.market.Fees;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
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
    BigDecimal margin_call;
    BigDecimal margin_stop;
    BigDecimal volumeMultiplier;

    public AssetPairName(@JsonProperty("altname") String altname, @JsonProperty("aclass_base") String classBase, @JsonProperty("base") String base,
                         @JsonProperty("aclass_quote") String classQuote, @JsonProperty("quote") String quote, @JsonProperty("lot") String volumeLotSize,
                         @JsonProperty("pair_decimals") int pairScale, @JsonProperty("lot_decimals") int volumeLotScale,
                         @JsonProperty("lot_multiplier") BigDecimal volumeMultiplier,
                         @JsonProperty("fees") List<Fees> fees, @JsonProperty("fees_maker") List<Fees> fees_maker, @JsonProperty("fee_volume_currency") String feeVolumeCurrency,
                         @JsonProperty("margin_call") BigDecimal marginCall, @JsonProperty("margin_stop") BigDecimal marginStop) {
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
        this.volumeMultiplier = volumeMultiplier;
    }

    public String getAltname() {
        return altname;
    }

    public void setAltname(String altname) {
        this.altname = altname;
    }

    public String getAclass_base() {
        return aclass_base;
    }

    public void setAclass_base(String aclass_base) {
        this.aclass_base = aclass_base;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getAclass_quote() {
        return aclass_quote;
    }

    public void setAclass_quote(String aclass_quote) {
        this.aclass_quote = aclass_quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public int getPair_decimals() {
        return pair_decimals;
    }

    public void setPair_decimals(int pair_decimals) {
        this.pair_decimals = pair_decimals;
    }

    public int getLot_decimals() {
        return lot_decimals;
    }

    public void setLot_decimals(int lot_decimals) {
        this.lot_decimals = lot_decimals;
    }

    public int getLot_multiplier() {
        return lot_multiplier;
    }

    public void setLot_multiplier(int lot_multiplier) {
        this.lot_multiplier = lot_multiplier;
    }

    public List<Integer> getLeverage_buy() {
        return leverage_buy;
    }

    public void setLeverage_buy(List<Integer> leverage_buy) {
        this.leverage_buy = leverage_buy;
    }

    public List<Integer> getLeverage_sell() {
        return leverage_sell;
    }

    public void setLeverage_sell(List<Integer> leverage_sell) {
        this.leverage_sell = leverage_sell;
    }

    public List<Fees> getFees() {
        return fees;
    }

    public void setFees(List<Fees> fees) {
        this.fees = fees;
    }

    public List<Fees> getFees_maker() {
        return fees_maker;
    }

    public void setFees_maker(List<Fees> fees_maker) {
        this.fees_maker = fees_maker;
    }

    public String getFee_volume_currency() {
        return fee_volume_currency;
    }

    public void setFee_volume_currency(String fee_volume_currency) {
        this.fee_volume_currency = fee_volume_currency;
    }

    public BigDecimal getMargin_call() {
        return margin_call;
    }

    public void setMargin_call(BigDecimal margin_call) {
        this.margin_call = margin_call;
    }

    public BigDecimal getMargin_stop() {
        return margin_stop;
    }

    public void setMargin_stop(BigDecimal margin_stop) {
        this.margin_stop = margin_stop;
    }

    public BigDecimal getVolumeMultiplier() {
        return volumeMultiplier;
    }

    public void setVolumeMultiplier(BigDecimal volumeMultiplier) {
        this.volumeMultiplier = volumeMultiplier;
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
                ", volumeMultiplier=" + volumeMultiplier +
                '}';
    }
}
