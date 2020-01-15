package com.kenji.wms.controller;
import com.kenji.wms.model.frontend.SearchedProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/welcome")
    public String main(Model model) {

        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        return "welcome"; //view
    }
    @GetMapping("/stocktest")
    public String stock(Model model) {
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
        return "stocktest"; //view
    }

    @RequestMapping("/tables")
    public String stockTable(HttpServletRequest request, HttpSession httpSession, Model model) {
        String search_input = request.getParameter("index_none_header_sysc");//获取搜索框输入
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
