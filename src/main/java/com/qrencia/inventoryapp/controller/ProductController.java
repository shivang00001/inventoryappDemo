package com.qrencia.inventoryapp.controller;

import com.qrencia.inventoryapp.dto.ProductDto;
import com.qrencia.inventoryapp.entity.Product;
import com.qrencia.inventoryapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private  ProductService productService;

    @GetMapping
    public List<ProductDto> retrieveAll(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto retrieveByID(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto request){
        return productService.addProduct(request);
    }

    @DeleteMapping("/{id}")
    public String deleteByID(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @PatchMapping
    public String updateByID(@RequestBody ProductDto request){
        return productService.updateProduct(request);
    }
}
