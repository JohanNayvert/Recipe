package com.skypro.recipe.controllers;

import com.skypro.recipe.model.Ingredients;
import com.skypro.recipe.services.impl.IngredientsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
@RequestMapping("/ingredients")
@RequiredArgsConstructor
@Tag(name = "Ингредиенты", description = "CRUD-запросы класса ингредиенты")
public class IngredientsController {

    private final IngredientsServiceImpl ingredientsService;

    @Operation(summary = "Добавление ингредиента")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ингредиент добавлен")})
    @Parameters(value = {@Parameter(name = "id", example = "1")})
    @PostMapping
    Ingredients addIngredients (@Valid @RequestBody Ingredients ingredients){
        return ingredientsService.addIngredients(ingredients);
    }

    @Operation(summary = "Получение ингредиента")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ингредиент найден")})
    @GetMapping("/{ingredientsId}")
    Ingredients getIngredients (@PathVariable Long ingredientsId){
        return ingredientsService.getIngredients(ingredientsId);
    }

    @Operation(summary = "Изменение ингредиента")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ингредиент изменен")})
    @PutMapping("/{ingredientsId}")
    Ingredients updateIngredients (@PathVariable Long ingredientsId, @Valid @RequestBody Ingredients ingredients ){
        return ingredientsService.updateIngredients(ingredientsId, ingredients);
    }

    @Operation(summary = "Удаление ингредиента")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ингредиент удален")})
    @DeleteMapping("/{ingredientsId}")
    Ingredients deleteIngredients (@PathVariable Long ingredientsId){
        return ingredientsService.deleteIngredients(ingredientsId);
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
