//package co.codingnomads.kraken.model.ricky;
//
//
//import java.util.Arrays;
//
///**
// * Created by Ricardo Roque
// * 4/Dec/2017
// * Will have to import the classes "GetOpenOrdersOutput" and "GetClosedOrdersOutput"
// */
//public class QueryOrdersInfo {
//
//    //order info
//    String[] order_txtid;
//        //See Get open orders/Get closed orders
//        //Array of GetOpenOrdersOutput info
//        GetOpenOrdersOutput[] openOrders;
//        // Array of GetClosedOrdersOutput info.
//        GetClosedOrdersOutput[] closedOrders;
//
//    public QueryOrdersInfo(String[] order_txtid, GetOpenOrdersOutput[] openOrders,
//                           GetClosedOrdersOutput[] closedOrders) {
//        this.order_txtid = order_txtid;
//        this.openOrders = openOrders;
//        this.closedOrders = closedOrders;
//    }
//
//    public String[] getOrder_txtid() {
//        return order_txtid;
//    }
//
//    public void setOrder_txtid(String[] order_txtid) {
//        this.order_txtid = order_txtid;
//    }
//
//    public GetOpenOrdersOutput[] getOpenOrders() {
//        return openOrders;
//    }
//
//    public void setOpenOrders(GetOpenOrdersOutput[] openOrders) {
//        this.openOrders = openOrders;
//    }
//
//    public GetClosedOrdersOutput[] getClosedOrders() {
//        return closedOrders;
//    }
//
//    public void setClosedOrders(GetClosedOrdersOutput[] closedOrders) {
//        this.closedOrders = closedOrders;
//    }
//
//    @Override
//    public String toString() {
//        return "QueryOrdersInfo{" +
//                "order_txtid=" + Arrays.toString(order_txtid) +
//                ", openOrders=" + Arrays.toString(openOrders) +
//                ", closedOrders=" + Arrays.toString(closedOrders) +
//                '}';
//    }
//}
