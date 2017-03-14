/**
 * since responces from vk are i JSON
 * the parser is needed to get separate elements of the posts
 */

package com.chistyak.control;
import org.json.*;

public class JSONParser {

    public static String parseText(String Json){
        JSONObject obj = new JSONObject(Json);
        String text = obj.getJSONArray("response")
                .getJSONObject(1)
                .getString("text");
        return text;
    }

}