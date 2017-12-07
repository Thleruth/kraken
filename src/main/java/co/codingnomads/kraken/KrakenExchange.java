package co.codingnomads.kraken;

/**
 * Created by Thomas Leruth on 11/30/17
 */

public class KrakenExchange {

    private String ApiKey;
    private String ApiSecret;
    private int tier;

    //todo constructor with API key, Secret, and tier level

    public KrakenExchange(String apiKey, String apiSecret, int tier) {
        ApiKey = apiKey;
        ApiSecret = apiSecret;
        this.tier = tier;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public String getApiSecret() {
        return ApiSecret;
    }

    public int getTier() {
        return tier;
    }

    //todo one method for each potential KrakenRequest enum item (via the CallAPI)
}
