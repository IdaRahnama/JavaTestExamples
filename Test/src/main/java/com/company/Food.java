package com.company;

public class Food {
    private String name;
    private String price;
    private String description;
    private int calories;

    @Override
    public String toString() {
        return "Food{" + "name=" + name + ", price=" + price + ", description=" + description + ", calories=" + calories + '}'+ "\n";
    }

    public Food(String name, String price, String description, int calories) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

}
