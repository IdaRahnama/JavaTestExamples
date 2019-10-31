package com.company;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;

import org.jdom2.input.SAXBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Main {

    public static void main(String[] args) throws ParseException, MalformedURLException {
        FoodList  foodlist= new FoodList();
        String fileType=args[0];



        if(fileType.contains("json")){
        parseJSONFile(fileType,foodlist);
        }
        if(fileType.contains("xml")){
            parseXMLFile(fileType,foodlist);
        }



        String s1=args[1];
        String s2="asc";
        String s3="desc";

        if (s1.equals(s2)){
             foodlist.sortasc();
             System.out.println(foodlist);

          }
        if (s1.equals(s3)){
            foodlist.sortdesc();
            System.out.println(foodlist);
        }

    }
    private static Food readEmployeeNode(Element foodNode)
    {
        String Name = foodNode.getChildText("name");
        String Price = foodNode.getChildText("price");
        String Desc = foodNode.getChildText("description");
        String Cal = foodNode.getChildText("calories");
        int result = Integer.parseInt(Cal);
        Food item= new Food(Name,Price,Desc,result);
        return item;
    }

    private static Food parsefoodObject(JSONObject food)
    {


        String Name = (String) food.get("name");
        String Price = (String) food.get("price");
        String Desc = (String) food.get("description");
        String Cal = (String) food.get("calories");
        int result = Integer.parseInt(Cal);
        Food item= new Food(Name,Price,Desc,result);
        return item;
    }


    public static void  parseXMLFile( String xmlFile, FoodList foodlist){

        Document document = getSAXParsedDocument(xmlFile);
        Element rootNode = document.getRootElement();
        rootNode.getChildren("food").forEach((emp) -> {
            foodlist.add(readEmployeeNode( (Element) emp ));
        });


    }
    public static void parseJSONFile(String file,FoodList foodlist){
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            jsonObject= (JSONObject)jsonObject.get("breakfast_menu");
            JSONArray jsonArray = (JSONArray) jsonObject.get("food");

            jsonArray.forEach( emp -> parsefoodObject( (JSONObject) emp ) );
            jsonArray.forEach((emp) -> {
                foodlist.add(parsefoodObject( (JSONObject) emp ));
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }






    private static Document getSAXParsedDocument(final String fileName)
    {
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try
        {
            document = builder.build(fileName);
        }
        catch (JDOMException | IOException e)
        {
            e.printStackTrace();
        }
        return document;
    }


}
