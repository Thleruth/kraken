package co.codingnomads.kraken.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

import static co.codingnomads.kraken.util.DataTransformationUtil.*;
import static co.codingnomads.kraken.util.EncodingUtil.*;

/**
 * Created by Thomas Leruth on 11/23/17
 */

public class KrakenSignature {

    static String nonce = String.valueOf(System.currentTimeMillis());
    static String path = "/0/private/Balance"; //must be endpoint
    static String postData = "nonce=" + nonce;
    static String secret = "Enter Secret here";

    /**
     * Make the API-Sign based on Kraken requirment
     * @return the message to be used for POST request headers
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    // need to be reworked once the controller is finished
    // nonce should be received from the HttpBody
    // postData is the HttpBody
    // secret should a global variable in the global response handler (should be first thing)
    // path should be received from RequestType
    public static String ApiSignCreator() throws NoSuchAlgorithmException, InvalidKeyException {

        byte[] sha256Data = sha256(nonce + postData);
        byte[] hmacKey = Base64.decodeBase64(secret);
        byte[] hmacMessage = concatByteArrays(stringToBytes(path), sha256Data);
        byte[] sha512 = hmacSha512(hmacKey, hmacMessage);
        String hmacDigest = Base64.encodeBase64String(sha512);
        return hmacDigest;
    }

}
