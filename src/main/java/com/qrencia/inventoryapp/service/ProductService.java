package com.qrencia.inventoryapp.service;

import ch.qos.logback.core.util.StringUtil;
import com.qrencia.inventoryapp.dto.ProductDto;
import com.qrencia.inventoryapp.entity.Product;
import com.qrencia.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDto::new).toList();
    }

    public ProductDto getProductById(Long id) {
        Product product = getProduct(id);
        return new ProductDto(product);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product newProduct = new Product(productDto);
        productRepository.save(newProduct);
        return new ProductDto(newProduct);
    }

    public String deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
        return "Product deleted";
    }

    public String updateProduct(ProductDto productDto) {

        Product product = getProduct(productDto.getId());
        if (StringUtils.hasLength(productDto.getName())) {
            product.setName(productDto.getName());
        }
        if (StringUtils.hasLength(productDto.getDescription())) {
            product.setDescription(productDto.getDescription());
        }
        if (productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }
        if (productDto.getQuantity() != null) {
            product.setQuantity(productDto.getQuantity());
        }
        productRepository.save(product);
        return "Product updated";
    }

    private Product getProduct(Long productDto) {
        Optional<Product> productOptional = productRepository.findById(productDto);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return productOptional.get();
    }
}
