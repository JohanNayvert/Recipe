package com.skypro.recipe.services;

import com.skypro.recipe.model.Ingredients;

public interface IngredientsService {

    public Ingredients addIngredients (Ingredients ingredients);

    public Ingredients getIngredients (Long ingredientsId);

    public Ingredients updateIngredients (Long ingredientsId, Ingredients ingredients);

    public Ingredients deleteIngredients (Long ingredientsId);
}

