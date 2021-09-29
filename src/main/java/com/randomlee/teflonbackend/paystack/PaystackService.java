package com.randomlee.teflonbackend.paystack;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

@Service
public class PaystackService implements PaystackRepo{

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public HashMap listAllBanks() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        httpHeaders.set("Authorization", "Bearer sk_test_f0883f8236e7755cf09af916eb61975f0d4315c7");
        HttpEntity<HashMap> http = new HttpEntity<HashMap>(httpHeaders);

        HashMap hashMap = null;
        try
        {
            hashMap = restTemplate.exchange("https://api.paystack.co/bank", HttpMethod.GET, http, HashMap.class).getBody();
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return hashMap;
    }

    @Override
    public HashMap verifyAccountNumber(String accountNumber, String bankCode) {
        return null;
    }

    @Override
    public HashMap createTransferReceipt() {
        return null;
    }

    @Override
    public HashMap initiateTransfer() {
        return null;
    }

    @Override
    public String make_payment() {
        return null;
    }
}
