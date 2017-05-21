package vk;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import configs.ApiSetting;
import configs.SettingFactory;

import java.io.IOException;

/**
 * Created by Smirnov Victor on 09.04.17.
 */
public class VKClientConnectionHelper {

    public static UserActor loginUserInVK(String code) throws Exception {

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
        ApiSetting apiConfig = SettingFactory.getSetting(ApiSetting.class);

        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(apiConfig.getApplicationId(), apiConfig.getApplicationSecretKey(), apiConfig.getApplicationRedirectUri(), code)
                .execute();

        return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
    }

    public static String initialize() throws IOException{
        return SettingFactory.getSetting(ApiSetting.class).getAuthUrl();
    }

}
