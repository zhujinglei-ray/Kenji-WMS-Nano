package com.kenji.wms.stock.utilis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

public class QueryUtilise {
    private String token;

    @Autowired
    public QueryUtilise(@Value("${secret}")String token) {
        this.token = token;
    }

    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+ token);
        return headers;
    }
}
