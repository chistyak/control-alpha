/**
 * initializer of a program
 */

package com.chistyak.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Initializer {
    /**
     * read access token from resources/resources
     * write it to Constants
     *
     * read IDs of users to observe
     * @return list of id's
     */
    public static List<String> initialize() {
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.RESOURCES)));
            Constants.ACCESS_TOKEN = bufferedReader.readLine();
            while(bufferedReader.ready())
            list.add(bufferedReader.readLine());
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
}