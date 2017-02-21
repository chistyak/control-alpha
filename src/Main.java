

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static final String OWNER_ID = "34662135";
    public static final String ACCESS_TOKEN =
            "cfa87b0edab0410c395b93dc4a5f97f703239a1ac6c6fb2df788b5444f550cb6593565376be0867612f71";
    public static final String LAST_WALL_POST =
            "https://api.vk.com/method/wall.get?owner_id=%1$s&access_token=%2$s&count=1";
    public static final String OWNER_PATH = "resources/id34662135";


    public static void main(String[] args) {

        HttpURLConnection connection = null;
        String lastPost = null;
        String lastPostNew;
        String query = String.format(LAST_WALL_POST,
                OWNER_ID,
                ACCESS_TOKEN);
        StringBuilder stringBuilder = new StringBuilder();//to write here result of request(html doc) later
        String line;//supporting var

        try {

            for(/*int i = 0;i < 2; i++*/;;){
                stringBuilder.delete(0,stringBuilder.length());
                connection = (HttpURLConnection) new URL(query).openConnection();//initializing connection
                connection.connect();//sending request
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                connection.getInputStream()));//streaming request result
                while((line = bufferedReader.readLine())!= bufferedReader.readLine()){//checking if page is over
                    stringBuilder.append(line);
                    stringBuilder.append("\n");
                }
                lastPostNew = stringBuilder.toString();
                if (!lastPostNew.toString().equals(lastPost)) {
                    FileWriter writer = new FileWriter(OWNER_PATH, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(lastPostNew);
                    bufferedWriter.close();
                    lastPost = lastPostNew;
                }
                Thread.sleep(1000);
                if(lastPost.contains("бэшэнамавпа"))throw new Exception();
            }
        }catch (Throwable cause){
            cause.printStackTrace();
        }finally {
            if(connection != null)
                connection.disconnect();
        }
    }
}