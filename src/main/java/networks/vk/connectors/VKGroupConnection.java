package networks.vk.connectors;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;
import settings.vk.VKApiGroupSetting;
import settings.vk.VKApiSetting;
import settings.SettingFactory;
import exeptions.connectors.ConnectorException;
import networks.vk.clients.VKGroup;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Коннектор для группы
 * Created by Виктор on 28.05.2017.
 */
public class VKGroupConnection implements VKConnector<VKGroup> {

    private PrintStream out = System.out;
    private Scanner in = new Scanner(System.in);

    @Override
    public VKGroup login() throws ConnectorException {

        out.println(SettingFactory.getSetting(VKApiGroupSetting.class).getAuthUrl());
        String code = in.nextLine();

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
        VKApiSetting apiConfig = SettingFactory.getSetting(VKApiSetting.class);

        GroupAuthResponse authResponse;
        try {
            authResponse = vk.oauth()
                    .groupAuthorizationCodeFlow(apiConfig.getApplicationId(), apiConfig.getApplicationSecretKey(), apiConfig.getApplicationRedirectUri(), code)
                    .execute();
        }
        catch (Exception e) {
            throw new ConnectorException();
        }

        if (authResponse == null)
            throw new ConnectorException();

        return new VKGroup(new GroupActor(1, authResponse.getAccessTokens().get(1)));
    }
}
