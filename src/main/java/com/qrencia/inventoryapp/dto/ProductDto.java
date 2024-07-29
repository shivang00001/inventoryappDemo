package com.qrencia.inventoryapp.dto;

import com.qrencia.inventoryapp.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;

    private String name;
    private String description;
    private Double price;
    private Long quantity;


    public ProductDto(Product product){

        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price=product.getPrice();
        this.quantity=product.getQuantity();
    }
}
