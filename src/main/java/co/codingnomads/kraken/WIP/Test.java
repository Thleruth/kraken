//package co.codingnomads.kraken.WIP;
//
//import co.codingnomads.kraken.service.KrakenSignature;
//import org.apache.commons.codec.binary.Base64;
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import javax.net.ssl.HttpsURLConnection;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.security.InvalidKeyException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class Test {
//    static String key = "9wGDPwDge3Zooqk6ASm3mSzQaDrht+iZbVTL6qSsyKhudAyS0xf1cUIO";
//    static String secret = "kRadpxMrNfL+Yd6wXI/yW3qxUaMtr7JUPd0a3zbCFpzULvBPfLBo2a7VRhz55qcUUV65WQswY6tA8Kibcr4U0A==";
//    static String signature = "";
//    static String path = "/0/private/Balance";
//    static String nonce = String.valueOf(System.currentTimeMillis());
//    static String data = "nonce=" + nonce;
//    static String domain = "https://api.kraken.com";
//
//    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
//        signature = KrakenSignature.calculateSign();
//        String answer = post(domain + path, data);
//        System.out.println(answer);
//    }
//
//    static String post(String address, String output) {
//        String answer = "";
//        HttpsURLConnection c = null;
//        try {
//            URL u = new URL(address);
//            c = (HttpsURLConnection)u.openConnection();
//            c.setRequestMethod("POST");
//            c.setRequestProperty("API-Key", key);
//            c.setRequestProperty("API-Sign", signature);
//            c.setDoOutput(true);
//            DataOutputStream os = new DataOutputStream(c.getOutputStream());
//            os.writeBytes(output);
//            os.flush();
//            os.close();
//            BufferedReader br = null;
//            if(c.getResponseCode() >= 400) {
//                System.out.println(c.getResponseMessage());
//                System.exit(1);
//            }
//            br = new BufferedReader(new InputStreamReader((c.getInputStream())));
//            String line;
//            while ((line = br.readLine()) != null)
//                answer += line;
//        } catch (Exception x) {
//            System.exit(2);
//        } finally {
//            c.disconnect();
//        }
//        return answer;
//    }
//
//    static String calculateSignature() {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update((nonce + data).getBytes());
//            Mac mac = Mac.getInstance("HmacSHA512");
//            mac.init(new SecretKeySpec(Base64.decodeBase64(secret.getBytes()), "HmacSHA512"));
//            mac.update(path.getBytes());
//            return new String(Base64.encodeBase64(mac.doFinal(md.digest())));
//        } catch (Exception e) {
//        }
//        return "a";
//    }
//}
//
