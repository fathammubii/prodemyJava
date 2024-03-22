package com.jpa.jpa.service;

import com.jpa.jpa.entity.NewProduct;
import com.jpa.jpa.repository.NewProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewProductService {
    @Autowired
    private NewProductRepo newProductRepo;

    //native query
    public List<NewProduct> getAllNewProducts(){
        return newProductRepo.findAllUsingNativeQuery();
    }

    public void insertNewProduct(NewProduct newProduct) {
    }

    //JPQL
    public List<NewProduct> getAllUsingJPA(){
        return  newProductRepo.getAllNewProductJPQL();
    }


}
