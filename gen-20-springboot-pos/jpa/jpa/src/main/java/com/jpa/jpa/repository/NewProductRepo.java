package com.jpa.jpa.repository;

import com.jpa.jpa.entity.NewProduct;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewProductRepo extends JpaRepository<NewProduct, Integer> {

    //Native Query
    @Query(value = "SELECT * FROM new_product", nativeQuery = true)
    List<NewProduct> findAllUsingNativeQuery();

    @Modifying
    @Query(value = "INSERT INTO new_product (stdname2, stdprice2) VALUE (:stdname2, :stdprice2)", nativeQuery = true)
    @Transactional
    void insertNewProduct(String stdname2, int stdprice2);

    //JPQL
    @Query("SELECT np FROM new_product np")
    List<NewProduct> getAllNewProductJPQL();
}
