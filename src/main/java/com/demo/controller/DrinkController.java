package com.demo.controller;

import com.demo.model.Drink;
import com.demo.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drinks")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService service;

    @GetMapping
    public List<Drink> getAllDrinks() {
        return service.getAllDrinks();
    }

    @GetMapping("/{id}")
    public Optional<Drink> getDrinkById(@PathVariable Long id) {
        return service.getDrinkById(id);
    }

    @PutMapping("/{id}")
    public Drink putDrink(@PathVariable Long id) {
        return service.putDrinkByIdReduceLeftovers(id);
    }

    @GetMapping("/popular")
    public Drink getDrinkPopular() {
        return service.popularDrink();
    }
}
