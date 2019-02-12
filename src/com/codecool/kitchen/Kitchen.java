package com.codecool.kitchen;

import com.codecool.kitchen.employee.Chef;
import com.codecool.kitchen.employee.Cook;
import com.codecool.kitchen.employee.Employee;
import com.codecool.kitchen.employee.KitchenHelper;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private Chef chef;
    private List<Cook> cooks = new ArrayList<>();
    private List<KitchenHelper> kitchenHelpers = new ArrayList<>();

    public void hire(Employee employee) {
        if (employee instanceof Chef) {
            hire((Chef) employee);
        } else if (employee instanceof KitchenHelper) {
            hire((KitchenHelper) employee);
        } else if (employee instanceof Cook) {
            hire((Cook) employee);
        } else {
            throw new IllegalArgumentException("Unrecognized employee type: " + employee.getClass().getSimpleName());
        }
    }

    public void hire(Chef chef) {
        this.chef = chef;
        chef.registerProvider(this);
    }

    public void hire(KitchenHelper kitchenHelper) {
        kitchenHelpers.add(kitchenHelper);
    }

    public void hire(Cook cook) {
        cooks.add(cook);
    }

    public void conductAShift() {
        kitchenHelpers.forEach(KitchenHelper::fillBasket);
        chef.cook();
        cooks.forEach(Cook::cook);
    }
}
