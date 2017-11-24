package co.codingnomads.kraken.service;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
// import java.util.Base64;
import org.apache.commons.codec.binary.Base64;

import static co.codingnomads.kraken.util.SignatureUtil.*;

/**
 * Created by Thomas Leruth on 11/23/17
 */

@SuppressWarnings("Depreciated")
public class KrakenSignature {

    static String nonce = String.valueOf(51);
    static String path = "https://www.kraken.com/0/private/Balance";
    static byte[] pathB = stringToBytes(path);
    static String postData = "nonce=" + nonce;
    static String secret = "jRCxEhKYVCmYFrb2NI1gwxh/xmQiRUOKxhjyLWpJXo/qv7PYAZ08qktFokAniDIKBl/wL+RpVRmKrvihptLw1w==";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException{

        byte[] sha256Data = sha256(nonce + postData);
        byte[] hmacKey = Base64.decodeBase64(secret);
        byte[] hmacMessage = concatArrays(pathB, sha256Data);
        byte[] sha512 = hmacSha512(hmacKey, hmacMessage);
        String hmacDigest = Base64.encodeBase64String(sha512);
        System.out.println(hmacDigest);
    }

}
