package com.skypro.recipe.controllers;

import com.skypro.recipe.model.Recipe;
import com.skypro.recipe.services.impl.RecipeServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Рецепты", description = "CRUD-запросы класса рецепты")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    @Operation(summary = "Добавление рецепта")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Рецепт добавлен")})
    @PostMapping
    Recipe addRecipe (@Valid @RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }

    @Operation(summary = "Получение рецепта")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Рецепт найден")})
    @GetMapping("/{recipeId}")
    Recipe getRecipe (@PathVariable Long recipeId){
        return recipeService.getRecipe(recipeId);
    }

    @Operation(summary = "Изменение рецепта")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Рецепт изменен")})
    @PutMapping("/{recipeId}")
    Recipe updateRecipe (@PathVariable Long recipeId, @Valid @RequestBody Recipe recipe ){
        return recipeService.updateRecipe(recipeId, recipe);
    }

    @Operation(summary = "Удаление рецепта")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Рецепт удален")})
    @DeleteMapping("/{recipeId}")
    Recipe deleteRecipe (@PathVariable Long recipeId){
        return recipeService.deleteRecipe(recipeId);
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
