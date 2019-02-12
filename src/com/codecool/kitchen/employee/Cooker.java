package com.codecool.kitchen.employee;

public abstract class Cooker extends Employee {
    protected boolean hasKnife;

    public Cooker(String name, String birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public abstract void cook();
}
