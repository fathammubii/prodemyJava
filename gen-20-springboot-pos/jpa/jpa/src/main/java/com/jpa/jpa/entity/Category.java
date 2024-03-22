package com.jpa.jpa.entity;

import jakarta.persistence.*;

@Entity(name = "Category")
public class Category {

    @Id
    @SequenceGenerator(
            name = "category_update",
            sequenceName = "category_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequance"
    )
    @Column(
            name = "id_category",
            updatable = false
    )
    private int categoryId;
    @Column(
            name = "category_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String categoryName;


    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(){}

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
