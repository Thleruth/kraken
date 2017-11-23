package co.codingnomads.kraken.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static co.codingnomads.kraken.util.Constant.*;

/**
 * Created by Thomas Leruth on 11/23/17
 */

public class SignatureUtil {

    public static byte[] concatArrays(byte[] a, byte[] b) {

        byte[] concat = new byte[a.length + b.length];
        for (int i = 0; i < concat.length; i++) {
            concat[i] = i < a.length ? a[i] : b[i - a.length];
        }

        return concat;
    }

    public static byte[] hmacSha512(byte[] key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_SHA512);
        mac.init(new SecretKeySpec(key, HMAC_SHA512));
        return mac.doFinal(message);
    }

    public static byte[] sha256(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(SHA256);
        return md.digest(stringToBytes(message));
    }

    public static byte[] stringToBytes(String input) {

        if (input == null) {
            System.out.println("ooops");
        }

        return input.getBytes(Charset.forName(UTF8));
    }
}
