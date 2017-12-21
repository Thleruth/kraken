package co.codingnomads.kraken.model.trade.request;

import co.codingnomads.kraken.model.RequestBodyGeneric;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.Map;


/**
 * @author Kevin Neag
 */

public class AddStandardOrderRequestBody extends RequestBodyGeneric {

    String pair;
    String type;
    String ordertype;
    String price; // Price (optional.  dependent upon ordertype)
    String price2; // Secondary price (optional.  dependent upon ordertype)
    double volume;  // Order volume in lots
    String leverage;  // Amount of leverage desired (optional, default = none)
    String oflags; // Comma delimited list of order flags (optional)
    String starttm; // Scheduled start time (optional): 0 = now (default), +<n> = schedule start time <n> seconds from now,
    String expiretm; // Expiration time (optional): 0 = no expiration (default), +<n> = expire <n> seconds from now
    String userref; // User reference id, 32-bit signed number (optional)
    Boolean validate; // Validate inputs only, do not submit order (optional)
    Map<String,String> closeInfo; // optional closing order to add to system when order gets filled:

    //minimum constructor for basic parameters
    public AddStandardOrderRequestBody(String pair, String type, String ordertype, double volume) {
        this.pair = pair;
        this.type = type;
        this.ordertype = ordertype;
        this.volume = volume;
    }

    //fully qualified constructor, enter null for fields you wish to exclude depending on fields you wish to include
    //see Api documentation for more information  https://api.kraken.com/0/private/AddOrder
    public AddStandardOrderRequestBody(String pair, String type, String ordertype, String price, String price2,
                                       double volume, String leverage, String oflags, String starttm, String expiretm,
                                       String userref, Boolean validate, Map<String, String> closeInfo) {
        this.pair = pair;
        this.type = type;
        this.ordertype = ordertype;
        if(price != null) {
            this.price = price;
        }
        if(price2 != null) {
            this.price2 = price2;
        }
        this.volume = volume;

        if(leverage != null) {
            this.leverage = leverage;
        }
        if(oflags != null) {
            this.oflags = oflags;
        }
        if(starttm != null) {
            this.starttm = starttm;
        }
        if(expiretm != null) {
            this.expiretm = expiretm;
        }
        if(userref != null) {
            this.userref = userref;
        }
        if(validate != null) {
            this.validate = validate;
        }
        if(closeInfo != null) {
            this.closeInfo = closeInfo;
        }
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
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

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public Map<String, String> getCloseInfo() {
        return closeInfo;
    }

    public void setCloseInfo(Map<String, String> closeInfo) {
        this.closeInfo = closeInfo;
    }

    @Override
    public String signPostParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("nonce").append("=").append(getNonce());
        sb.append("&").append("pair").append("=").append(getPair());
        sb.append("&").append("type").append("=").append(getType());
        sb.append("&").append("ordertype").append("=").append(getOrdertype());
        if (null != price) {
            sb.append("&").append("price").append("=").append(getPrice());
        }
        if (null != price2) {
            sb.append("&").append("price2").append("=").append(getPrice2());
        }

        sb.append("&").append("volume").append("=").append(getVolume());

        if (null != leverage) {
            sb.append("&").append("leverage").append("=").append(getLeverage());
        }
        if (null != oflags) {
            sb.append("&").append("oflags").append("=").append(getOflags());
        }
        if (null != starttm) {
            sb.append("&").append("starttm").append("=").append(getStarttm());
        }
        if (null != expiretm) {
            sb.append("&").append("expiretm").append("=").append(getExpiretm());
        }
        if (null != userref) {
            sb.append("&").append("userref").append("=").append(getUserref());
        }
        if (null != validate) {
            sb.append("&").append("validate").append("=").append(getValidate());
        }
       if (null != closeInfo) {
           sb.append("&").append("closeInfo").append("=").append(getCloseInfo());
       }
        return sb.toString();
    }

    @Override
    public MultiValueMap<String, String> postParam() {
        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("nonce", getNonce());
        postParameters.add("pair", getPair());
        postParameters.add("type", getType());
        postParameters.add("ordertype", getOrdertype());
        if(null != price) {
            postParameters.add("price", String.valueOf(getPrice()));
        }
        if(null != price2) {
            postParameters.add("price2", String.valueOf(getPrice2()));
        }
        postParameters.add("volume", String.valueOf(getVolume()));
        if(null != leverage) {
            postParameters.add("leverage", getLeverage());
        }
        if(null != oflags) {
            postParameters.add("oflags", getOflags());
        }
        if(null != starttm) {
            postParameters.add("starttm", getStarttm());
        }
        if(null != expiretm) {
            postParameters.add("expiretm", getExpiretm());
        }
        if(null != userref) {
            postParameters.add("userref", getUserref());
        }
        if(null != validate) {
            postParameters.add("validate", String.valueOf(getValidate()));
        }
        if(null != closeInfo) {
            postParameters.add("closeInfo", String.valueOf(getCloseInfo()));
        }
        return postParameters;
    }
}
