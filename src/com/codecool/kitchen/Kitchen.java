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
            //chef.registerProvider(this);
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

    /**
     * Kitchen-ben vagyunk
     * - itt vannak a chef s a helper-k
     * - a kitchen adjon infót arról,
     * h a helper-knél van e olyan ingredient (tud e szolgálni olyan ingredient-tel), amire
     * - a chef-nek szüksége van
     * - írunk egy getIngredientFromHelper(Ingredient ingredient)-t, melyben
     * végig iterálunk a kitchenHelper-eken s
     * meghívjuk rajtuk a giveIngredient(Ingredient ingredient)-t
     */
    @Override
    public boolean doWeHaveIngredient(Ingredient ingredient) {
        for (KitchenHelper kitchenHelper : kitchenHelpers) {
            kitchenHelper.giveIngredient(ingredient);
            System.out.println(
                    getClass().getSimpleName() +
                    ": could provide " + ingredient +
                            " from " + kitchenHelper.getName()
            );

            return true;
        }
        return false;
    }
}
