package com.codecool.kitchen;

import java.util.Random;

public enum Ingredient {
    CARROT,
    MEAT,
    POTATO;

    private static final Random rnd = new Random();

    static public Ingredient getRandom() {
        return values()[rnd.nextInt(values().length)];
    }
}
