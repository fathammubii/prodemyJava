package com.jpa.jpa.entity;

import jakarta.persistence.*;

@Entity(name = "new_product")
public class NewProduct {

    @Id
    @SequenceGenerator(
            name = "product_new_update",
            sequenceName = "product_new_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_new_sequance"
    )
    @Column(
            name = "id_new_product",
            updatable = false
    )
    private int stdid2;
    @Column(
            name = "name_new_product",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String stdname2;
    @Column(
            name = "price_new_product"
    )
    private int stdprice2;

    public NewProduct(int stdid2, String stdname2, int stdprice2) {
        this.stdid2 = stdid2;
        this.stdname2 = stdname2;
        this.stdprice2 = stdprice2;
    }

    public NewProduct() {
    }

    public int getStdid2() {
        return stdid2;
    }

    public void setStdid2(int stdid2) {
        this.stdid2 = stdid2;
    }

    public String getStdname2() {
        return stdname2;
    }

    public void setStdname2(String stdname2) {
        this.stdname2 = stdname2;
    }

    public int getStdprice2() {
        return stdprice2;
    }

    public void setStdprice2(int stdprice2) {
        this.stdprice2 = stdprice2;
    }
}
