package com.project.project.service;

import com.project.project.dto.CategoryReq;
import com.project.project.entity.Category;
import com.project.project.repository.CategoryRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<CategoryReq> getAllCategories(){
        List<Category> categories = categoryRepo.findAll();
        return categories.stream()
                .map(category -> new CategoryReq(category.getCategoryId(), category.getCategoryName()))
                .collect(Collectors.toList());
    }

    public CategoryReq getCategoryById (int id){
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            CategoryReq categoryReq = new CategoryReq();
            categoryReq.setCategoryId(category.getCategoryId());
            categoryReq.setCategoryName(category.getCategoryName());
            return categoryReq;
        } else {
            throw new EntityNotFoundException("Category not found with ID: " + id);
        }
    }

}
