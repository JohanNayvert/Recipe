package com.skypro.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @NotBlank
    private String nameRecipe;
    @Positive
    private int cookingTime;
    @NotEmpty
    private List<Ingredients> ingredients;
    @NotEmpty
    private List<String> listStepCooking;
}
