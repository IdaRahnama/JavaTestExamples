package com.company;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class FoodList {
    private List<Food>  foodlist= new ArrayList<>();


    public FoodList(List<Food> foodlist) {
        this.foodlist=foodlist;
    }

    public FoodList() {
        this.foodlist= new ArrayList<>();
    }

    public void setFoodlist(List<Food> foodlist) {
        this.foodlist = foodlist;
    }

    public List<Food> getFoodlist() {
        return foodlist;
    }

    public void sortasc(){
        this.foodlist.sort(Comparator.comparing(e -> e.getName()));

    }



    public void sortdesc(){


        Comparator<Food> comparator = Comparator.comparing(e -> e.getName());
        this.foodlist.sort(comparator.reversed());

    }

    public boolean add(Food e) {
        return foodlist.add(e);
    }

    @Override
    public String toString() {
        return "Foodlist=" + foodlist ;
    }

}
