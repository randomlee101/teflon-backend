package com.randomlee.teflonbackend.flutter_pay;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/api/v1/flutterwave")
public class FlutterwaveController {

    @Autowired
    private final FlutterwaveRepo flutterwaveRepo;

    @GetMapping("/make_payment")
    public String make_payment()
    {
            return flutterwaveRepo.flutterwave_payment();
    }
}
