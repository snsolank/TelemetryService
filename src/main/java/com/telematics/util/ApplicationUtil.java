package com.telematics.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApplicationUtil {
    public static String getJsonFromObject(Object object){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
