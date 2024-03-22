package com.jpa.jpa.entity;

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
    private int stdId;
    @Column(
            name = "product_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String stdName;

    @Column(
            name = "Price"
    )
    private int stdPrice;

    public Product(int stdId, String stdName, int stdPrice) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.stdPrice = stdPrice;
    }

    public Product(){}

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdPrice() {
        return stdPrice;
    }

    public void setStdPrice(int stdPrice) {
        this.stdPrice = stdPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stdId=" + stdId +
                ", stdName='" + stdName + '\'' +
                ", stdPrice=" + stdPrice +
                '}';
    }
}
