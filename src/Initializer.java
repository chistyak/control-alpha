import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krav-Ig on 21.02.2017.
 */
public class Initializer {
    public static ArrayList<String> initialize() {
        BufferedReader bufferedReader = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.ID_LIST)));
            while(bufferedReader.ready())
            list.add(bufferedReader.readLine());
            }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return list;
    }
}