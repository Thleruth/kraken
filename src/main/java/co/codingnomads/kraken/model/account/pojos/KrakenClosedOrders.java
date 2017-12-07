package co.codingnomads.kraken.model.account.pojos;

public class KrakenClosedOrders {
    /**
     * Created by Meghan Boyce on 12/07/17
     * this includes all fields from get open orders
     */

    // Array of GetOpenOrdersOutput info.
    String[] closed;
    // Additional fields:
    // Unix timestamp of when GetOpenOrdersOutput was closed
    String closetm;
    // Additional info on status (if any)
    String reason;

    // Amount of available GetOpenOrdersOutput info matching criteria
    String count;

}
