package com.codecool.kitchen.employee;

import com.codecool.kitchen.Ingredient;
import com.codecool.kitchen.IngredientChecker;

public class Chef extends Cooker {
    private IngredientChecker ingredientChecker;

    public Chef(String name, String birthDate, int salary) {
        super(name, birthDate, salary);
    }

    @Override
    public void cook() {

    }

    public void request(Ingredient ingredient) {

    }
}
