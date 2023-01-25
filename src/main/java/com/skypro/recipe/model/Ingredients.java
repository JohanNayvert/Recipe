package com.skypro.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {

    @NotBlank
    private String nameIngredients;
    @Positive
    private int amountIngredient;
    private String unit;

}
