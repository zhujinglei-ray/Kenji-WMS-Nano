package com.kenji.wms.stock.utilis;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Component
public class QueryUtilise {
    private String user;
    private String pwd;
    private String secret;

    @Autowired
    public QueryUtilise(@Value("${eposnow.username}")String user,
                        @Value("${eposnow.password}")String pwd,
                        @Value("${eposnow.secret.v2}")String secret) {
        this.pwd=pwd;
        this.user=user;
        this.secret = secret;
    }

    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add(
                    "Authorization", "Basic " +
                            Base64.getEncoder().encodeToString((user + ":" + pwd).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return headers;
    }

    public HttpHeaders getHeadersV2(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + secret);
        headers.add("Content-Type", "application/json");
        return headers;
    }
}
