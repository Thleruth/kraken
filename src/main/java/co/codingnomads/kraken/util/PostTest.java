//package co.codingnomads.kraken.util;
//
//import co.codingnomads.kraken.model.market.request.GetTradeVolumeRequestBody;
//import co.codingnomads.kraken.model.market.response.GetTradeVolumeOutput;
//import co.codingnomads.kraken.service.KrakenSignature;
//
//import javax.net.ssl.HttpsURLConnection;
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStreamReader;
//import java.net.URL;
//
///**
// * @author Kevin Neag
// */
//public class PostTest {
//
//        static String key = "";
//        static String secret = "";
//        static String signature, data, path;
//        static String domain = "https://api.kraken.com";
//
//        public static void main(String[] args) {
//
//             GetTradeVolumeRequestBody requestBody  = new GetTradeVolumeRequestBody();
//            //fill out requestBody as needed
//
//            data = requestBody.postParam().toString();
//
//            path =("/0/private/TradeVolume");
//
//            signature = KrakenSignature.ApiSignCreator(requestBody.getNonce(),
//                    requestBody.signPostParam(), secret,   path);
//
//            String answer = post(domain + path, data);
//            System.out.println(answer);
//            // on empty accounts, returns {"error":[],"result":{}}
//            // this is a known Kraken bug
//
//        }
//
//        static String post(String address, String output) {
//            String answer = "";
//            HttpsURLConnection c = null;
//            try {
//                URL u = new URL(address);
//                c = (HttpsURLConnection)u.openConnection();
//                c.setRequestMethod("POST");
//                c.setRequestProperty("API-Key", key);
//                c.setRequestProperty("API-Sign", signature);
//                c.setDoOutput(true);
//                DataOutputStream os = new DataOutputStream(c.getOutputStream());
//                os.writeBytes(output);
//                os.flush();
//                os.close();
//                BufferedReader br = null;
//                if(c.getResponseCode() >= 400) {
//                    System.exit(1);
//                }
//                br = new BufferedReader(new InputStreamReader((c.getInputStream())));
//                String line;
//                while ((line = br.readLine()) != null)
//                    answer += line;
//            } catch (Exception x) {
//                System.exit(1);
//            } finally {
//                c.disconnect();
//            }
//            return answer;
//        }
//    }

