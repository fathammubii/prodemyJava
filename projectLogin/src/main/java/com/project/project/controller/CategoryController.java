package com.project.project.controller;

import com.project.project.dto.CategoryReq;
import com.project.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pos/api/listcategory")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryReq> getAllCategories(){
        return categoryService.getAllCategories();
    }

}
