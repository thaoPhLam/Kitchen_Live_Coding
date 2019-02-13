package com.codecool.kitchen.employee;

import com.codecool.kitchen.Ingredient;
import com.codecool.kitchen.IngredientChecker;

public class Chef extends Cooker {
    private IngredientChecker ingredientChecker;

    public Chef(String name, String birthDate, int salary, IngredientChecker ingredientChecker) {
        super(name, birthDate, salary);
        this.ingredientChecker = ingredientChecker;
    }

    /**
     * Chef
     * - úgy cook-ol, h kér egy ingredient-t
     * --> request(Ingredient ingredient)
     *
     * - chef-nek kell ez az információ a konyhából
     * --> kell egy interface-s field, amivel elérjük az infót, arról, h
     * van e a konyhában bármely helper-nél a kért ingredient
     */
    @Override
    public void cook() {
        Ingredient ingredient = Ingredient.getRandom();
        if (request(ingredient)) {
            System.out.println("Wohoo");
        } else {
            System.out.println("NO " + ingredient + "?!!");
        }

    }

    public boolean request(Ingredient ingredient) {
        return ingredientChecker.doWeHaveIngredient(ingredient);
    }
}
