package com.qrencia.inventoryapp.exception;


public class ProductNotFoundException extends RuntimeException {
 public ProductNotFoundException() {
     super("Product Not Found");
 }
}
