package com.randomlee.teflonbackend.bema;

import lombok.Data;

import java.math.BigInteger;

@Data
public class InitialisePayment {

    private final String public_key = "bspk_test_129b2b280b";
    private final String transaction_reference;
    private final String email;
    private final int amount;
    private final String currency;
    private final String medium;
}
