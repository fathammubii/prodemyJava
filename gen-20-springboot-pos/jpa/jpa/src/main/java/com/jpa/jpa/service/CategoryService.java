package com.jpa.jpa.service;

import com.jpa.jpa.entity.Category;
import com.jpa.jpa.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategoryById(int id){
        return categoryRepo.findById(id);
    }
}
