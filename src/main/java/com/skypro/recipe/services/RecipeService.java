package com.skypro.recipe.services;

import com.skypro.recipe.model.Ingredients;
import com.skypro.recipe.model.Recipe;

public interface RecipeService {

    public Recipe addRecipe (Recipe recipe);

    public Recipe getRecipe(Long recipeId);

    public Recipe updateRecipe (Long recipeId, Recipe recipe);

    public Recipe deleteRecipe (Long recipeId);
}
