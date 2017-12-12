package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AddStandardOrderRequestBody extends RequestBodyGeneric{

    // KrakenAsset pair
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

//    optional closing order to add to system when order gets filled:
//    close[ordertype] = order type
//    close[price] = price
//    close[price2] = secondary price


    public AddStandardOrderRequestBody(String pair, String type, String ordertype, String price,
                                       String price2, String volume, String leverage,
                                       String oflags, String starttm, String expiretm,
                                       String userref, String validate) {
        this.pair = pair;
        this.type = type;
        this.ordertype = ordertype;
        this.price = price;
        this.price2 = price2;
        this.volume = volume;
        this.leverage = leverage;
        this.oflags = oflags;
        this.starttm = starttm;
        this.expiretm = expiretm;
        this.userref = userref;
        this.validate = validate;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getOflags() {
        return oflags;
    }

    public void setOflags(String oflags) {
        this.oflags = oflags;
    }

    public String getStarttm() {
        return starttm;
    }

    public void setStarttm(String starttm) {
        this.starttm = starttm;
    }

    public String getExpiretm() {
        return expiretm;
    }

    public void setExpiretm(String expiretm) {
        this.expiretm = expiretm;
    }

    public String getUserref() {
        return userref;
    }

    public void setUserref(String userref) {
        this.userref = userref;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    @Override
    public MultiValueMap<String, String> postParam(){
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
        postParameters.add("nonce", super.getNonce());
        postParameters.add("pair", getPair());
        postParameters.add("type", getType());
        postParameters.add("ordertype", getOrdertype());
        postParameters.add("price", getPrice());
        postParameters.add("price2", getPrice2());
        postParameters.add("volume", getVolume());
        postParameters.add("leverage", getLeverage());
        postParameters.add("oflags", getOflags());
        postParameters.add("starttm", getStarttm());
        postParameters.add("expiretm", getExpiretm());
        postParameters.add("userref", getUserref());
        postParameters.add("validate", getValidate());
        return postParameters;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        sb.append("&").append("pair").append("=").append(getPair());
        sb.append("&").append("type").append("=").append(getType());
        sb.append("&").append("ordertype").append("=").append(getOrdertype());
        sb.append("&").append("price").append("=").append(getPrice());
        sb.append("&").append("price2").append("=").append(getPrice2());
        sb.append("&").append("volume").append("=").append(getVolume());
        sb.append("&").append("leverage").append("=").append(getLeverage());
        sb.append("&").append("volume").append("=").append(getPrice2());
        sb.append("&").append("oflags").append("=").append(getOflags());
        sb.append("&").append("starttm").append("=").append(getStarttm());
        sb.append("&").append("expiretm").append("=").append(getExpiretm());
        sb.append("&").append("userref").append("=").append(getUserref());
        sb.append("&").append("validate").append("=").append(getValidate());
        return sb.toString();
    }
}
