package com.demo.service;

import com.demo.exception.MissingIngredientsException;
import com.demo.model.Drink;
import com.demo.model.Ingredient;
import com.demo.repository.DrinkRepository;
import com.demo.repository.IngredientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private ObjectMapper mapper = new ObjectMapper();
    private final DrinkRepository drinkRepository;
    private final IngredientRepository ingredientRepository;
    private static final Integer MAX_INGREDIENTS = 3;
    private static final String FILE_PATH_TEST = "D:/coffee-machine/src/main/resources/statistics.json";
    private static final AtomicInteger COUNT_POPULAR = new AtomicInteger(0);


    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Optional<Drink> getDrinkById(Long id) {
        return drinkRepository.findById(id);
    }

    public Drink putDrinkByIdReduceLeftovers(Long id) {
        Optional<Drink> drink = getDrinkById(id);
        List<Ingredient> ingredients = drink.get().getIngredients();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getQuantity() <= 0) {
                throw new MissingIngredientsException("Ingredient with id " + id + " has no quantity");
            }
            ingredient.setQuantity(ingredient.getQuantity() - MAX_INGREDIENTS);
        }
        drink.get().setPopular(COUNT_POPULAR.getAndIncrement());
        ingredientRepository.saveAll(ingredients);
        return drinkRepository.save(drink.get());
    }

    public Drink popularDrink() {
        Drink drink = drinkRepository.findAll(Sort.by(Sort.Direction.DESC, "popular")).get(0);
        try {
            mapper.writeValue(new File(FILE_PATH_TEST), drink);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drink;
    }
}
