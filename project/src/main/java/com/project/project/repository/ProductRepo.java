package com.project.project.repository;

import com.project.project.dto.CategoryReq;
import com.project.project.entity.Category;
import com.project.project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE LOWER(p.title) LIKE %:title%")
    List<Product> findByTitleLikeIgnoreCase(@Param("title") String title);

    List<Product> findByCategory(Category category);

    Optional<Product> findById(int id);
}
