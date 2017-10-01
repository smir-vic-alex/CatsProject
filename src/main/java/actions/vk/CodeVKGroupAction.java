package actions.vk;

import com.vk.api.sdk.objects.GroupAuthResponse;
import entities.User;
import networks.vk.connectors.VKConnectorFactory;
import networks.vk.connectors.VKConnectorType;

/**
 * 50857f5886cb068c36f8f366fd43f92774657d4b7a88fa64020e7ed5ab596ed76aff991a8d1ccb0c65379
 * Created by Виктор on 30.09.2017.
 */
public class CodeVKGroupAction extends CodeVKAction {
    @Override
    protected void getVKDataAndSave(User user, String code) throws Exception {
        GroupAuthResponse authResponse = (GroupAuthResponse) VKConnectorFactory.getConnector(VKConnectorType.GROUP).auth(code);
        networkService.saveOrUpdateVkGroupNetworkCode(user.getId(), authResponse);
    }
}
