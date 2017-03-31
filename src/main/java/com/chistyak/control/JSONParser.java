/**
 * since responces from vk are i JSON
 * the parser is needed to get separate elements of the posts
 */

package com.chistyak.control;
import org.json.*;

public class JSONParser {
    /**
     * index of post info in JSON str that vk returns
     */
    public static final int INDEX_OF_POST = 1;
    /**
     * get text from post from JSON string
     * @param Json response from vk with last post info
     * @return text from that post
     */
    public static String parseText(String Json){
        JSONObject obj = new JSONObject(Json);
        String text = obj.getJSONArray("response")
                .getJSONObject(INDEX_OF_POST)
                .getString("text");
        return text;
    }

}