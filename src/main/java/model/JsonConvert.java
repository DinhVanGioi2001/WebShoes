/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;

/**
 *
 * @author Hung Dinh
 */
public class JsonConvert {
    private Gson gson = new Gson();
    private String jsonString = "";

    public JsonConvert(BufferedReader bf) {
        jsonString = toJsonString(bf);
        
    }

    private String toJsonString(BufferedReader bf) {
        String jsonS= "";
        String line = null;
        try {
            while((line = bf.readLine()) != null) {
                jsonS += line;
            }
        } catch (Exception e) {
        }
        return jsonS.trim();
    }
    
    public Object convertJsonToObject(Object o) {
        Object product = gson.fromJson(jsonString, o.getClass());
        System.out.println(jsonString);
        System.out.println(o.getClass());
        return product;
    }
    
    public JsonObject getJsonObject() {
        JsonParser parser = new JsonParser();
        return parser.parse(jsonString).getAsJsonObject();
    }
    
    public String getJsonString() {
        return jsonString;
    }
}
