package co.codingnomads.kraken;

import co.codingnomads.kraken.model.ApiAuthentication;

/**
 * Created by Thomas Leruth on 11/30/17
 */

public class KrakenExchange {

    ApiAuthentication apiAuthentication;

    //todo constructor with API key, Secret, and tier level

    public KrakenExchange(String apiKey, String apiSecret, int tier) {
        apiAuthentication = new ApiAuthentication(apiKey, tier, apiSecret);
    }

    public ApiAuthentication getApiAuthentication() {
        return apiAuthentication;
    }

    //todo one method for each potential KrakenRequest enum item (via the CallAPI)
}
