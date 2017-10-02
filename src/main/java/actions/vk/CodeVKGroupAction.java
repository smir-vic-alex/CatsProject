package actions.vk;

import com.vk.api.sdk.objects.GroupAuthResponse;
import entities.User;
import networks.vk.connectors.VKConnectorFactory;
import networks.vk.connectors.VKConnectorType;

/**
 *
 * Created by Виктор on 30.09.2017.
 */
public class CodeVKGroupAction extends CodeVKAction {
    @Override
    protected void getVKDataAndSave(User user, String code) throws Exception {
        GroupAuthResponse authResponse = (GroupAuthResponse) VKConnectorFactory.getConnector(VKConnectorType.GROUP).auth(code);
        networkService.saveOrUpdateVkGroupNetworkCode(user.getId(), authResponse);
    }
}
