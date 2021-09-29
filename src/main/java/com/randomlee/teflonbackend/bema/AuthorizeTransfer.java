package com.randomlee.teflonbackend.bema;

import lombok.Data;

@Data
public class AuthorizeTransfer {

    private final String public_key = "bspk_test_129b2b280b";
    private final String charge_type = "bank_transfer";
    private final String uuid;
}
