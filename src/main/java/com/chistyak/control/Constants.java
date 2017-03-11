/**
 * list of constants
 * needed for program to work
 */

package com.chistyak.control;


public class Constants {
    public static  String ACCESS_TOKEN;//тут поправить обязательно нужно

    public static final String LAST_WALL_POST =
            "https://api.vk.com/method/wall.get?owner_id=%1$s&access_token=%2$s&count=1";
    public static final String OWNER_PATH = "resources/id%1$s.html";
    public static final String RESOURCES = "resources/resources";
}
