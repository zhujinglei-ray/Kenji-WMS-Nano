package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.utilis.QueryUtilise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class RestProductQueryClient implements ProductQueryClient {
    private RestTemplate restTemplate;
    private String eposnowBaseUrl;
    private String productQueryEndpoint;
    private String pageProductQueryEndpoint;
    private QueryUtilise queryUtilise;

    @Autowired
    public RestProductQueryClient(
            RestTemplate restTemplate,
            QueryUtilise queryUtilise,
            @Value("${eposnow.base.url}") String eposnowBaseUrl,
            @Value("${eposnow.product.endpoint}") String productQueryEndpoint,
            @Value("${eposnow.product.page.query.endpoint}") String pageProductQueryEndpoint) {
        this.restTemplate = restTemplate;
        this.eposnowBaseUrl = eposnowBaseUrl;
        this.productQueryEndpoint = productQueryEndpoint;
        this.pageProductQueryEndpoint = pageProductQueryEndpoint;
        this.queryUtilise = queryUtilise;
    }

    @Override
    public List<Product> getProductsByPageNumber(int pageNumber) throws FailQueryProductException {
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
