package com.codecool.kitchen.employee;

import com.codecool.kitchen.Ingredient;
import com.codecool.kitchen.NoSuchIngredient;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class KitchenHelper extends Employee{
    private Map<Ingredient, Integer> basket = new TreeMap<>();

    private Random rnd = new Random();

    public KitchenHelper (String name, String birthDate) {
        super(name, birthDate, "30");
        stockUp();
    }

    public void stockUp() {
        for(Ingredient ingredient : Ingredient.values()) {
            final int amount = rnd.nextInt(4);
            basket.put(ingredient, amount);
        }
    }

    public void give(Ingredient ingredient) {
        if (basket.getOrDefault(ingredient, 0) > 0) {

        } else {
            throw new NoSuchIngredient("Couldn't give " + ingredient);
        }
    }

    @Override
    protected String additionalFields() {
        return "basket: " + basket;
    }

}
