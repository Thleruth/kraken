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


    //switch statement to find the api rate limit based on the tier level of the user

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
                rateLimit = 0;
                break;

        }
        return rateLimit;
    }


    //switch statement to find the rate at witch the api gains calls based on tier level

    public static int callDecreaserCalc(int tierLevel) {

        switch (tierLevel) {

            case 2:
                return callDecreaser = 3000;
            case 3:
                return callDecreaser = 2000;
            case 4:
                return callDecreaser = 1000;
            default:
                callDecreaser = 0;
                break;
        }
        return callDecreaser;
    }


    //method to track the backlogger by tier level
    public static void throttleByTier(ApiAuthentication apiAuthentication) throws RateLimitException {

        //if backlog greater than 10 throw custom exception that the backlog is full, please wait at least 30 seconds
        //we do not want the backlog to be greater than 10

        if (apiAuthentication.getBackLog() > 10) {


            throw new RateLimitException("Backlog is full, please wait at least 30 seconds");
        }
        //add one to the backlog
        apiAuthentication.setBackLog(apiAuthentication.getBackLog() + 1);


        try {
            //modify this by tier level
            //sout the amount of time that the thread will sleep
            //after the sleep sout thread resumed
            //new variable tierDelay that represents the amount of time to wait the thread before returning to the method
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
            // else tierdelay is zero
            else {

                tierDelay = 3000;
            }
            //print out the time the thread will sleep so the user knows
            System.out.println("Rate Limit Throttled - The Thread will sleep for" + " " + (apiAuthentication.getBackLog() * tierDelay) / 1000 + " "+"seconds");

            //make the thread sleep by the tier delay * the backlog number
            //so if 6 threads were in the queue and the last thread was tier 2 the thread would sleep for 18 seconds
            Thread.sleep((apiAuthentication.getBackLog() * tierDelay));

            //print out that the thread is resumed
            System.out.println("Thread resumed");

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        //subtract one from the backlog after the thread runs because it is no longer in the backlog
        apiAuthentication.setBackLog(apiAuthentication.getBackLog() - 1);
    }


    //methods returns true if the api can be called, and returns false if the api can not be called

    public static boolean isUnderRateLimit(ApiAuthentication apiAuthentication, KrakenRequestEnum krakenRequestEnum) throws RateLimitException {


        // get the number of calls charged / method taken in by the kraken enum
        int numCallsCharged = krakenRequestEnum.getCallAmount();


        // find the max amount of calls you are able to make based on the tier level
        int rateLimit = rateLimitCalc(apiAuthentication.getTierLevel());

        // the amount of seconds needed to gain 1 call back based on tier level
        int callDecreaser = callDecreaserCalc(apiAuthentication.getTierLevel());

        //the time you are making the call = current time
        long callTime = System.currentTimeMillis();

        // the difference in time between the current time and the time of the last api call
        long timeDifferenceInMillis = (callTime - apiAuthentication.getLastCallTime().getTime());


        //callGained is the maxNumber of calls a method can get back
        //set the timeDifference in Millis / the call decreaser / 1000 to get how many calls you can gain back
        double callGained = (double) timeDifferenceInMillis / callDecreaser;

        //you can not gain more calls back than the limits given to you by tier
        if (callGained > rateLimit) {

            callGained = rateLimit;
        }

        //new variable  that calcs the updated calls by getting the calls made and subtracting the amount of calls gained
        double updatedCallCounter = (apiAuthentication.getCallCounter() - callGained);

        //call counter can not be less than zero
        if (updatedCallCounter < 0) {

            updatedCallCounter = 0;
        }

        //if the updatedcallCounter and the num of call charged is under the rate limit you can make the call
        if (updatedCallCounter + numCallsCharged < rateLimit) {
            System.out.println("return true");
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

            return true;
        }
    }
}


