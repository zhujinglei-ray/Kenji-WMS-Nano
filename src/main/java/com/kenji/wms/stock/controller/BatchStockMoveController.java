package com.kenji.wms.stock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchStockMoveController {

    @GetMapping("/testfor")
    public String getCurrentUserName(Authentication authentication) {
        return  authentication.getName();
    }
}
