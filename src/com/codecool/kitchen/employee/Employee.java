package com.codecool.kitchen.employee;

public abstract class Employee {
    protected String name;
    protected String birthDate;
    protected int salary;

    public Employee(String name, String birthDate, int salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public int createTaxReport() {
        return (int) Math.floor((double)salary*0.99);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", salary=" + salary +
                '}';
    }
}
