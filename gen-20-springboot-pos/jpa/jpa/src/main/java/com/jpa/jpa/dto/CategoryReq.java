package com.jpa.jpa.dto;

import com.jpa.jpa.entity.Category;

public class CategoryReq {
    private String categoryName;

    public CategoryReq(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category toEntity(){
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }

}
