/**
 * list of constants
 * needed for program to work
 */

package com.chistyak.control;


public class Constants {
    /**
     * access token given by vk
     * to access server requests
     */
    public static  String ACCESS_TOKEN;//тут поправить обязательно нужно
    /**
     * request to get last post
     * from the wall of selected user
     */
    public static final String LAST_WALL_POST =
            "https://api.vk.com/method/wall.get?owner_id=%1$s&access_token=%2$s&count=1";
    /**
     * the path to the file that contains
     * saved posts of selected user
     */
    public static final String OWNER_PATH = "resources/id%1$s.html";
    /**
     * the path to the package
     * with all needed resources
     */
    public static final String RESOURCES = "resources/resources";
    /**
     * message to enter to stop program
     */
    public static final String STOPPING_MESSAGE = "STOP";
}