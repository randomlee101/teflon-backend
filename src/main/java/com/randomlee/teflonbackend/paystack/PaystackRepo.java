package com.randomlee.teflonbackend.paystack;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;

import java.util.HashMap;

public interface PaystackRepo {

    HashMap listAllBanks();
    HashMap verifyAccountNumber(String accountNumber, String bankCode);
    HashMap createTransferReceipt();
    HashMap initiateTransfer();
    String make_payment();
}
