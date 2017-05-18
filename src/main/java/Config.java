import property.Property;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class Config {

    private static Map<String,String> map;

    public static void loadProperties(){
        try(InputStream inputStream = Property.class.getResourceAsStream("/vk-application-config.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);

            map = new HashMap<>();
            for (Map.Entry entry :properties.entrySet()){
               map.put(entry.getKey().toString(),entry.getValue().toString());
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String, String> getProperties() {
        return map;
    }

}
