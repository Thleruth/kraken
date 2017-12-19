//package co.codingnomads.kraken.model.trade.request;
//
//import co.codingnomads.kraken.model.RequestBodyGeneric;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * @author Kevin Neag
// */
//
//public class AddStandardOrderRequestBody extends RequestBodyGeneric{
//
//
//    String pair;
//    String type;
//    String ordertype;
//    String price; // Price (optional.  dependent upon ordertype)
//    String price2; // Secondary price (optional.  dependent upon ordertype)
//    double volume;  // Order volume in lots
//    String leverage;  // Amount of leverage desired (optional, default = none)
//    String oflags; // Comma delimited list of order flags (optional)
//    String starttm; // Scheduled start time (optional): 0 = now (default), +<n> = schedule start time <n> seconds from now,
//    String expiretm; // Expiration time (optional): 0 = no expiration (default), +<n> = expire <n> seconds from now
//    String userref; // User reference id, 32-bit signed number (optional)
//    Boolean validate; // Validate inputs only, do not submit order (optional)
//    Map<String,String> closeInfo; // optional closing order to add to system when order gets filled:
////    close[ordertype] = order type
////    close[price] = price
////    close[price2] = secondary price
//
//
////    public AddStandardOrderRequestBody(String pair, String type, String ordertype, String price,
////                                       String price2, int volume, String leverage, String oflags,
////                                       String starttm, String expiretm, String userref, Boolean validate) {
////        this.pair = pair;
////        this.type = type;
////        this.ordertype = ordertype;
////        if (null != price) {
////            this.price = price;
////        }
////        if (null != price2) {
////            this.price2 = price2;
////        }
////        this.volume = volume;
////        if (null != leverage) {
////            this.leverage = leverage;
////        }
////        if (null != oflags) {
////            this.oflags = oflags;
////        }
////        if (null != starttm) {
////            this.starttm = starttm;
////        }
////        if (null != expiretm) {
////            this.expiretm = expiretm;
////        }
////        if (null != userref) {
////            this.userref = userref;
////        }
////        if (null != validate) {
////            this.validate = validate;
////        }
////    }
////
//    public AddStandardOrderRequestBody(String pair, String type, String ordertype, String price,
//                                       String price2, int volume, String leverage, String oflags,
//                                       String starttm, String expiretm, String userref, Boolean validate,
//                                       Map<String, String> closeInfo) {
//        this.pair = pair;
//        this.type = type;
//        this.ordertype = ordertype;
//        if (null != price) {
//            this.price = price;
//        }
//        if (null != price2) {
//            this.price2 = price2;
//        }
//        this.volume = volume;
//        if (null != leverage) {
//            this.leverage = leverage;
//        }
//        if (null != oflags) {
//            this.oflags = oflags;
//        }
//        if (null != starttm) {
//            this.starttm = starttm;
//        }
//        if (null != expiretm) {
//            this.expiretm = expiretm;
//        }
//        if (null != userref) {
//            this.userref = userref;
//        }
//        if (null != validate) {
//            this.validate = validate;
//        }
//        if (null != closeInfo) {
//            this.closeInfo = closeInfo;
//        }
//    }
//
//
//    public String getPair() {
//        return pair;
//    }
//
//    public void setPair(String pair) {
//        this.pair = pair;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getOrdertype() {
//        return ordertype;
//    }
//
//    public void setOrdertype(String ordertype) {
//        this.ordertype = ordertype;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public void setPrice(String price) {
//        this.price = price;
//    }
//
//    public String getPrice2() {
//        return price2;
//    }
//
//    public void setPrice2(String price2) {
//        this.price2 = price2;
//    }
//
//    public double getVolume() {
//        return volume;
//    }
//
//    public void setVolume(double volume) {
//        this.volume = volume;
//    }
//
//    public String getLeverage() {
//        return leverage;
//    }
//
//    public void setLeverage(String leverage) {
//        this.leverage = leverage;
//    }
//
//    public String getOflags() {
//        return oflags;
//    }
//
//    public void setOflags(String oflags) {
//        this.oflags = oflags;
//    }
//
//    public String getStarttm() {
//        return starttm;
//    }
//
//    public void setStarttm(String starttm) {
//        this.starttm = starttm;
//    }
//
//    public String getExpiretm() {
//        return expiretm;
//    }
//
//    public void setExpiretm(String expiretm) {
//        this.expiretm = expiretm;
//    }
//
//    public String getUserref() {
//        return userref;
//    }
//
//    public void setUserref(String userref) {
//        this.userref = userref;
//    }
//
//    public Boolean getValidate() {
//        return validate;
//    }
//
//    public void setValidate(Boolean validate) {
//        this.validate = validate;
//    }
//
//    public Map<String, String> getCloseInfo() {
//        return closeInfo;
//    }
//
//    public void setCloseInfo(Map<String,String> closeInfo) {
//        this.closeInfo = closeInfo;
//    }
//
//public static class AddStandardOrderBuilder {
//
//    String pair;
//    String type;
//    String ordertype;
//    String price;
//    String price2;
//    double volume;
//    String leverage;
//    String oflags;
//    String starttm;
//    String expiretm;
//    String userref;
//    Boolean validate;
//    Map<String,String> closeorder;
//
//    public AddStandardOrderBuilder(String pair1, String s, String pair, String type,
//                                   String ordertype, double volume, String leverage, String oflags,
//                                   String starttm, String expiretm, String userref, Boolean validate,
//                                   Map<String, String> closeorder) {
//        this.pair = pair;
//        this.type = type;
//        this.ordertype = ordertype;
//        this.volume = volume;
//        this.oflags = "nompp";
//        this.starttm = "0";
//        this.expiretm = "0";
//        this.validate = false;
//    }
//
//    public AddStandardOrderBuilder withPrice(String price) {
//
//        this.price = price;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withSecondaryPrice(String price2) {
//
//        this.price2 = price2;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withLeverage(String leverage) {
//
//        this.leverage = leverage;
//        return this;
//    }
//
//
//    public AddStandardOrderBuilder withOrderFlags(String oflags) {
//
//        this.oflags = oflags;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withStartTime(String starttm) {
//
//        this.starttm = starttm;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withExpireTime(String expiretm) {
//
//        this.expiretm = expiretm;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withUserRefId(String userref) {
//
//        this.userref = userref;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withValidateOnly(boolean validate) {
//
//        this.validate = validate;
//        return this;
//    }
//
//    public AddStandardOrderBuilder withCloseOrder(String orderType, String price, String secondaryPrice) {
//
//        closeorder = new HashMap<>();
//        closeorder.put("ordertype", orderType.toString());
//        closeorder.put("price", price);
//        closeorder.put("price2", secondaryPrice);
//        return this;
//    }
//
//    public AddStandardOrderBuilder buildOrder() {
//
//        return new AddStandardOrderBuilder(pair, type, ordertype, price, price2, volume, leverage, oflags, starttm,
//                expiretm, userref, validate, closeorder);
//    }
//
//}
//
//    @Override
//    public MultiValueMap<String, String> postParam() {
//        MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
//        postParameters.add("nonce", getNonce());
//        postParameters.add("pair", getPair());
//        postParameters.add("type", getType());
//        postParameters.add("ordertype", getOrdertype());
//        if(null != price) {
//            postParameters.add("price", String.valueOf(getPrice()));
//        }
//        if(null != price2) {
//            postParameters.add("price2", String.valueOf(getPrice2()));
//        }
//        postParameters.add("volume", String.valueOf(getVolume()));
//        if(null != leverage) {
//            postParameters.add("leverage", getLeverage());
//        }
//        if(null != oflags) {
//            postParameters.add("oflags", getOflags());
//        }
//        if(null != starttm) {
//            postParameters.add("starttm", getStarttm());
//        }
//        if(null != expiretm) {
//            postParameters.add("expiretm", getExpiretm());
//        }
//        if(null != userref) {
//            postParameters.add("userref", getUserref());
//        }
//        if(null != validate) {
//            postParameters.add("validate", String.valueOf(getValidate()));
//        }
//        if(null != closeInfo) {
//            postParameters.add("closeInfo", String.valueOf(getCloseInfo()));
//        }
//        return postParameters;
//    }
//
//    @Override
//    public String signPostParam() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("nonce").append("=").append(getNonce());
//        sb.append("&").append("pair").append("=").append(getPair());
//        sb.append("&").append("type").append("=").append(getType());
//        sb.append("&").append("ordertype").append("=").append(getOrdertype());
//        if (null != price) {
//            sb.append("&").append("price").append("=").append(getPrice());
//        }
//        if (null != price) {
//            sb.append("&").append("price2").append("=").append(getPrice2());
//        }
//        sb.append("&").append("volume").append("=").append(getVolume());
//        if (null != leverage) {
//            sb.append("&").append("leverage").append("=").append(getLeverage());
//        }
//        sb.append("&").append("volume").append("=").append(getPrice2());
//        if (null != oflags) {
//            sb.append("&").append("oflags").append("=").append(getOflags());
//        }
//        if (null != starttm) {
//            sb.append("&").append("starttm").append("=").append(getStarttm());
//        }
//        if (null != expiretm) {
//            sb.append("&").append("expiretm").append("=").append(getExpiretm());
//        }
//        if (null != userref) {
//            sb.append("&").append("userref").append("=").append(getUserref());
//        }
//        if (null != validate) {
//            sb.append("&").append("validate").append("=").append(getValidate());
//        }
//        if (null != closeInfo) {
//            sb.append("&").append("closeInfo").append("=").append(getCloseInfo());
//        }
//        return sb.toString();
//    }
//}
