package co.codingnomads.kraken.model;

/**
 * Created by Thomas Leruth on 11/29/17
 */

public class GetServerTimeOutput extends OutputGeneric {

    // as unix timestamp
    String unixtime;
    // as RFC 1123 time format
    String rfc1123;

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    public String getRfc1123() {
        return rfc1123;
    }

    public void setRfc1123(String rfc1123) {
        this.rfc1123 = rfc1123;
    }


}
