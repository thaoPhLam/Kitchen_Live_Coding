package com.codecool.kitchen;

public class NoSuchIngredient extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public NoSuchIngredient(String msg) {
        super(msg);
    }

    public NoSuchIngredient(String msg, Exception context) {
        super(msg, context);
    }

}
