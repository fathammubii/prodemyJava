package com.springMVC.mvc.entity;

import jakarta.persistence.*;

@Entity(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "product_update",
            sequenceName = "product_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequance"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private int id;

    @Column(
            name = "Product_Name",
            //nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "Price"
    )
    private int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
