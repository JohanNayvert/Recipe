package com.skypro.recipe.services;

import com.skypro.recipe.model.Ingredients;

public interface IngredientsService {

    public Ingredients addIngredients (Ingredients ingredients);

    public Ingredients getIngredients(Long ingredientsId);

}

