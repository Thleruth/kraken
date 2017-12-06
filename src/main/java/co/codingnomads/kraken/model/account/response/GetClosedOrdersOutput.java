//package co.codingnomads.kraken.model.account.response;
//
//import co.codingnomads.kraken.model.OutputWrapper;
//
//import java.util.Arrays;
//
//public class GetClosedOrdersOutput extends OutputWrapper {
//    /**
//     * Created by Meghan Boyce on 11/29/17
//     * I think this includes all fields from get open orders
//     * So can probably use that class once it's created..
//     */
//
//    // Array of GetOpenOrdersOutput info.
//    String[] closed;
//    // Additional fields:
//        // Unix timestamp of when GetOpenOrdersOutput was closed
//        String closetm;
//        // Additional info on status (if any)
//        String reason;
//
//    // Amount of available GetOpenOrdersOutput info matching criteria
//    String count;
//
//    public String[] getClosed() {
//        return closed;
//    }
//
//    public void setClosed(String[] closed) {
//        this.closed = closed;
//    }
//
//    public String getClosetm() {
//        return closetm;
//    }
//
//    public void setClosetm(String closetm) {
//        this.closetm = closetm;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public String getCount() {
//        return count;
//    }
//
//    public void setCount(String count) {
//        this.count = count;
//    }
//
//    @Override
//    public String toString() {
//        return "GetClosedOrdersOutput{" +
//                ", closed=" + Arrays.toString(closed) +
//                ", closetm='" + closetm + '\'' +
//                ", reason='" + reason + '\'' +
//                ", count='" + count + '\'' +
//                '}';
//    }
//}
