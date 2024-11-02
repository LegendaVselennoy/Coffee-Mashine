package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(catalog = "test", name = "ingredients", schema = "test-engineer")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    @ManyToMany()
    @JoinTable(schema = "test-engineer", name = "drinks_ingredients",
            joinColumns = @JoinColumn(name = "ingredients_id"),
            inverseJoinColumns = @JoinColumn(name = "drinks_id"))
    @JsonIgnore
    List<Drink> drinks = new ArrayList<>();
}