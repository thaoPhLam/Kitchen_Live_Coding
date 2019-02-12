package com.codecool.kitchen;

import com.codecool.kitchen.employee.Chef;
import com.codecool.kitchen.employee.Cook;
import com.codecool.kitchen.employee.Employee;
import com.codecool.kitchen.employee.KitchenHelper;

import java.util.ArrayList;
import java.util.List;

public class Kitchen implements IngredientChecker {
    private Chef chef;
    private List<Cook> cooks = new ArrayList<>();
    private List<KitchenHelper> kitchenHelpers = new ArrayList<>();

    public void hire(Employee employee) {
        if (employee instanceof Chef) {
            this.chef = (Chef) employee;
            chef.registerProvider(this);
        } else if (employee instanceof KitchenHelper) {
            kitchenHelpers.add((KitchenHelper) employee);
        } else if (employee instanceof Cook) {
            cooks.add((Cook) employee);
        } else {
            throw new IllegalArgumentException("Unrecognized employee type: " + employee.getClass().getSimpleName());
        }
    }

    public void conductAShift() {
        kitchenHelpers.forEach(KitchenHelper::fillBasket);
        chef.cook();
        cooks.forEach(Cook::cook);
    }

    @Override
    public void doWeHaveIngredient(Ingredient ingredient) {
        for (KitchenHelper kitchenHelper : kitchenHelpers) {
            kitchenHelper.giveIngredient(ingredient);
        }
    }
}
