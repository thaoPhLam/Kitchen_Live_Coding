package com.codecool.kitchen.employee;

import com.codecool.kitchen.Cooker;

public class Cook extends Employee implements Cooker {
    public Cook(String name, String birthDate) {
        super(name, birthDate, "30");
    }

    @Override
    public void cook() {

    }
}
