package co.codingnomads.kraken.model.account.output;

import co.codingnomads.kraken.model.OutputWrapper;
import com.fasterxml.jackson.annotation.*;

/**
 * Created by Thomas Leruth on 11/29/17
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountBalanceOutput extends OutputWrapper {

    String ZEUR;

    String XXBT;

    String XLTC;

    String XETH;

    String XDAO;

    String XETC;

    String XREP;

    String XMLN;

    String BCH;

    public String getZEUR() {
        return ZEUR;
    }

    public void setZEUR(String ZEUR) {
        this.ZEUR = ZEUR;
    }

    public String getXXBT() {
        return XXBT;
    }

    public void setXXBT(String XXBT) {
        this.XXBT = XXBT;
    }

    public String getXLTC() {
        return XLTC;
    }

    public void setXLTC(String XLTC) {
        this.XLTC = XLTC;
    }

    public String getXETH() {
        return XETH;
    }

    public void setXETH(String XETH) {
        this.XETH = XETH;
    }

    public String getXDAO() {
        return XDAO;
    }

    public void setXDAO(String XDAO) {
        this.XDAO = XDAO;
    }

    public String getXETC() {
        return XETC;
    }

    public void setXETC(String XETC) {
        this.XETC = XETC;
    }

    public String getXREP() {
        return XREP;
    }

    public void setXREP(String XREP) {
        this.XREP = XREP;
    }

    public String getXMLN() {
        return XMLN;
    }

    public void setXMLN(String XMLN) {
        this.XMLN = XMLN;
    }

    public String getBCH() {
        return BCH;
    }

    public void setBCH(String BCH) {
        this.BCH = BCH;
    }

    // why is the Json not picking up the name without this?
    public GetAccountBalanceOutput(@JsonProperty("ZEUR") String ZEUR,
                                   @JsonProperty("XXBT") String XXBT,
                                   @JsonProperty("XLTC") String XLTC,
                                   @JsonProperty("XETH") String XETH,
                                   @JsonProperty("XDAO") String XDAO,
                                   @JsonProperty("XETC") String XETC,
                                   @JsonProperty("XREP") String XREP,
                                   @JsonProperty("XMLN") String XMLN,
                                   @JsonProperty("BCH")  String BCH) {
        this.ZEUR = ZEUR;
        this.XXBT = XXBT;
        this.XLTC = XLTC;
        this.XETH = XETH;
        this.XDAO = XDAO;
        this.XETC = XETC;
        this.XREP = XREP;
        this.XMLN = XMLN;
        this.BCH = BCH;
    }

    @Override
    public String toString() {
        return "GetAccountBalanceOutput{" +
                "ZEUR='" + ZEUR + '\'' +
                ", XXBT='" + XXBT + '\'' +
                ", XLTC='" + XLTC + '\'' +
                ", XETH='" + XETH + '\'' +
                ", XDAO='" + XDAO + '\'' +
                ", XETC='" + XETC + '\'' +
                ", XREP='" + XREP + '\'' +
                ", XMLN='" + XMLN + '\'' +
                ", BCH='" + BCH + '\'' +
                '}';
    }
}
