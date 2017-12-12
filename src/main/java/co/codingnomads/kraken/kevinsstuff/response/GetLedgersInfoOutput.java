package co.codingnomads.kraken.kevinsstuff.response;

import java.util.ArrayList;

/**
 * @author Kevin Neag
 */
public class GetLedgersInfoOutput {

    ArrayList<LedgersInfo> ledgersInfo= new ArrayList<LedgersInfo>();

    //    Result: associative array of ledgers info
//
//            <ledger_id> = ledger info
//    refid = reference id
//    time = unx timestamp of ledger
//    type = type of ledger entry
//    aclass = asset class
//    asset = asset
//            amount = transaction amount
//            fee = transaction fee
//            balance = resulting balance
//    Note: Times given by ledger ids are more accurate than unix timestamps.
//
}
