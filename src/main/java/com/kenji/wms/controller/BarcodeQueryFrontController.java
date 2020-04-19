package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.queryservice.BarcodeQueryService;
import com.kenji.wms.stock.domain.StockMoveSummaryRecord;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.RestStockQueryService;
import com.kenji.wms.stock.service.StockTransferService;
import com.kenji.wms.stock.utilis.AgentUtilise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class BarcodeQueryFrontController {
    private BarcodeQueryService barcodeQueryService;
    private StockTransferService stockTransferService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    public BarcodeQueryFrontController(BarcodeQueryService barcodeQueryService, StockTransferService stockTransferService) {
        this.barcodeQueryService = barcodeQueryService;
        this.stockTransferService = stockTransferService;
    }


    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, Model model) {
        String barcodeInput = getInput(request);
        String returnPage = AgentUtilise.checkAgentIsMobile(request.getHeader("User-Agent")) ? "mtables" : "tables";

        logger.debug("Request from request {}, it is a mobile deivice {}", request.getHeader("User-Agent"), AgentUtilise.checkAgentIsMobile(request.getHeader("User-Agent")) );
        try {
            logger.debug("Target product with id {}", barcodeInput);
            SearchedProduct searchedProduct = barcodeQueryService.getStockReturnToFront(barcodeInput);
            logger.debug("Result product with id {} is {}", barcodeInput, searchedProduct);
            int totalQty = searchedProduct.getQtyInWarehouse() + searchedProduct.getQtyInArndale() + searchedProduct.getQtyInBury() + searchedProduct.getQtyInPreston() + searchedProduct.getQtyInWarrinton();
            model.addAttribute("productName", searchedProduct.getName() == null? "Product Name": searchedProduct.getName());
            model.addAttribute("qtyInStock", searchedProduct.getQtyInWarehouse());
            model.addAttribute("qtyInArndale", searchedProduct.getQtyInArndale());
            model.addAttribute("qtyInBury", searchedProduct.getQtyInBury());
            model.addAttribute("qtyInPreston", searchedProduct.getQtyInPreston());
            model.addAttribute("qtyInWarrinton", searchedProduct.getQtyInWarrinton());
            model.addAttribute("barcode", searchedProduct.getBarcode() == null ? "Barcode" : searchedProduct.getBarcode());
            model.addAttribute("totalQty", totalQty);
            return returnPage;
        } catch (Exception e) {
            logger.error("Failed to find product {}", e);
            return returnPage;
        }
    }

    @RequestMapping("/table-summary")
    public String stockTableSummary(HttpServletRequest request, Model model, Authentication authentication) {
        Map<Pair<Integer, Integer>, List<TransferLocationQty>> transferMapForUser = stockTransferService.getTransferMapForUser(authentication.getName());
        Stream<StockMoveSummaryRecord> objectStream = transferMapForUser.entrySet().stream().flatMap(
                pairListEntry -> {
                    Pair<Integer, Integer> key = pairListEntry.getKey();
                    String fromLocation = WarehouseIdMap.fromLocationId(key.getFirst()).toString();
                    String toLocation = WarehouseIdMap.fromLocationId(key.getSecond()).toString();
                    Stream<StockMoveSummaryRecord> objectStream1 = pairListEntry.getValue()
                            .stream()
                            .map(it -> new StockMoveSummaryRecord(it.getProductName(), fromLocation, toLocation, it.getQty()));
                    return objectStream1;
                }
        );
        List<StockMoveSummaryRecord> collect = objectStream.collect(Collectors.toList());
        collect.sort(new ListSorter());
        model.addAttribute("summary", collect);
        return "table-summary";
    }

    private String getInput(HttpServletRequest request) {
        if (request.getParameter("barcodeInput") == null) {
            return "0";
        } else return request.getParameter("barcodeInput");
    }

    class ListSorter implements Comparator<StockMoveSummaryRecord>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(StockMoveSummaryRecord a, StockMoveSummaryRecord b)
        {
            if (a.getToLocation().equals(b.getToLocation())) {
                return a.getProductName().compareTo(b.getProductName());
            } else {
                return a.getToLocation().compareTo(b.getToLocation());
            }
        }
    }

}
