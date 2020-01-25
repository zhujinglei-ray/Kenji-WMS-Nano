package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
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
public class RestStockTransferClient implements StockTransferClient{
    private final String eposnowBaseUrl;
    private final String pageStockTransferQueryEndpoint;
    private final int pageCount;
    private final QueryUtilise queryUtilise;
    private final RestTemplate restTemplate;

    @Autowired
    public RestStockTransferClient(
            @Value("${eposnow.base.url.v2}") String eposnowBaseUrl,
            @Value("${eposnow.stock.transfer.page.query.endpoint}")String pageStockTransferQueryEndpoint,
            @Value("${eposnow.stock.transfer.page.query.size}") int pageCount,
            QueryUtilise queryUtilise,
            RestTemplate restTemplate) {
        this.eposnowBaseUrl = eposnowBaseUrl;
        this.pageStockTransferQueryEndpoint = pageStockTransferQueryEndpoint;
        this.pageCount = pageCount;
        this.queryUtilise = queryUtilise;
        this.restTemplate = restTemplate;
    }

    @Override
    public StockTransfer createStockTransfer(WarehouseIdMap fromLocation, WarehouseIdMap toLocation) {
        StockTransfer transfer = new StockTransfer();
        transfer.setFromLocation(fromLocation.getLocationId());
        transfer.setToLocation(toLocation.getLocationId());
        return null;
    }

    @Override
    public StockTransferItem createStockTransferItem(StockTransfer transfer, int qty) {
        return null;
    }

    @Override
    public List<StockTransfer> getStockTransfersByPageNumber(int pageNumber) throws FailQueryStockException {
        String url = eposnowBaseUrl + String.format(pageStockTransferQueryEndpoint, pageNumber);
        HttpHeaders headers = queryUtilise.getHeaders();
        HttpEntity entity = new HttpEntity(headers);
        try{
            ResponseEntity<StockTransfer[]> transfers = restTemplate.exchange(url, HttpMethod.GET, entity, StockTransfer[].class);
            if (transfers.hasBody()) {
                return Arrays.asList(Objects.requireNonNull(transfers.getBody()));
            }
            return Collections.emptyList();
        } catch (Exception e) {
            throw new FailQueryStockException("Failed to query stock transfer for page " + pageNumber , e);
        }
    }

    private long getNextTransNo(){
        return 0;
    }
}
