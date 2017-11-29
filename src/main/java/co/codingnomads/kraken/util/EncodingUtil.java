package co.codingnomads.kraken.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static co.codingnomads.kraken.util.Constant.*;
import static co.codingnomads.kraken.util.DataTransformationUtil.stringToBytes;

/**
 * Created by Thomas Leruth on 11/23/17
 */

public class EncodingUtil {

    /**
     * Encode message into sha512 with a given key
     * @param key
     * @param message
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static byte[] hmacSha512(byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA512);
        mac.init(new SecretKeySpec(key, HMAC_SHA512));
        return mac.doFinal(message);
    }

    /**
     * Encode message into sha256
     * @param message
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] sha256(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(SHA256);
        return md.digest(stringToBytes(message));
    }

}
