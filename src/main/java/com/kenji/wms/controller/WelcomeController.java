package com.kenji.wms.controller;

import com.kenji.wms.model.frontend.SearchedProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {
    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, Model model) {
        String search_input = request.getParameter("barcodeinput");
        SearchedProduct searchedProduct = new SearchedProduct(123,
                "test",123,1,1,
                1,1,111111);
        model.addAttribute("productId", searchedProduct.getProductID());
        model.addAttribute("productName",searchedProduct.getName());
        model.addAttribute("stockId",searchedProduct.getStockID());
        model.addAttribute("qtyInStock",searchedProduct.getQtyInWarehouse());
        model.addAttribute("qtyInArndale",searchedProduct.getQtyInArndale());
        model.addAttribute("qtyInBury", searchedProduct.getQtyInBury());
        model.addAttribute("qtyInPreston", searchedProduct.getQtyInPreston());
        model.addAttribute("barcode",searchedProduct.getBarcode());
        return "/tables"; //view
    }
}
