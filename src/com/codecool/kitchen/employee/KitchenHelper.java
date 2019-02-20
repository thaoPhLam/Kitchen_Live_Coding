package com.codecool.kitchen.employee;

import com.codecool.kitchen.Ingredient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class KitchenHelper extends Employee {
    private Map<Ingredient, Integer> ingredients = new HashMap<>();
    private Random random = new Random();

    public KitchenHelper(String name, String birthDate, int salary) {
        super(name, birthDate, salary);
        fillBasket();
    }

    public void fillBasket() {
        for (Ingredient ingredient : Ingredient.values()) {
            ingredients.put(ingredient, random.nextInt(4));
        }
    }

    public void giveIngredient(Ingredient ingredient) {

        if (ingredients.getOrDefault(ingredient, 0) > 0) {

        } else {
            System.out.println(getName() + ": I'm OUT of " + ingredient);
        }

        /*
        Iterator it = ingredients.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((int) pair.getValue() > 0) {
                System.out.println(
                        getName() + ": I can give a " + ingredient
                );
            } else if ((int) pair.getValue() == 0) {
                System.out.println(
                        "We're OUT of " + ingredient
                );
            }
        }*/
    }
}
