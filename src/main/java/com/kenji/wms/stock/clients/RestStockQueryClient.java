package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.utilis.QueryUtilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class RestStockQueryClient implements StockQueryClient {
    private RestTemplate restTemplate;
    private String eposnowBaseUrl;
    private String productQueryEndpoint;
    private String pageProductQueryEndpoint;
    private QueryUtilise queryUtilise;

    @Autowired
    public RestStockQueryClient(
            RestTemplate restTemplate,
            @Value("${eposnow.base.url}") String eposnowBaseUrl,
            @Value("${stock.product.endpoint}") String productQueryEndpoint,
            @Value("${stock.page.query.endpoint}") String pageProductQueryEndpoint,
            QueryUtilise queryUtilise) {
        this.restTemplate = restTemplate;
        this.eposnowBaseUrl = eposnowBaseUrl;
        this.productQueryEndpoint = productQueryEndpoint;
        this.pageProductQueryEndpoint = pageProductQueryEndpoint;
        this.queryUtilise = queryUtilise;
    }

    @Override
    public Collection<Product> getStocksByPageNumber(int pageNumber) throws FailQueryProductException {
        String url = eposnowBaseUrl + String.format(pageProductQueryEndpoint, pageNumber);
        HttpHeaders headers = queryUtilise.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        try{
            ResponseEntity<Product[]> products = restTemplate.exchange(url, HttpMethod.GET, entity, Product[].class);
            if (products.hasBody()) {
                return Arrays.asList(Objects.requireNonNull(products.getBody()));
            }
            return Collections.emptyList();
        } catch (Exception e) {
            throw new FailQueryProductException("Failed to query product for page " + pageNumber , e);
        }
    }
}