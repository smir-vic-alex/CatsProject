package configs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Виктор on 20.05.2017.
 */
public class SettingFactory {

    private static volatile Map<Class<? extends Setting>, ? super Setting> settings = new HashMap<>();

    static
    {
        settings.put(ApiSetting.class, new ApiSetting("/vk-application-config.properties"));
    }

    public static <T extends Setting> T getSetting(Class<T> configKey){
        return (T) settings.get(configKey);
    }

}
