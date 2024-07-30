package com.qrencia.inventoryapp.controller;


import com.qrencia.inventoryapp.dto.ProductDto;
import com.qrencia.inventoryapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/web")
public class ProductWebController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getAllProducts(Model model,
                                 @RequestParam (required = false) String priceRange) {
        List<ProductDto> products = null;
        if (priceRange != null) {
            products = productService.getByPriceRange(priceRange);
        }
        else {

            products = productService.getAllProducts();
        }
        model.addAttribute("products", products);
        return "productdisplay";
    }
}
