package co.codingnomads.kraken.model.trade;

import co.codingnomads.kraken.model.RequestBodyGeneric;

public class AddStandardOrderRequestBody extends RequestBodyGeneric{

    // Asset pair
    String pair;
    // Type of order (buy/sell)
    String type;
    // see Kraken API documentation for ordertype options
    String ordertype;
    // Price (optional.  dependent upon ordertype)
    String price;
    // Secondary price (optional.  dependent upon ordertype)
    String price2;
    // Order volume in lots
    String volume;
    // Amount of leverage desired (optional, default = none)
    String leverage;
    // Comma delimited list of order flags (optional)
    String oflags;
    // Scheduled start time (optional): 0 = now (default), +<n> = schedule start time <n> seconds from now,
    String starttm;
    // Expiration time (optional): 0 = no expiration (default), +<n> = expire <n> seconds from now
    String expiretm;
    // User reference id, 32-bit signed number (optional)
    String userref;
    // Validate inputs only, do not submit order (optional)
    String validate;

    // TODO: What is this?
//    optional closing order to add to system when order gets filled:
//    close[ordertype] = order type
//    close[price] = price
//    close[price2] = secondary price

}
