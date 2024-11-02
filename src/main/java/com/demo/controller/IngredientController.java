package com.demo.controller;

import com.demo.model.Ingredient;
import com.demo.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;

    @GetMapping
    public List<Ingredient> getAllDrinks() {
        return service.findAllIngredients();
    }

    @PutMapping("/{id}")
    public Optional<Ingredient> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        return service.updateIngredient(id, ingredient);
    }

    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return service.createReceptIngredient(ingredient);
    }
}
