import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class VKClientConnectionHelper {

    public static final String AUTHORIZATION_URL_WITH_PARAM =
                                "https://oauth.vk.com/authorize?client_id=%d&display=%s&redirect_uri=%s&response_type=%s&scope=%s&v=%s";

    public static String connectionUrl(Integer appId, String display, String redirectUri, String responseType, String scope, String version){
        return String.format(AUTHORIZATION_URL_WITH_PARAM, appId, display, redirectUri, responseType, scope, version);
    }

    public static UserActor loginUserInVK(Integer appId, String appSecretKey, String redirectUri, String code) throws Exception {

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());

        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(appId, appSecretKey, redirectUri, code)
                .execute();

        return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }

}
