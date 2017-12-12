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

    /**
     * Make the API-Sign based on Kraken requirement
     * @return the message to be used for POST request headers
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String ApiSignCreator(String nonce, String postData, String apiSecret, String path) {

        try {
            byte[] sha256Data = sha256(nonce + postData);
            byte[] hmacKey = Base64.decodeBase64(apiSecret);
            byte[] hmacMessage = concatByteArrays(stringToBytes(path), sha256Data);
            byte[] sha512 = hmacSha512(hmacKey, hmacMessage);
            String hmacDigest = Base64.encodeBase64String(sha512);
            return hmacDigest;
        }
        catch (Exception x){
            x.printStackTrace();
            return null;
        }
    }

}
