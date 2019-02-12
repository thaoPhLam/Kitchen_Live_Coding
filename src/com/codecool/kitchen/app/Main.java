package com.codecool.kitchen.app;

import com.codecool.kitchen.Kitchen;
import com.codecool.kitchen.employee.Chef;
import com.codecool.kitchen.employee.KitchenHelper;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();

        kitchen.hire(new KitchenHelper("Benec", "1993", 200));
        kitchen.hire(new KitchenHelper("Ádám", "1993", 200));
        kitchen.hire(new KitchenHelper("Dani", "1993", 200));
        kitchen.hire(new KitchenHelper("Thao", "1993", 200));

        kitchen.hire(new Chef("Laci", "1990", 400));

        kitchen.conductAShift();
    }
}
