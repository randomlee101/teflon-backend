package com.randomlee.teflonbackend.bema;

import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;

@Service
@Data
public class BemaService implements BemaRepository {

    RestTemplate restTemplate = new RestTemplate();
//    private final BemaRepository bemaRepository;

    @Override
    public HashMap make_payment(InitialisePayment initialisePayment, String token) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        httpHeaders.set("Authorization", "Bearer "+token);
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<InitialisePayment> entity = new HttpEntity<InitialisePayment>(initialisePayment,httpHeaders);

        HashMap hashMap = null;
        try {
            hashMap =  restTemplate.exchange("https://dashboard.teflonhub.com/v1/charges/initiate", HttpMethod.POST, entity, HashMap.class).getBody();
        } catch (Exception e) {
            System.out.println("Localized: " +e.getLocalizedMessage());
        }

        return hashMap;
    }



    @Override
    public HashMap authorizeTransfer(String uuid, String token) {

        AuthorizeTransfer authorizeTransfer = new AuthorizeTransfer(uuid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_FORM_URLENCODED));
        httpHeaders.set("Authorization", "Bearer "+token);
        httpHeaders.set("Content-Type", "application/json");
        HttpEntity<AuthorizeTransfer> entity = new HttpEntity<AuthorizeTransfer>(authorizeTransfer,httpHeaders);

        HashMap hashMap = null;
        try {
            hashMap =  restTemplate.exchange("https://dashboard.teflonhub.com/v1/charges/authorize", HttpMethod.POST, entity, HashMap.class).getBody();
        } catch (Exception e) {
            System.out.println("Localized: " +e.getLocalizedMessage());
        }

        return hashMap;
    }
}
