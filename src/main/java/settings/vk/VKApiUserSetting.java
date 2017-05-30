package settings.vk;

/**
 * Настройки для пользователя vk
 * Created by Виктор on 31.05.2017.
 */
public class VKApiUserSetting extends VKApiSetting {

    private String authUrl;
    private String applicationAuthorizeConnectionUrl;
    private String applicationDisplay;
    private String responseType;
    private String scope;

    public VKApiUserSetting(String fileName) {
        super(fileName);
    }

    @Override
    public void refreshPropertiesByCustomConfig() {
        applicationAuthorizeConnectionUrl = getProperty("settings.vk.VKApiSetting.user.application.authorize.connection.url");
        applicationDisplay = getProperty("settings.vk.VKApiSetting.user.application.display");
        responseType = getProperty("settings.vk.VKApiSetting.user.response.type");
        scope = getProperty("settings.vk.VKApiSetting.user.scope");
        authUrl = String.format(applicationAuthorizeConnectionUrl, getApplicationId(),
                applicationDisplay, getApplicationRedirectUri(),
                responseType, scope, getVersion());
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public String getApplicationAuthorizeConnectionUrl() {
        return applicationAuthorizeConnectionUrl;
    }

    public String getApplicationDisplay() {
        return applicationDisplay;
    }

    public String getResponseType() {
        return responseType;
    }

    public String getScope() {
        return scope;
    }
}
