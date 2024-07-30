package com.qrencia.inventoryapp.config;

import com.qrencia.inventoryapp.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handlingProductNotFound(Exception ex){
     return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlingInvalidArgument(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(ex.getDetailMessageArguments()[1].toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlingAllException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
