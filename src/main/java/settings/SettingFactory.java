package settings;

import settings.vk.VKApiGroupSetting;
import settings.vk.VKApiSetting;
import settings.vk.VKApiUserSetting;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика настроек
 * Created by Виктор on 20.05.2017.
 */
public class SettingFactory {

    private static volatile Map<Class<? extends Setting>, ? super Setting> settings = new HashMap<>();

    static {
        settings.put(VKApiSetting.class, new VKApiSetting("/vk/vk-application-config.properties"));
        settings.put(VKApiUserSetting.class, new VKApiUserSetting("/vk/vk-application-config.properties"));
        settings.put(VKApiGroupSetting.class, new VKApiGroupSetting("/vk/vk-application-config.properties"));
    }

    public static <T extends Setting> T getSetting(Class<T> configKey) {
        return (T) settings.get(configKey);
    }

}
