package com.randomlee.teflonbackend.bema;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Optional;

@Data
public class BemaRest {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public String res()
    {
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/1", HttpMethod.GET, null, String.class).getBody();
    }
}
