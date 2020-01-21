package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
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
    private String stockQueryEndpoint;
    private String pageStockQueryEndpoint;
    private QueryUtilise queryUtilise;

    @Autowired
    public RestStockQueryClient(
            RestTemplate restTemplate,
            QueryUtilise queryUtilise,
            @Value("${eposnow.base.url}") String eposnowBaseUrl,
            @Value("${eposnow.stock.endpoint}") String stockQueryEndpoint,
            @Value("${eposnow.stock.page.query.endpoint}") String pageStockQueryEndpoint) {
        this.restTemplate = restTemplate;
        this.eposnowBaseUrl = eposnowBaseUrl;
        this.queryUtilise = queryUtilise;
        this.stockQueryEndpoint = stockQueryEndpoint;
        this.pageStockQueryEndpoint = pageStockQueryEndpoint;
    }

    @Override
    public List<ProductStock> getStocksByPageNumber(int pageNumber) throws FailQueryStockException {
        String url = eposnowBaseUrl + String.format(pageStockQueryEndpoint, pageNumber);
        HttpHeaders headers = queryUtilise.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        try{
            ResponseEntity<ProductStock[]> products = restTemplate.exchange(url, HttpMethod.GET, entity, ProductStock[].class);
            if (products.hasBody()) {
                return Arrays.asList(Objects.requireNonNull(products.getBody()));
            }
            return Collections.emptyList();
        } catch (Exception e) {
            throw new FailQueryStockException("Failed to query product stock for page " + pageNumber , e);
        }
    }

    @Override
    public ProductStock getStockByStockId(long stockId) throws FailQueryStockException {
        String url = eposnowBaseUrl + String.format(pageStockQueryEndpoint, stockId);
        HttpHeaders headers = queryUtilise.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        try{
            ResponseEntity<ProductStock> product = restTemplate.exchange(url, HttpMethod.GET, entity, ProductStock.class);
            if (product.hasBody()) {
                return product.getBody();
            }
            return null;
        } catch (Exception e) {
            throw new FailQueryStockException("Failed to query product for product id " + stockId , e);
        }
    }
}
