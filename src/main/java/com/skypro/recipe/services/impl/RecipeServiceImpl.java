package com.skypro.recipe.services.impl;

import com.skypro.recipe.model.Recipe;
import com.skypro.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final Map<Long, Recipe> recipeMap = new HashMap<>();
    private Long recipeId = 0L;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipeMap.put(recipeId++, recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(Long recipeId) {
        return recipeMap.get(recipeId);
    }
}
