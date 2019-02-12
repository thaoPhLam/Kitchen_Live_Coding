package com.codecool.kitchen.employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class KitchenHelper extends Employee {
    private Map<Ingredient, Integer> ingredients = new HashMap<>();
    private Random random = new Random();

    public KitchenHelper(String name, String birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public void fillBasket() {
        for (Ingredient ingredient : Ingredient.values()) {
            ingredients.put(ingredient, random.nextInt(4));
        }
    }

    public Ingredient giveIngredient(Ingredient ingredient) {
        for (Integer ingredientAmount : ingredients.values()) {
            if (ingredientAmount.equals(0)) {
                System.out.println("We are out of " + ingredient);
            } else {

            }
        }
        return ingredient;
    }
}
