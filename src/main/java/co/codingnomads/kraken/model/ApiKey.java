package co.codingnomads.kraken.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Kevin Neag
 */
public class ApiKey {


    private String apiKey;
    private int tierLevel;
    private int callCounter;
    private String secret;
    private Timestamp lastCallTime = Timestamp.valueOf("2017-12-06 10:09:30");
    private int backLog;



    public ApiKey(String apiKey, int tierLevel, String secret) {
        this.apiKey = "Enter API key";
        this.tierLevel = 2;
        this.callCounter = 200;
        this.secret = "Enter API Secret";
        this.backLog = 0;

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