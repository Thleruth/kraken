package co.codingnomads.kraken.service;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static co.codingnomads.kraken.util.SignatureUtil.*;

/**
 * Created by Thomas Leruth on 11/23/17
 */

@SuppressWarnings("Depreciated")
public class KrakenSignature {

    static String nonce = String.valueOf(9);
    static String path = "https://www.kraken.com/0/private/Balance";
    static byte[] pathB = stringToBytes(path);
    static String postData = "nonce=" + nonce;
    static String secret = "7FROFeUtSh0EewOzkbd/HpZQtZCcIlFTx3tmcuPaSfjhrewC6VnnubhUOh5/az6rrbCaZLCfFFxfgVBsqI7wLQ==";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException{

        byte[] sha256 = sha256(nonce + postData);
        byte[] hmacKey =  Base64.getDecoder().decode(secret);
        byte[] hmacMessage = concatArrays(pathB, sha256);
        String hmacDigest = Base64.getEncoder().encodeToString(hmacSha512(hmacKey, hmacMessage));
        System.out.println(hmacDigest);
    }

}
