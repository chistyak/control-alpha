import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Krav-Ig on 21.02.2017.
 */
public class Owner extends Thread{

    private String OWNER_ID = "34662135";
    private HttpURLConnection connection = null;

    public Owner(String OWNER_ID){
        this.OWNER_ID = OWNER_ID;
    }

    public void process(){
        String lastPost = "lolkek";
        String lastPostNew;
        String query = String.format(Constants.LAST_WALL_POST,
                OWNER_ID,
                Constants.ACCESS_TOKEN);
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
                    FileWriter writer = new FileWriter(String.format(Constants.OWNER_PATH, OWNER_ID), true);
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.write(lastPostNew);
                    bufferedWriter.close();
                    lastPost = lastPostNew;
                }
                Thread.sleep(1000);
                //if(lastPost.contains("бэшэнамавпа"))break;
            }
        }catch (Throwable cause){
            //cause.printStackTrace();
        }finally {
            if(connection != null)
                connection.disconnect();
        }
    }
}
