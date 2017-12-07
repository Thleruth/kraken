package co.codingnomads.kraken.model.account.pojos;

import java.math.BigDecimal;

public class KrakenOpenOrders {
    /**
     * Created by Meghan Boyce on 12/07/17
     *
     */

    // Referral order transaction id for order
    String refid;
    // User reference id
    String userref;
    // Status of order (pending, open, closed, canceled, expired)
    // Xchange made status an enum.
    String status;
    // Unix timestamp of when order was placed
    double opentm;
    // Unix timestamp of order start time (or 0 if not set)
    double starttm;
    // Unix timestamp of order end time (or 0 if not set)
    double expiretm;
    // Order description info
    KrakenOrderDescription descr;
    // Volume of order (base currency unless viqc set in oflags)
    BigDecimal vol;
    // Volume executed (base currency unless viqc set in oflags)
    BigDecimal vol_exec;
    // Total cost (quote currency unless unless viqc set in oflags)
    BigDecimal cost;
    // Total fee (quote currency)
    BigDecimal fee;
    // Average price (quote currency unless viqc set in oflags)
    BigDecimal price;
    // Stop price (quote currency, for trailing stops)
    BigDecimal stopprice;
    // Triggered limit price (quote currency, when limit based order type triggered)
    BigDecimal limitprice;
    // Comma delimited list of miscellaneous info:
    // stopped (triggered by stop price), touched (triggered by touch price),
    // liquidated, partial(partial fill)
    String misc;
    // Order flags, comma delimited list:
    // viqc = volume in quote currency,
    // fcib = prefer fee in base currency (default if selling)
    // fciq = prefer fee in quote currency (default if buying)
    // nompp = no market price protection
    //Xchange does Set<KrakenOrderFlags> oflags - KrakenOrderFlags is enum
    String oflags;
    // Array of trade ids related to order (if trades info requested and data available)
    //Xchange does List<String> trades
    String[]trades;

}
