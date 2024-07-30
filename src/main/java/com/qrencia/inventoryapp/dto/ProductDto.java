package com.qrencia.inventoryapp.dto;

import com.qrencia.inventoryapp.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;


@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;


    @NotBlank(message = "product name is required")
    @Size(min = 3, max = 255, message = "valid length between 3-255")
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
