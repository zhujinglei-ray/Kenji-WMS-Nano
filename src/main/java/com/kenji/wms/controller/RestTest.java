package com.kenji.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class RestTest {
    private RestTemplate restTemplate;

    public RestTest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String token ="UlQ2UkE2M09FNlVCWVgzR0RSR1VYT0EzR1kxWEhKSTk6WjkwSk9FRTI0TTJHTzhLVlJXMU02REJUTVNHWVdGRFo=";
        String url = "https://api.eposnowhq.com/api/integration/appsettings";
        headers.set("Authorization","Bearer" + token);
        HttpEntity<String> request = new HttpEntity<>(headers);
        restTemplate.getForEntity(url,String.class,headers);
    }
}
