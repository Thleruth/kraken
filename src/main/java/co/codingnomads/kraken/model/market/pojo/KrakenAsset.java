package co.codingnomads.kraken.model.market.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * created by Jialor Cheung on 12/12/17
 *
 * This is the information body, KrakenAsset POJO, for the result list of objects in
 * api call GetAssetInfo <url>https://api.kraken.com/0/public/Assets</url>
 *
 * Kraken API Documentation for this call can be found  <url>https://www.kraken.com/help/api#get-asset-info</url>
 */

public class KrakenAsset {

    private final String altname;
    private final String aclass;

    //using BigDecimal format for most accurate data type associated to monetary values
    private final BigDecimal decimals;
    private final BigDecimal display_decimals;

    /**
     * Fully Qualified Constructor
     *
     * @param altname   alternate name
     * @param aclass    asset class
     * @param decimals  scaling decimal places for record keeping
     * @param display_decimals  scaling decimal places for output display
     */

    public KrakenAsset(@JsonProperty("altname")String altname,@JsonProperty("aclass") String aclass,
                       @JsonProperty("decimals") BigDecimal decimals,@JsonProperty("display_decimals") BigDecimal display_decimals) {
        this.altname = altname;
        this.aclass = aclass;
        this.decimals = decimals;
        this.display_decimals = display_decimals;
    }

    // Getters for variables
    public String getAltname() {
        return altname;
    }

    public String getAclass() {
        return aclass;
    }

    public BigDecimal getDecimals() {
        return decimals;
    }

    public BigDecimal getDisplay_decimals() {
        return display_decimals;
    }


    @Override
    public String toString() {
        return "KrakenAsset{" +
                "altname='" + altname + '\'' +
                ", aclass='" + aclass + '\'' +
                ", decimals=" + decimals +
                ", display_decimals=" + display_decimals +
                '}';
    }
}
