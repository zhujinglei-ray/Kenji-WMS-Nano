package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BarcodeQueryFrontController {
    private final RestProductQueryService restProductQueryService;

    @Autowired
    public BarcodeQueryFrontController(RestProductQueryService restProductQueryService) {
        this.restProductQueryService = restProductQueryService;
    }


    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, Model model) throws FailQueryProductException {
        String search_input;
        if (request.getParameter("barcodeinput")==null){
            search_input = "1";
        }else {
            search_input = request.getParameter("barcodeinput");
        }
        try {

        List<ProductStock> stocksByBarcode = restProductQueryService.getStocksByBarcode(search_input);
        Product productByBarcode = restProductQueryService.getProductByBarcode(search_input);
        int stockInWareHouse=0;
        int stockInArndale=0;
        int stockInBury=0;
        int stockInPreston=0;
        int stockInWarrinton=0;

        for (ProductStock productStock : stocksByBarcode) {
            if (productStock.getLocationID() == 3371){
                stockInWareHouse = productStock.getCurrentStock();
            }
            if (productStock.getLocationID() == 13908){
                stockInPreston = productStock.getCurrentStock();
            }
            if (productStock.getLocationID() == 13951){
                stockInBury = productStock.getCurrentStock();
            }
            if (productStock.getLocationID() == 17595){
                stockInArndale = productStock.getCurrentStock();
            }
        }

        SearchedProduct searchedProduct = new SearchedProduct();
        searchedProduct.setProductID(productByBarcode.getProductID());
        searchedProduct.setName(productByBarcode.getName());
        searchedProduct.setQtyInArndale(stockInArndale);
        searchedProduct.setQtyInWarehouse(stockInWareHouse);
        searchedProduct.setQtyInWarrinton(stockInWarrinton);
        searchedProduct.setQtyInPreston(stockInPreston);
        searchedProduct.setQtyInBury(stockInBury);
        searchedProduct.setBarcode(search_input);

        model.addAttribute("productId", searchedProduct.getProductID());
        model.addAttribute("productName",searchedProduct.getName());
        model.addAttribute("stockId",searchedProduct.getStockID());
        model.addAttribute("qtyInStock",searchedProduct.getQtyInWarehouse());
        model.addAttribute("qtyInArndale",searchedProduct.getQtyInArndale());
        model.addAttribute("qtyInBury", searchedProduct.getQtyInBury());
        model.addAttribute("qtyInPreston", searchedProduct.getQtyInPreston());
        model.addAttribute("qtyInWarrinton", searchedProduct.getQtyInWarrinton());
        model.addAttribute("barcode",searchedProduct.getBarcode());
        return "/tables"; //view
    }catch (Exception e){
            return "/tables";
        }
    }
}
