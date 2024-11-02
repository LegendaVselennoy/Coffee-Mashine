package com.demo.service;

import com.demo.model.Ingredient;
import com.demo.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> updateIngredient(Long id, Ingredient ingredient) {
        return ingredientRepository.findById(id)
                .map(savedIngredient -> {
                    savedIngredient.setQuantity(ingredient.getQuantity());
                    return ingredientRepository.save(savedIngredient);
                });
    }

    public Ingredient createReceptIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
