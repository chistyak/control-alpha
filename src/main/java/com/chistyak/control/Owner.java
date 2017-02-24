package com.chistyak.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Krav-Ig on 24.02.2017.
 */
public class Owner {

    private String OWNER_ID;
    private HttpURLConnection connection = null;

    public String getLastPost(){
        String query = String.format(Constants.LAST_WALL_POST,
                OWNER_ID,
                Constants.ACCESS_TOKEN);//to form a query to the sever
        StringBuilder stringBuilder = new StringBuilder();//to store the result of request
        String line = null;//supporting var
        try {
                stringBuilder.delete(0, stringBuilder.length());
                connection = (HttpURLConnection) new URL(query).openConnection();//initializing connection
                connection.connect();//sending request
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));//streaming request result
                while ((line = bufferedReader.readLine()) != bufferedReader.readLine()) {//checking if page is over
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
        }catch (Exception e){
            e.printStackTrace();
        }
        return line;
    }
}
