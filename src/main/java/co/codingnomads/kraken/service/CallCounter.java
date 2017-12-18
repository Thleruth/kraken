package co.codingnomads.kraken.service;

import co.codingnomads.kraken.exception.RateLimitException;
import co.codingnomads.kraken.model.ApiAuthentication;
import co.codingnomads.kraken.model.KrakenRequestEnum;
import org.springframework.stereotype.Service;


/**
 * @author Kevin Neag
 */

@Service
public class CallCounter {

    static int rateLimit;
    static int callDecreaser;

    /**
     * Determines the maximum amount of calls to the api the user is allowed to make
     * If exceeded the user will be locked out of the api for 15 minutes
     * @param tierLevel amount of calls a user can make is based on the user's tier level
     * @return the rate limit (number of calls the user can make)
     */

    public static int rateLimitCalc(int tierLevel) {

        switch (tierLevel) {
            case 0:
                return rateLimit = 0;
            case 1:
                return rateLimit = 0;
            case 2:
                return rateLimit = 15;
            case 3:
                return rateLimit = 20;
            case 4:
                return rateLimit = 20;
            default:
                return rateLimit = 0;
        }
    }


    /**
     * Finds the time it takes the user to gain 1 api call back
     * @param tierLevel the time it takes to gain back api calls is based on the user's tier level
     * @return the time it takes to gain 1 api call
     */

    public static int callDecreaserCalc(int tierLevel) {

        switch (tierLevel) {
            case 2:
                return callDecreaser = 3000;
            case 3:
                return callDecreaser = 2000;
            case 4:
                return callDecreaser = 1000;
            default:
                return callDecreaser = 0;
        }
    }

    /**
     * For api calls that exceed the rate limit
     * Throttles the api so that the isUnderRateLimit method always returns true
     * Creates and tracks a backlog for up to 10 different api calls
     * Sleeps each call the required time needed before it will be under the rate limit and can be called
     * @param apiAuthentication
     * @throws RateLimitException
     */

    public static void throttleByTier(ApiAuthentication apiAuthentication) throws RateLimitException {

        //if the backlog is greater than 10 throw custom exception that the backlog is full, please wait at least 30 seconds
        if (apiAuthentication.getBackLog() > 10) {
            throw new RateLimitException("Backlog is full, please wait at least 30 seconds");
        }
        //add one to the backlog
        apiAuthentication.setBackLog(apiAuthentication.getBackLog() + 1);

        try {
            //new variable tierDelay that represents the amount of time to sleep the thread before returning to the method
            int tierDelay;

            //if it is tierLevel 2, tierdelay is three seconds
            if (apiAuthentication.getTierLevel() == 2) {
                tierDelay = 3000;
            }
            //if it is tierlevel 3, tierdelay is 2 seconds
            else if (apiAuthentication.getTierLevel() == 3) {
                tierDelay = 2000;
            }
            //if it is thierlevel 4, tierdelya is 1 second
            else if (apiAuthentication.getTierLevel() == 4) {
                tierDelay = 1000;
            }
            // else tierdelay is the max sleep time
            else {
                tierDelay = 3000;
            }
            System.out.println("Rate Limit Throttled - The Thread will sleep for" + " " + (apiAuthentication.getBackLog() * tierDelay) / 1000 + " " + "seconds");
            //make the thread sleep by the tier delay * the backlog number
            Thread.sleep((apiAuthentication.getBackLog() * tierDelay));
            System.out.println("Thread resumed");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        //subtract one from the backlog after the thread is complete.
        apiAuthentication.setBackLog(apiAuthentication.getBackLog() - 1);
    }


    /**
     * Calculates if the call is runnable, so as not to go over the api rate limit.
     *@param apiAuthentication The parameters needed to authenticate the call
     * @param krakenRequestEnum To determine the number of calls a method charges
     * @return true, if the call is under the rate limit and can be called
     * @throws RateLimitException
     */

    public static boolean isUnderRateLimit(ApiAuthentication apiAuthentication, KrakenRequestEnum krakenRequestEnum) throws RateLimitException {

        // get the number of calls charged from the kraken enum
        int numCallsCharged = krakenRequestEnum.getCallAmount();

        // find the max amount of calls you are able to make based on the tier level
        int rateLimit = rateLimitCalc(apiAuthentication.getTierLevel());

        // the amount of seconds needed to gain 1 call back based on tier level
        int callDecreaser = callDecreaserCalc(apiAuthentication.getTierLevel());

        //the time you are making the call = current time
        long callTime = System.currentTimeMillis();

        // the difference in time between the current time and the time of the last api call
        long timeDifferenceInMillis = (callTime - apiAuthentication.getLastCallTime());


        //callGained is the number of calls a method can gain back
        double callGained = (double) timeDifferenceInMillis / callDecreaser;

        //you can not gain more calls back than the limits given to you by tier
        if (callGained > rateLimit) {
            callGained = rateLimit;
        }

        //new variable  that calculates the updated calls by getting the calls made and subtracting the amount of calls gained
        double updatedCallCounter = (apiAuthentication.getCallCounter() - callGained);

        //call counter can not be less than zero
        if (updatedCallCounter < 0) {
            updatedCallCounter = 0;
        }

        //if the updatedcallCounter and the num of call charged is under the rate limit you can make the call
        if (updatedCallCounter + numCallsCharged < rateLimit) {
            return true;
        } else {
            try {
                System.out.println("Throttle by tier");
                throttleByTier(apiAuthentication);
            } catch (RateLimitException r) {
                System.out.println("RateLimit Exception");
                r.printStackTrace();
                throw r;
            }
            apiAuthentication.setCallCounter(apiAuthentication.getCallCounter()+1);
            apiAuthentication.setLastCallTime(System.currentTimeMillis());
            return true;
        }
    }
}


