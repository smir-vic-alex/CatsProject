package networks.vk.connectors;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;
import settings.vk.VKApiSetting;
import settings.SettingFactory;
import exeptions.connectors.ConnectorException;

/**
 * Коннектор для группы
 * Created by Виктор on 28.05.2017.
 */
public class VKGroupConnection implements VKConnector<GroupAuthResponse> {

    @Override
    public GroupAuthResponse auth(String code) throws ConnectorException {

        VkApiClient vk = new VkApiClient(HttpTransportClient.getInstance());
        VKApiSetting apiConfig = SettingFactory.getSetting(VKApiSetting.class);

        GroupAuthResponse authResponse;
        try {
            authResponse = vk.oauth()
                    .groupAuthorizationCodeFlow(apiConfig.getApplicationId(), apiConfig.getApplicationSecretKey(), apiConfig.getApplicationRedirectUri(), code)
                    .execute();
        } catch (Exception e) {
            throw new ConnectorException();
        }

        if (authResponse == null)
            throw new ConnectorException();

        return authResponse;
    }
}
