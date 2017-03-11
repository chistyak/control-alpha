/**
 * initializer of a program
 */

package com.chistyak.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Initializer {


    public static ArrayList<String> initialize() {
        BufferedReader bufferedReader = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.RESOURCES)));
            Constants.ACCESS_TOKEN = bufferedReader.readLine();
            while(bufferedReader.ready())
            list.add(bufferedReader.readLine());
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
