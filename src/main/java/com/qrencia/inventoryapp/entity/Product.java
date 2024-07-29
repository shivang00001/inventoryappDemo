package com.qrencia.inventoryapp.entity;

import com.qrencia.inventoryapp.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Long quantity;

    public Product(ProductDto productDto){
        this.name=productDto.getName();
        this.description=productDto.getDescription();
        this.price=productDto.getPrice();
        this.quantity=productDto.getQuantity();
    }
}
