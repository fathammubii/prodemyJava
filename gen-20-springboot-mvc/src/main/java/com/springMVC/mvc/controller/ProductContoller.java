package com.springMVC.mvc.controller;

import com.springMVC.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//Return berupa halaman html nya
@RequestMapping("")
public class ProductContoller {

    @Autowired
    private ProductService productService;

    @GetMapping("/show")
    public String welcome(Model model){
        model.addAttribute("title","Table of Product:");
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        return "add";
    }
}
