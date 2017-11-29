package co.codingnomads.kraken.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Thomas Leruth on 11/28/17
 */

public class DataTransformationUtil {

    /**
     * Concatenate two Byte arrays
     * @param a
     * @param b
     * @return
     */
    public static byte[] concatByteArrays(byte[] a, byte[] b) {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            outputStream.write(a);
            outputStream.write(b);
            return outputStream.toByteArray();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Transform a byte array to a String
     * @param input
     * @return
     */
    public static byte[] stringToBytes(String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

}
