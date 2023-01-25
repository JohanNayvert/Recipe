package com.skypro.recipe.controllers;

import com.skypro.recipe.model.Ingredients;
import com.skypro.recipe.services.impl.IngredientsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientsController {

    private final IngredientsServiceImpl ingredientsService;


    @PatchMapping
    Ingredients addIngredients (@Valid @RequestBody Ingredients ingredients){
        return ingredientsService.addIngredients(ingredients);
    }

    @GetMapping("/{ingredientsId}")
    Ingredients getIngredients (@PathVariable Long ingredientsId){
        return ingredientsService.getIngredients(ingredientsId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
