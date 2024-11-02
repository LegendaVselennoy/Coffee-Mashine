package com.demo.exception.advice;

import com.demo.exception.MissingIngredientsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MissingIngredientsException.class)
    public ResponseEntity<String> handleMissingIngredients(MissingIngredientsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
