package co.codingnomads.kraken.model.account.pojos;

/**
 * Created by ryandesmond on 12/6/17.
 */
public class KrakenTradeBalance {

    //equivalent balance (combined balance of all currencies)
    String eb;
    //tb = trade balance (combined balance of all equity currencies)
    String tb;
    //margin amount of open positions
    String m;
    //unrealized net profit/loss of open positions
    String n;
    //cost basis of open positions
    String c;
    //current floating valuation of open positions
    String v;
    //equity = trade balance + unrealized net profit/loss
    String e;
    //free margin = equity - initial margin (maximum margin available to open new positions)
    String mf;
    //margin level = (equity / initial margin) * 100
    String ml;

    public String getEb() {
        return eb;
    }

    public void setEb(String eb) {
        this.eb = eb;
    }

    public String getTb() {
        return tb;
    }

    public void setTb(String tb) {
        this.tb = tb;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getMf() {
        return mf;
    }

    public void setMf(String mf) {
        this.mf = mf;
    }

    public String getMl() {
        return ml;
    }

    public void setMl(String ml) {
        this.ml = ml;
    }

}
