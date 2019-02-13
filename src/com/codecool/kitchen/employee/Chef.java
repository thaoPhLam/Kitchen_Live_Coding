package com.codecool.kitchen.employee;

import com.codecool.kitchen.Cooker;
import com.codecool.kitchen.Ingredient;
import com.codecool.kitchen.IngredientProvider;

import java.util.Optional;

public class Chef extends Employee implements Cooker {
    private Optional<IngredientProvider> provider = Optional.empty();

    public Chef (String name, String birthDate) {
        super(name, birthDate, "35");
    }

    //ez egy setter
    public void registerProvider(IngredientProvider ingredientProvider) {
        provider = Optional.of(ingredientProvider);
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
            System.out.println("What a lousy kitchen!!!");
        }
    }

    //itt meg tudja hívni az Interface methodus-át
    private boolean request(Ingredient ingredient) {
        return provider
                .map(p -> p.provide(ingredient))
                .orElse(false);
    }
}
