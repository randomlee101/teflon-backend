package com.randomlee.teflonbackend.bema;

import java.util.HashMap;

public interface BemaRepository {

    HashMap make_payment(InitialisePayment initialisePayment, String token);

    HashMap authorizeTransfer(String uuid, String token);
}
