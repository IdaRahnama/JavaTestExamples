package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void checkJsonAndXMLAreEqual() {
        FoodList f=new FoodList();
        FoodList f2=new FoodList();
        Main.parseJSONFile("menu.json",f);
        Main.parseXMLFile("menu.xml",f2);
        String s1=f.toString();
        String s2=f2.toString();


        // Assert
        Assert.assertEquals(s1,s2);


    }

    @Test
    public void CheckParseXMLAnswer() {
        Food test1=new Food("Belgian Waffles","$5.95","Two of our famous Belgian Waffles with plenty of real maple syrup",650);
        Food test2=new Food("Strawberry Belgian Waffles","$7.95","Light Belgian waffles covered with strawberries and whipped cream",900);
        Food test3=new Food("Berry-Berry Belgian Waffles","$8.95","Light Belgian waffles covered with an assortment of fresh berries and whipped cream",900);
        Food test4=new Food("French Toast","$4.50","Thick slices made from our homemade sourdough bread",600);
        Food test5=new Food("Homestyle Breakfast","$6.95","Two eggs, bacon or sausage, toast, and our ever-popular hash browns",950);
        FoodList foods= new FoodList();
        foods.add(test1);
        foods.add(test2);
        foods.add(test3);
        foods.add(test4);
        foods.add(test5);
        FoodList f=new FoodList();
        Main.parseXMLFile("menu.xml",f);
        String s1=f.toString();
        String s3=foods.toString();
        Assert.assertEquals(s1,s3);
    }

    @Test
    public void CheckJSONParseAnswer() {
        Food test1=new Food("Belgian Waffles","$5.95","Two of our famous Belgian Waffles with plenty of real maple syrup",650);
        Food test2=new Food("Strawberry Belgian Waffles","$7.95","Light Belgian waffles covered with strawberries and whipped cream",900);
        Food test3=new Food("Berry-Berry Belgian Waffles","$8.95","Light Belgian waffles covered with an assortment of fresh berries and whipped cream",900);
        Food test4=new Food("French Toast","$4.50","Thick slices made from our homemade sourdough bread",600);
        Food test5=new Food("Homestyle Breakfast","$6.95","Two eggs, bacon or sausage, toast, and our ever-popular hash browns",950);
        FoodList foods= new FoodList();
        foods.add(test1);
        foods.add(test2);
        foods.add(test3);
        foods.add(test4);
        foods.add(test5);
        FoodList f=new FoodList();
        Main.parseJSONFile("menu.json",f);
        String s1=f.toString();
        String s3=foods.toString();
        Assert.assertEquals(s1,s3);
    }
}