package model;

import org.springframework.http.HttpMethod;

public abstract class KrakenRequestGeneric {

    final private static String DOMAIN = "https://api.kraken.com";
    private String endPoint;
    //GET, POST;
    private HttpMethod requestType;

    public KrakenRequestGeneric(String endPoint, HttpMethod requestType) {
        this.endPoint = endPoint;
        this.requestType = requestType;
    }

    public KrakenRequestGeneric() {
    }

    public static String getDOMAIN() {
        return DOMAIN;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public HttpMethod getRequestType() {
        return requestType;
    }

    public void setRequestType(HttpMethod requestType) {
        this.requestType = requestType;
    }
}

