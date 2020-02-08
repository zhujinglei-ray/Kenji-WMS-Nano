package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.queryservice.BarcodeQueryService;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.RestStockQueryService;
import com.kenji.wms.stock.utilis.AgentUtilise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarcodeQueryFrontController {
    private BarcodeQueryService barcodeQueryService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    public BarcodeQueryFrontController(BarcodeQueryService barcodeQueryService) {
        this.barcodeQueryService = barcodeQueryService;
    }


    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, Model model) {
        String barcodeInput = getInput(request);
        String returnPage = AgentUtilise.checkAgentIsMobile(request.getHeader("User-Agent")) ? "mtables" : "tables";

        logger.debug("Request from request {}, it is a mobile deivice {}", request.getHeader("User-Agent"), AgentUtilise.checkAgentIsMobile(request.getHeader("User-Agent")) );
        try {
            SearchedProduct searchedProduct = barcodeQueryService.getStockReturnToFront(barcodeInput);
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
            return returnPage;
        }
    }

    private String getInput(HttpServletRequest request) {
        if (request.getParameter("barcodeInput") == null) {
            return "0";
        } else return request.getParameter("barcodeInput");
    }
}
