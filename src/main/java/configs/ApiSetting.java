package configs;

/**
 * Created by Виктор on 20.05.2017.
 */
public class ApiSetting extends Setting {

    private String authUrl;
    private String applicationSecretKey;
    private Integer applicationId;
    private String applicationAuthorizeConnectionUrl;
    private String applicationDisplay;
    private String applicationRedirectUri;
    private String responseType;
    private String scope;
    private String version;

    public ApiSetting(String fileName) {
        super(fileName);
    }

    @Override
    public void refreshPropertiesByCustomConfig() {
        applicationSecretKey = getProperty("ApiConfig.application.secret.key");
        applicationId = Integer.getInteger(getProperty("ApiConfig.application.id"));
        applicationAuthorizeConnectionUrl = getProperty("ApiConfig.application.authorize.connection.url");
        applicationDisplay = getProperty("ApiConfig.application.display");
        applicationRedirectUri = getProperty("ApiConfig.redirect.uri");
        responseType = getProperty("ApiConfig.response.type");
        scope = getProperty("ApiConfig.scope");
        version = getProperty("ApiConfig.version");
        authUrl = String.format(applicationAuthorizeConnectionUrl, applicationId,
                                        applicationDisplay, applicationRedirectUri,
                                                        responseType, scope, version);
    }

    public String getAuthUrl(){
        return authUrl;
    }

    public String getApplicationSecretKey(){
        return applicationSecretKey;
    }

    public Integer getApplicationId(){
        return applicationId;
    }

    public String getApplicationAuthorizeConnectionUrl(){
        return applicationAuthorizeConnectionUrl;
    }

    public String getApplicationDisplay(){
        return applicationDisplay;
    }

    public String getApplicationRedirectUri(){
        return applicationRedirectUri;
    }

    public String getResponseType(){
        return responseType;
    }

    public String getScope(){
        return scope;
    }

    public String getVersion(){
        return version;
    }

}
