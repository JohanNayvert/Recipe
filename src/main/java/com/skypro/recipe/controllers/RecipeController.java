package com.skypro.recipe.controllers;

import com.skypro.recipe.model.Recipe;
import com.skypro.recipe.services.impl.RecipeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    @PatchMapping
    Recipe addRecipe (@Valid @RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }

    @GetMapping("/{recipeId}")
    Recipe getRecipe (@PathVariable Long recipeId){
        return recipeService.getRecipe(recipeId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage)
        });
        return errors;
    }
}
