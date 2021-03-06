package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.login.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = {"/charts"}, method = RequestMethod.GET)
    public ModelAndView chartsView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("charts"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView homeView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index"); // resources/template/login.html
        return modelAndView;
    }

    @RequestMapping(value = {"/testproduct"}, method = RequestMethod.POST)
    public ResponseEntity<ProductStock> testStock(@RequestBody ProductStock productStock) {
        System.out.println(productStock);
        return new ResponseEntity<ProductStock>(productStock, HttpStatus.ACCEPTED);
    }
}