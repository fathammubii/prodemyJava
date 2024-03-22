package com.jpa.jpa.controller;

import com.jpa.jpa.entity.NewProduct;
import com.jpa.jpa.service.NewProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/newproduct")
public class NewProductController {

    @Autowired
    private NewProductService newProductService;

    @GetMapping("/all/native")
    public List<NewProduct> getAllNewProducts(){
        return newProductService.getAllNewProducts();
    }


    @PostMapping("/post/native")
    public List<NewProduct> addNewProduct(@RequestBody NewProduct newProduct){
        newProductService.insertNewProduct(newProduct);
        return null;
    }

    @GetMapping("/all/jpql")
    public List<NewProduct> getAllUsingJPA(){
        return newProductService.getAllUsingJPA();
    }
}
