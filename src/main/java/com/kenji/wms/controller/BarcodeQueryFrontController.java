package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.queryservice.BarcodeQueryService;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.RestStockQueryService;
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

    @Autowired
    public BarcodeQueryFrontController(BarcodeQueryService barcodeQueryService) {
        this.barcodeQueryService = barcodeQueryService;
    }


    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, Model model){
        String barcodeInput = getInput(request);
        try{
        SearchedProduct searchedProduct = barcodeQueryService.getStockReturnToFront(barcodeInput);
        int totalQty = searchedProduct.getQtyInWarehouse() + searchedProduct.getQtyInArndale() +  searchedProduct.getQtyInBury() + searchedProduct.getQtyInPreston() + searchedProduct.getQtyInWarrinton();
        model.addAttribute("productName",searchedProduct.getName());
        model.addAttribute("qtyInStock",searchedProduct.getQtyInWarehouse());
        model.addAttribute("qtyInArndale",searchedProduct.getQtyInArndale());
        model.addAttribute("qtyInBury", searchedProduct.getQtyInBury());
        model.addAttribute("qtyInPreston", searchedProduct.getQtyInPreston());
        model.addAttribute("qtyInWarrinton", searchedProduct.getQtyInWarrinton());
        model.addAttribute("barcode",searchedProduct.getBarcode());
        model.addAttribute("totalQty",totalQty);
        return "/tables";
    }catch (Exception e){
            return "/tables";
        }
    }

    private String getInput(HttpServletRequest request){
        if  (request.getParameter("barcodeInput") ==null){
            return "0";
        }
        else return request.getParameter("barcodeInput");
    }
}
