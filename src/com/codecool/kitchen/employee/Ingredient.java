package com.codecool.kitchen.employee;

import java.util.Random;

public enum Ingredient {
    CARROT,
    POTATO,
    MEAT;

    private static Random random = new Random();

    public static Ingredient getRandom() {
        return values()[random.nextInt(Ingredient.values().length)];
    }
}
