package com.randomlee.teflonbackend.flutter_pay;

import org.springframework.stereotype.Service;

@Service
public class FlutterwaveService implements FlutterwaveRepo {

    @Override
    public String flutterwave_payment() {
        return "Flutterwave Payment";
    }
}
