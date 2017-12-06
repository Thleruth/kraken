package co.codingnomads.kraken.service;

import co.codingnomads.kraken.util.TempConstant;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;

/**
 * Created by Thomas Leruth on 12/4/17
 */

public class Test {


    static String key = TempConstant.ApiKey;
    static String secret = TempConstant.ApiSecret;
    String nonce, signature, data, path;
    static String domain = "https://api.kraken.com";

    public static void main(String[] args) {
        Test a = new Test();
        a.account_balance();
    }

    void account_balance() {
        nonce = String.valueOf(System.currentTimeMillis());
        data = "nonce=" + nonce;
        path = "/0/private/Balance";
        calculateSignature();
        String answer = post(domain + path, data);
        System.out.println(answer);
    }

    String post(String address, String output) {
        String answer = "";
        HttpsURLConnection c = null;
        try {
            URL u = new URL(address);
            c = (HttpsURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setRequestProperty("API-Key", key);
            c.setRequestProperty("API-Sign", signature);
            c.setDoOutput(true);
            DataOutputStream os = new DataOutputStream(c.getOutputStream());
            os.writeBytes(output);
            os.flush();
            os.close();
            BufferedReader br = null;
            if (c.getResponseCode() >= 400) {
                System.exit(1);
            }
            br = new BufferedReader(new InputStreamReader((c.getInputStream())));
            String line;
            while ((line = br.readLine()) != null)
                answer += line;
        } catch (Exception x) {
            System.exit(1);
        } finally {
            c.disconnect();
        }

        return answer;
    }

    void calculateSignature() {
        signature = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((nonce + data).getBytes());
            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(new SecretKeySpec(Base64.decodeBase64(secret.getBytes()), "HmacSHA512"));
            mac.update(path.getBytes());
            signature = new String(Base64.encodeBase64(mac.doFinal(md.digest())));
        } catch (Exception e) {
        }
        return;
    }
}