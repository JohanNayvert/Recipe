package com.skypro.recipe.services.impl;

import com.skypro.recipe.model.Ingredients;
import com.skypro.recipe.services.IngredientsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private final Map<Long, Ingredients> ingredientsMap = new HashMap<>();
    private Long ingredientsId = 0L;


    @Override
    public Ingredients addIngredients(Ingredients ingredients) {
        ingredientsMap.put(ingredientsId++, ingredients);
        return ingredients;
    }

    @Override
    public Ingredients getIngredients(Long ingredientsId) {
        return ingredientsMap.get(ingredientsId);
    }

    @Override
    public Ingredients updateIngredients(Long ingredientsId, Ingredients ingredients) {
        return ingredientsMap.put(ingredientsId, ingredients);
    }

    @Override
    public Ingredients deleteIngredients(Long ingredientsId) {
        return ingredientsMap.remove(ingredientsId);
    }
}
