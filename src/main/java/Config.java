import javafx.application.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class Config {

    //TODO заменить на асихронную мапу
    public static Properties properties = new Properties();

    public static void loadProperties(){
        try(InputStream inputStream = Application.class.getResourceAsStream("/vk-application-config.properties")){
            properties.load(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
