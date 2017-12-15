package co.codingnomads.kraken.model;



/**
 * @author Kevin Neag
 */

public class ApiAuthentication {

    /**
     * The basic parameters needed to authenticate a call to the api
     */

    private String apiKey;
    private int tierLevel;
    private int callCounter;
    private String secret;
    private long lastCallTime;
    private int backLog;

    public ApiAuthentication(String apiKey, int tierLevel, String secret) {
        this.apiKey = apiKey;
        this.tierLevel = tierLevel;
        this.callCounter = 0;
        this.secret = secret;
        this.backLog = 0;
        lastCallTime = System.currentTimeMillis();
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

    public long getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(long lastCallTime) {
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