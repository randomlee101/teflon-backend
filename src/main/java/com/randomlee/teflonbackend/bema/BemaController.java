package com.randomlee.teflonbackend.bema;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Data
@RestController
@RequestMapping("api/v1/bema")
public class BemaController {

    @Autowired
    private final BemaRepository bemaRepository;

    @PostMapping("/make_payment")
    public HashMap make_payment(@RequestBody InitialisePayment initialisePayment) throws Exception{
        String uuid = (String) ((HashMap) bemaRepository.make_payment(initialisePayment, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ODA0LCJtZXJjaGFudElkIjo4MDQsImJ1c2luZXNzX25hbWUiOiJSYW5kb20gTGVlIiwiaXNfYWRtaW4iOjAsImlzX3N1cGVyX2FkbWluIjowLCJjb21wbGlhbmNlX3N0YXR1cyI6IkFBIiwiZW1haWwiOiJmb2xvcnVuc29kYW5pZWw1QGdtYWlsLmNvbSIsInJvbGUiOiJBZG1pbmlzdHJhdG9yIiwidGVzdF9wdWJsaWNfa2V5IjoiYnNwa190ZXN0XzEyOWIyYjI4MGIiLCJjb250YWN0X3BlcnNvbiI6IkRhbmllbCBGb2xvcnVuc28iLCJ3ZWJob29rX3VybCI6bnVsbCwiaWF0IjoxNjMyODM2OTUzLCJleHAiOjE2MzI5MjMzNTN9.Jo5VMIw5AwIgEk5UgI0-gART9fWmFI0nOYWIuXA_tIs").get("data")).get("uuid");
        if(uuid == null)
        {
            return new HashMap();
        }
        else
        {
            return bemaRepository.authorizeTransfer(uuid, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ODA0LCJtZXJjaGFudElkIjo4MDQsImJ1c2luZXNzX25hbWUiOiJSYW5kb20gTGVlIiwiaXNfYWRtaW4iOjAsImlzX3N1cGVyX2FkbWluIjowLCJjb21wbGlhbmNlX3N0YXR1cyI6IkFBIiwiZW1haWwiOiJmb2xvcnVuc29kYW5pZWw1QGdtYWlsLmNvbSIsInJvbGUiOiJBZG1pbmlzdHJhdG9yIiwidGVzdF9wdWJsaWNfa2V5IjoiYnNwa190ZXN0XzEyOWIyYjI4MGIiLCJjb250YWN0X3BlcnNvbiI6IkRhbmllbCBGb2xvcnVuc28iLCJ3ZWJob29rX3VybCI6bnVsbCwiaWF0IjoxNjMyODM2OTUzLCJleHAiOjE2MzI5MjMzNTN9.Jo5VMIw5AwIgEk5UgI0-gART9fWmFI0nOYWIuXA_tIs");
        }
    }
}

