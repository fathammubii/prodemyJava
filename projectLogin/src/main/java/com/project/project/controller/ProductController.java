package com.project.project.controller;

import com.project.project.responHandler.CustomResponse;
import com.project.project.dto.ProductReq;
import com.project.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("pos/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/listproduct")
    public ResponseEntity<List<ProductReq>> getAllProducts( @RequestParam(value = "title", defaultValue = "") String title,
                                            @RequestParam(value = "sort_by", defaultValue = "productId") String sortBy,
                                            @RequestParam(value = "sort_order", defaultValue = "asc") String sortOrder){
        if (title.isEmpty()) {
            title = null;
        }
        return productService.getAllProducts(title, sortBy, sortOrder);
    }

    @GetMapping("/listproduct/id")//kalau tanpa path ini, dapat terjadi konflik endpoint
    public ResponseEntity<List<ProductReq>> getProductByCategoryId(@RequestParam(value = "category_id") int id){
        return productService.getProductsByCategoryId(id);
    }

    @PostMapping("/addproduct")
    public ResponseEntity<CustomResponse> addProduct(@RequestBody ProductReq productReq){
        CustomResponse response;
        response = productService.createProduct(productReq);
        if ("failed".equals(response.getStatus())) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        return ResponseEntity.ok(response);
    }


    @PostMapping("/deleteproduct/{id}")
    public ResponseEntity<CustomResponse> deleteProduct(@PathVariable int id){
        CustomResponse response = productService.deleteProduct(id);
        if("failed".equals(response.getStatus())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<CustomResponse> updateProduct(@PathVariable("id") int productId,
                                                        @RequestBody ProductReq productReq){
        CustomResponse response = productService.updateProduct(productId,productReq);
        if("failed".equals(response.getStatus())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detailproduct/{id}")
    public ResponseEntity<List<ProductReq>> detailProduct(@PathVariable("id") int productId){
        return productService.getProductById(productId);
    }

}
