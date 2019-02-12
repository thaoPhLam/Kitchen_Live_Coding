package com.codecool.kitchen.employee;

import java.math.BigDecimal;

public abstract class Employee {
    private static final BigDecimal TAX_RATE =
            new BigDecimal("0.99");

    protected String name;
    protected final String birthDate;
    protected BigDecimal salary;

    public Employee (String name, String birthDate, String salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.salary = new BigDecimal(salary + ".00");
    }

    public String getName() {
        return name;
    }

    public BigDecimal taxReport() {
        return salary.multiply(TAX_RATE);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(getClass().getSimpleName())
                .append("{\n")
                .append("name: " + name + "\n")
                .append("birthDate: " + birthDate + "\n")
                .append(additionalFields())
                .append("}");

        return sb.toString();
    }

    protected String additionalFields() {
        return "";
    }
}
