package networks.vk.connectors;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import entities.User;
import entities.VKNetwork;
import hibernate.services.NetworksService;
import settings.vk.VKApiSetting;
import settings.SettingFactory;
import exeptions.connectors.ConnectorException;
import networks.vk.clients.VKUser;
import utils.WebContext;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Коннектор для логина пользователем
 * Created by Smirnov Victor on 09.04.17.
 */
public class VKUserConnector implements VKConnector<UserAuthResponse> {

    public UserAuthResponse auth(String code) throws ConnectorException {

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
        VKApiSetting apiConfig = SettingFactory.getSetting(VKApiSetting.class);
        UserAuthResponse authResponse;
        try {
            authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(apiConfig.getApplicationId(), apiConfig.getApplicationSecretKey(), apiConfig.getApplicationRedirectUri(), code)
                    .execute();

        } catch (Exception e) {
            throw new ConnectorException();
        }

        if (authResponse == null)
            throw new ConnectorException();

        return authResponse;
    }

}
