package com.chistyak.control;
import org.json.*;
/**
 * Created by Krav-Ig on 24.02.2017.
 */
public class JSONParser {

    public static String parseText(String Json){
        JSONObject obj = new JSONObject(Json);
        String text = obj.getJSONArray("response").getJSONObject(1).getString("text");
        return text;
    }

}
