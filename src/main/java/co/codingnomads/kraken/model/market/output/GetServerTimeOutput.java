package co.codingnomads.kraken.model.market.output;

import co.codingnomads.kraken.model.OutputWrapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Thomas Leruth on 11/29/17
 */
//working template for GET
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetServerTimeOutput extends OutputWrapper<GetServerTimeOutput> {

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


    @Override
    public String toString() {
        return "GetServerTimeOutput{" +
                "unixtime='" + unixtime + '\'' +
                ", rfc1123='" + rfc1123 + '\'' +
                '}';
    }
}
