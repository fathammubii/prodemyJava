package com.jpa.jpa.dto;

import com.jpa.jpa.entity.Product;

public class ProductReq {
  private String stdname;
  private int stdprice;

    public ProductReq(String stdname, int stdprice) {
        this.stdname = stdname;
        this.stdprice = stdprice;
    }

    public String getStdName() {
        return stdname;
    }

    public void setStdName(String stdname) {
        this.stdname = stdname;
    }

    public int getStdPrice() {
        return stdprice;
    }

    public void setStdPrice(int stdprice) {
        this.stdprice = stdprice;
    }

    public Product toEntity(){
        Product product = new Product();
        product.setStdName(stdname);
        product.setStdPrice(stdprice);
        return product;

    }
}
