package co.codingnomads.kraken.model.account.pojos;

public class KrakenOrderDescription {
    /**
     * Created by Meghan Boyce on 11/29/17
     *
     * order description info
     */

    // Asset pair
    String pair;
    // Type of order (buy/sell)
    String type;
    // TODO: ordertype = order type (See Add standard order, steal from Thomas)
    // Primary price
    String price;
    // Secondary price
    String price2;
    // Amount of leverage
    String leverage;
    // Order description
    String order;
    // Conditional close order description (if conditional close set)
    String close;

    // Fully qualified Constructor
    // TODO: Redo Constructor after completing ordertype above
    public KrakenOrderDescription(String pair, String type, String price, String price2, String leverage, String order, String close) {
        this.pair = pair;
        this.type = type;
        this.price = price;
        this.price2 = price2;
        this.leverage = leverage;
        this.order = order;
        this.close = close;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "KrakenOrderDescription{" +
                "pair='" + pair + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                ", price2='" + price2 + '\'' +
                ", leverage='" + leverage + '\'' +
                ", order='" + order + '\'' +
                ", close='" + close + '\'' +
                '}';
    }
}
