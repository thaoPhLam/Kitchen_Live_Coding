package com.codecool.kitchen;

import com.codecool.kitchen.employee.Chef;
import com.codecool.kitchen.employee.Cook;
import com.codecool.kitchen.employee.Employee;
import com.codecool.kitchen.employee.KitchenHelper;

import java.util.LinkedList;
import java.util.List;

public class Kitchen implements IngredientProvider {
    private Chef chef;
    private List<Cook> cooks = new LinkedList<>();
    private List<KitchenHelper> kitchenHelpers = new LinkedList<>();

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
        kitchenHelpers.forEach(KitchenHelper::stockUp);
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
    public boolean provide(Ingredient ingredient) {
        for (KitchenHelper kitchenHelper : kitchenHelpers) {
            try {
                kitchenHelper.give(ingredient);
                System.out.println(
                        "Hooray, could provide " + ingredient
                        + " from " + kitchenHelper.getName()
                );

                return true;
            }
            catch (NoSuchIngredient e) {
                System.out.println(
                        "Error " + e.getMessage()
                        + " from " + kitchenHelper.getName()
                );
            }
        }

        return false;
    }
}
