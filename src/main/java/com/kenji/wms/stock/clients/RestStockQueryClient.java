package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.utilis.QueryUtilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
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
    public List<Product> getStocksByPageNumber(int pageNumber) throws FailQueryProductException {
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

    @Override
    public Product getProductInfoByProductId(long productId) throws FailQueryProductException {
        String url = eposnowBaseUrl + String.format(productQueryEndpoint, productId);
        HttpHeaders headers = queryUtilise.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        try{
            ResponseEntity<Product> product = restTemplate.exchange(url, HttpMethod.GET, entity, Product.class);
            if (product.hasBody()) {
                return product.getBody();
            }
            return null;
        } catch (Exception e) {
            throw new FailQueryProductException("Failed to query product for product id " + productId , e);
        }
    }
}
