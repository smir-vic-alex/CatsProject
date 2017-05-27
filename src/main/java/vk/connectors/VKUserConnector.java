package vk.connectors;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import configs.ApiSetting;
import configs.SettingFactory;
import exeptions.connectors.VKUserConnectorException;
import vk.clients.VKUser;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Коннектор для логина пользователем
 * Created by Smirnov Victor on 09.04.17.
 */
public class VKUserConnector implements VKConnector <VKUser> {

    private PrintStream out = System.out;
    private Scanner in = new Scanner(System.in);

    public VKUser login() throws VKUserConnectorException {

        out.println(SettingFactory.getSetting(ApiSetting.class).getAuthUrl());
        String code = in.nextLine();

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
        ApiSetting apiConfig = SettingFactory.getSetting(ApiSetting.class);

        UserAuthResponse authResponse;
        try {
            authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(apiConfig.getApplicationId(), apiConfig.getApplicationSecretKey(), apiConfig.getApplicationRedirectUri(), code)
                    .execute();

        }
        catch (Exception e) {
            throw new VKUserConnectorException();
        }

        if (authResponse == null)
            throw new VKUserConnectorException();

        return new VKUser(new UserActor(authResponse.getUserId(), authResponse.getAccessToken()));
    }

}
