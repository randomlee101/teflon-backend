package com.randomlee.teflonbackend.paystack;

import lombok.Data;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Data
@RestController
@RequestMapping("/api/v1/paystack")
public class PaystackController {

    private final PaystackRepo paystackRepo;

    @GetMapping("/make_payment")
    public String make_payment()
    {
        return paystackRepo.make_payment();
    }

    @GetMapping("/banks")
    public List listBanks() throws Exception{
        return (List) paystackRepo.listAllBanks().get("data");
    }
}