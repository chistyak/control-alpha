/**
 * class that realizes interactions
 * program - web
 * and
 * program - files storing information about saved posts
 */

package com.chistyak.control;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Owner {

    private String OWNER_ID;
    private HttpURLConnection connection = null;

    public Owner(String OWNER_ID){
        this.OWNER_ID = OWNER_ID;
    }

    public boolean isPresent(){
        File f = new File(String.format(Constants.OWNER_PATH, OWNER_ID));
        if(f.exists())
            return true;
        else
            return false;
    }

    public void initialize(){
        try {
            FileWriter writer = new FileWriter(String.format(Constants.OWNER_PATH, OWNER_ID));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(HTMLGenerator.createBasic());
            bufferedWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

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
        }finally {
            if(connection!=null) connection.disconnect();
        }
        return stringBuilder.toString();
    }

    public void savePost(String string){

        FileWriter writer = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format(Constants.OWNER_PATH, OWNER_ID)));
            String x = bufferedReader.readLine();
            bufferedReader.close();
            x = HTMLGenerator.insertion(x, JSONParser.parseText(string));
            writer = new FileWriter(String.format(Constants.OWNER_PATH, OWNER_ID));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(x);
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
