package co.codingnomads.kraken.model;

import java.sql.Timestamp;

/**
 * @author Kevin Neag
 */

public class ApiAuthentication {

    private String apiKey;
    // private String apiEndPoint;
    private int tierLevel;
    private int callCounter;
    private String secret;
    // private boolean wasSent;
    private Timestamp lastCallTime;
    private int backLog;

    //todo lastCallTime has to be fixed
    public ApiAuthentication(String apiKey, int tierLevel, String secret) {
        this.apiKey = apiKey;
        this.tierLevel = tierLevel;
        this.callCounter = 0;
        this.secret = secret;
        this.backLog = 0;
        lastCallTime = Timestamp.valueOf("2017-12-06 10:09:30");
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(int tierLevel) {
        this.tierLevel = tierLevel;
    }

    public int getCallCounter() {
        return callCounter;
    }


    public void setCallCounter(int callCounter) {
        this.callCounter = callCounter;
    }

    public Timestamp getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(Timestamp lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getBackLog() {
        return backLog;
    }

    public void setBackLog(int backLog) {
        this.backLog = backLog;
    }
}