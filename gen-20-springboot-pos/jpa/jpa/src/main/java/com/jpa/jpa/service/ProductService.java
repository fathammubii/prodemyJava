package com.jpa.jpa.service;

import com.jpa.jpa.dto.ProductReq;
import com.jpa.jpa.entity.Category;
import com.jpa.jpa.entity.Product;
import com.jpa.jpa.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id){
        return productRepo.findById(id);
    }


}
